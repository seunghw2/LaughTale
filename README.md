![logo](https://github.com/j-yong98/j-yong98/assets/120557342/eaee8660-0288-46a1-aeed-f6b2c51676e6)

---
[1. 서비스 개요](#1-서비스-개요)  
[2. 팀원 소개](#2-팀원-소개)  
[3. 기술 스택](#3-기술-스택)  
[4. 서비스 아키텍처](#4-서비스-아키텍처)  
[5. ERD](#5-erd)  
[6. 디렉토리 구조](#6-디렉토리-구조)  
[7. API 명세서](#7-api-명세서)  
[8. 서비스 설명](#8-서비스-설명)

---

## 1. 서비스 개요
만화를 통해 일본어 어휘를 자연스럽게 익히도록 돕는 만화 기반의 일본어 학습 플랫폼입니다.

## 2. 주요 기능
- 다양한 일본어 만화 제공
    - 다양한 장르와 스타일의 일본어 만화를 제공
- 클릭 번역
    - 만화를 보면서 모르는 단어를 클릭하면 해석과 단어 설명을 제공하며, 해당 단어를 단어장에 추가할 수 있습니다.
- 학습 기능
    - 만화 퀴즈를 제공하여 사용자의 학습을 돕습니다.
- 마이페이지
    - 단어장 기능 제공

## 3. 기술 스택

### IDE

<img src="	https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white">
<img src="https://img.shields.io/badge/WebStorm-000000?style=for-the-badge&logo=WebStorm&logoColor=white" alt="webstorm">
<img src="https://img.shields.io/badge/PyCharm-000000.svg?&style=for-the-badge&logo=PyCharm&logoColor=white" alt="pycharm">

### Infra

<img src="https://img.shields.io/badge/Ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white">
<img src="https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white">
<img src="https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=nginx&logoColor=white">
<img src="https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=Jenkins&logoColor=white">

### Frontend
<img src="https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB">
<img src="https://img.shields.io/badge/Tailwind_CSS-38B2AC?style=for-the-badge&logo=tailwind-css&logoColor=white">


### Backend
<img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot">
<img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white">
<img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white">
<img src="https://img.shields.io/badge/spring data jpa-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white">
<img src="https://img.shields.io/badge/Spring_webflux-F2F4F9?style=for-the-badge&logo=spring-boot">
<img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white" alt="">


### Python Server
<img src="	https://img.shields.io/badge/fastapi-109989?style=for-the-badge&logo=FASTAPI&logoColor=white">
<img src="	https://img.shields.io/badge/mecab-ff1709?style=for-the-badge&logoColor=white">
<img src="https://img.shields.io/badge/OpenCV-27338e?style=for-the-badge&logo=OpenCV&logoColor=white">


### Tools
<img src="https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=Jira&logoColor=white">
<img src="	https://img.shields.io/badge/GitLab-330F63?style=for-the-badge&logo=gitlab&logoColor=white" alt="">
<img src="https://img.shields.io/badge/Mattermost-0058CC?style=for-the-badge&logo=Mattermost&logoColor=white">

## 4. 서비스 아키텍처
![Architecture](https://github.com/j-yong98/j-yong98/assets/120557342/eec4548c-5479-40b9-a11c-b3c603f06617)

## 5. 팀 소개

| 이름 | 역할 | 개발 내용 |
| --- | --- | --- |
| 정승환 (팀장) | Infra | - **CICD 구축**<br> &emsp; - Jenkins 연결, 파이프라인 작성<br> &emsp; - gitlab 연결<br> &emsp; - MultiBranch Pipeline을 이용하여 front, back CI/CD 분리<br> - **도커 구축**<br> &emsp; - SpringBoot, React, MySQL<br> &emsp; - Nginx 구축<br> &emsp; &emsp; - HTTPS 적용<br> &emsp; &emsp; - 리버스 프록시 설정 |
| 김재찬 | FrontEnd | - 로그인 및 인증 라우터 구현<br> - 페이지 UI/UX 디자인<br>   - HOME 페이지 디자인<br>   - CHAPTER 페이지 UI/UX<br>   - VIEWER 페이지 UI/UX |
| 김도형 | FrontEnd | **UI/UX 디자인**<br> &emsp; - 메인페이지, 만화 업로드 페이지 구현<br> &emsp; - 사용자 학습 데이터 시각화<br> &emsp; - d3.js를 통한 망각곡선 그래프 제작<br> &emsp; - 파비콘 디자인<br> &emsp; - 스크롤 애니메이션 구현 |
| 정연미 | BackEnd | - **UI/UX 디자인**<br> &emsp; - 퀴즈 페이지 (로딩, 풀이, 결과)<br> &emsp; - 마이페이지, 단어장<br> &emsp; - 메인 페이지<br> - **초기 프로젝트 생성 및 설계** |
| 양진우 | BackEnd | - **SpringBoot 서버 RestAPI 작성**<br> - **데이터베이스 설계**<br> - **사용자 맞춤형 퀴즈 생성 로직 설계 및 구현**<br> - **사용자 실력 측정 로직 설계 및 구현**<br> - **단어 빈도수 기반 난이도 측정**<br> - **UI/UX 메인페이지 구현** |
| 최재용 | BackEnd | - **데이터 처리**<br> - **만화 분석 로직 설계 및 구현**<br> - **Spring boot API 작성 (회원 관리 및 단어장)**<br> - **Spring Security를 이용한 사용자 인증/인가**<br> - **만화 분석 페이지 UI/UX** |

## 6. ERD
![ERD](https://github.com/j-yong98/j-yong98/assets/120557342/16811f7b-29b3-498f-8c20-c568e0d80d5a)

## 7. 디렉토리 구조
```text
Frontend
├── apis
├── assets
│   ├── badge
│   ├── images
│   ├── main
│   ├── mainpageimage
│   │   └── mangas
│   └── samples
├── components
│   ├── admin
│   ├── analyze
│   ├── cartoon
│   ├── chart
│   ├── common
│   ├── login
│   ├── main
│   │   └── sampleData
│   └── mypage
├── constants
├── hooks
├── layout
│   └── GlobalLayout
├── pages
│   ├── admin
│   ├── analyze
│   ├── cartoon
│   │   └── manga
│   ├── error
│   ├── login
│   ├── logout
│   ├── main
│   ├── mypage
│   │   └── word
│   └── newmain
├── parts
├── routes
├── stores
├── styles
├── types
│   └── common
└── utils
```
```text
Backend
├── chapter
├── common
├── cut
├── dictionary
├── ebbinghaus
├── jako
├── manga
├── member
├── parser
├── position
├── quiz
├── security
├── speech
├── utils
├── viewhistory
├── wordbook
├── worddata
├── wordhistory
└── wordlist
```
## 8. API 명세서
![image](https://github.com/j-yong98/j-yong98/assets/120557342/ec924eb3-157c-4ca6-9031-4e7182770028)
[명세서 보기](https://www.notion.so/seunghw2/API-LAUGH-TALE-d955ba75e622445d846eed9ca94840db)

## 9. 서비스 설명
![main-2024-04-03](https://github.com/j-yong98/j-yong98/assets/120557342/78f1b83a-d0d9-46e2-82d8-3aefc0963c88)
![manga-list-2024-4-4](https://github.com/j-yong98/j-yong98/assets/120557342/7d0df80e-2f58-4e10-8409-0758c1517415)
![info-2024-4-4](https://github.com/j-yong98/j-yong98/assets/120557342/6ed7142b-318b-4161-ad62-898d6a0a7012)
![view-2024-4-4](https://github.com/j-yong98/j-yong98/assets/120557342/c42d529e-6beb-4218-b50c-73d5d9aab247)
![quiz-2024-4-4](https://github.com/j-yong98/j-yong98/assets/120557342/826d5343-9f75-46c5-80c8-170399a3cbc5)
![mypage-1-2024-4-4](https://github.com/j-yong98/j-yong98/assets/120557342/1568e0e3-0b09-4d49-9141-b1e85fe337b0)
![word-book-2024-4-4](https://github.com/j-yong98/j-yong98/assets/120557342/88087e12-c812-47e6-9af6-4afd3c13a687)
![admin-2024-4-4](https://github.com/j-yong98/j-yong98/assets/120557342/3f117a28-813e-446b-b53e-908909bf38c7)
![analyze-2024-4-4](https://github.com/j-yong98/j-yong98/assets/120557342/71b6d581-51e7-4144-bc45-f6facc7d8b2a)
