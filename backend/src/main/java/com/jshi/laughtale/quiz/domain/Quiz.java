package com.jshi.laughtale.quiz.domain;

import com.jshi.laughtale.member.domain.Member;
import com.jshi.laughtale.wordlist.domain.WordList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Getter
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer problemNo;
    @Column
    private Integer answerNo;
    @Column
    private String optionA;
    @Column
    private String optionB;
    @Column
    private String optionC;
    @Column
    private String optionD;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    //정답에 해당하는 단어
    @ManyToOne
    @JoinColumn(name = "word_list_id")
    private WordList wordList;


}
