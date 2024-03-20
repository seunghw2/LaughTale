package com.jshi.laughtale.quiz.service;

import com.jshi.laughtale.cut.domain.Cut;
import com.jshi.laughtale.ebbinghaus.EbbinghausUtil;
import com.jshi.laughtale.member.service.MemberService;
import com.jshi.laughtale.position.domain.Position;
import com.jshi.laughtale.quiz.domain.Quiz;
import com.jshi.laughtale.quiz.dto.QuizWord;
import com.jshi.laughtale.quiz.repository.QuizRepository;
import com.jshi.laughtale.speech.domain.Speech;
import com.jshi.laughtale.speech.service.SpeechService;
import com.jshi.laughtale.worddata.service.WordDataService;
import com.jshi.laughtale.wordhistory.domain.WordHistory;
import com.jshi.laughtale.wordhistory.service.WordHistoryService;
import com.jshi.laughtale.wordlist.service.WordListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final WordHistoryService wordHistoryService;
    private final MemberService memberService;
    private final WordListService wordListService;
    private final EbbinghausUtil ebbinghausUtil;
    private final SpeechService speechService;
    private final WordDataService wordDataService;

    public List<QuizWord> makeNewQuiz(Long memberId, int chapterId) {

        //사용자 실력을 받아온다
        int memberLevel = memberService.getMemberLevel(
                wordHistoryService.getMemberWordHistory(memberId));

        //사용자 실력에 해당하는 단어목록을 가져온다
        List<QuizWord> quizWordList = wordListService.findWordListsWithLevel(memberLevel);
        //TODO : 단어가 모자랄 경우의 로직을 추가해야함
        // 일단은 단어가 충분하다고 가정하고 진행한다

        //위 단어들 중 사용자가 학습한 단어 목록을 가져온다
        //TODO : 같은 챕터에 중복어휘가 있으면 어떻게 구분하냐
        // 일단은 무시하고 지나간다
        List<Long> wordIdList = new ArrayList<>();
        for (QuizWord quizWord : quizWordList)
            wordIdList.add(quizWord.getWordDataId());
        List<WordHistory> userWordHistory = wordHistoryService.findByWordIdIn(wordIdList);

        //사용자가 학습한 단어 목록을 wordHistoryMap에 저장한다
        Map<String, WordHistory> wordHistoryMap = new HashMap<>();
        for (WordHistory wordHistory : userWordHistory)
            wordHistoryMap.put(wordHistory.getWordData().getWord(), wordHistory);

        //각 단어를 사용자의 가중치에서 찾는다
        int sum = 0;
        for (QuizWord quizWord : quizWordList) {
            if (wordHistoryMap.containsKey(quizWord.getAnswerWord())) {
                WordHistory word = wordHistoryMap.get(quizWord.getAnswerWord());
                int weight = (int) (100 * ebbinghausUtil.calculateMemory(word.getStudyDate(), word.getStudyCnt()));
                quizWord.setWeight(100 - weight);
                sum += 100 - weight;
            } else {
                quizWord.setWeight(100);
                sum += 100;
            }
        }

        // TODO : offset계산해야한다

        //문제에 출제할 단어를 고른다
        List<QuizWord> selectedQuizWords = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //랜덤 숫자를 뽑는다
            int nextWordIndex = (int) (Math.random() * sum) + 1;
            int idx = 0;
            int sumWeight = 0;
            while (idx < quizWordList.size() && quizWordList.get(idx).getWeight() + sumWeight < nextWordIndex)
                idx++;
            QuizWord selectedQuizWord = quizWordList.get(idx);
            quizWordList.remove(idx);
            sum -= selectedQuizWord.getWeight();
            selectedQuizWords.add(selectedQuizWord);
        }

        //각 문제에 필요한 정보를 추가한다
        for (QuizWord selectedQuizWord : selectedQuizWords) {
            //단어가 등장한 말풍선의 좌표를 구한다
            Speech speech = speechService.findById(selectedQuizWord.getSpeechId());
            Position position = speech.getPosition();
            selectedQuizWord.addPositionToQuizWord(position);

            //단어가 등장한 이미지 URL을 구한다
            Cut cut = speech.getCut();
            String imageUrl = cut.getImageUrl();
            selectedQuizWord.setImageUrl(imageUrl);

            //각 문제에 보기를 추가
            //TODO : 사용자 레밸에 맞는 단어중에서 보기를 만들었지만, 현재 챕터에서 나온 단어들중에서 선택하는게 좋다
            Set<String> optionSet = new HashSet<>();
            while (optionSet.size() < 3) {
                int randomIdx = (int) (Math.random() * quizWordList.size());
                optionSet.add(quizWordList.get(randomIdx).getAnswerWord());
            }
            selectedQuizWord.setOptionSet(optionSet.stream().toList());

            //단어 뜻을 추가한다
            selectedQuizWord.setDefinition(wordDataService.findDefinitionByWord(selectedQuizWord.getAnswerWord()));

            //각 퀴즈의 정답을 고른다
            int answerNo = (int) (Math.random() * 4) + 1;
            selectedQuizWord.setAnswerNo(answerNo);

            //몇번 보기에 어떤 단어가 들어있는지를 생성한다
            String[] option = new String[4];
            makeOptions(selectedQuizWord, answerNo, option);
            selectedQuizWord.setOption(option);
        }
        return selectedQuizWords;
    }

    public void saveNewQuiz(List<QuizWord> quizList, Long memberId) {
        int problemNo = 1;
        //quizList에 퀴즈는 5개 들어있다.
        for (QuizWord quizWord : quizList) {

            //DB에 저장한다
            quizRepository.save(Quiz.builder()
                    .problemNo(problemNo++)
                    .wordList(wordListService.findByWordDataIdAndSpeechId(quizWord.getWordDataId(), quizWord.getSpeechId()))
                    .member(memberService.findById(memberId))
                    .optionA(quizWord.getOption()[0])
                    .optionB(quizWord.getOption()[1])
                    .optionC(quizWord.getOption()[2])
                    .optionD(quizWord.getOption()[3])
                    .build());
        }
    }

    private static void makeOptions(QuizWord quizWord, int answerNo, String[] option) {
        int optIdx = 0;
        for (int i = 1; i <= 4; i++)
            if (answerNo == i)
                option[i - 1] = quizWord.getAnswerWord();
            else
                option[i - 1] = quizWord.getOptionSet().get(optIdx++);
    }
}
