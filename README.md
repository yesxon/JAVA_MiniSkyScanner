# Mini SkyScanner ✈

> 우리FISA AI 엔지니어링 JAVA 미니 프로젝트


## Overview

미니 스카이스캐너는 여행 여정을 탐색하고 예약하는 서비스입니다.

비행 일정 뿐만 아니라 국가 정보로 여행 계획을 짜는 데 도와드릴게요.

미니 스카이스캐너와 함께 가상 여행을 시작해 보세요! 🛫

---

## Team members

- 박예선 [:octocat:](http://github.com/yesxon) [:mailbox:parkyeseon@gmail.com](mailto::mailbox:parkyeseon@gmail.com)
- 이한슬 [:octocat:](http://github.com/LHSeul) [:mailbox:](mailto::mailbox:tngudzzz@gmail.com)lhsp936@gmail.com
- 한상민 [:octocat:](https://github.com/Han-sann-min) [:mailbox:](mailto::mailbox:sggnology@gmail.com)sorkdhks33@gmail.com
- 김찬기 [:octocat:](http://github.com/K-Changer) [:mailbox:](mailto::mailbox:sggnology@gmail.com)changi9734@gmail.com

---

## Trouble Shooting

- 이클립스에서 git 브랜치를 생성하여 버전 관리할 때  충돌이 빈번히 발생→ 터미널로 해결
- 국가 선택 메뉴가 2번 반복되는 현상 → setNation이라 2번 국가를 받아오도록 되어 있었음. 이를 getNation으로 변경
- UML 클래스 다이어그램 클래스 13개 간의 관계 표현이 어려웠음 → '클래스 속성'과 '클래스 메서드’를 분리

---

## Review

- **Keep**
    - 자바와 DB 연동, 자바에서 삽입[회원 가입/예약 내역 삽입]과 조회[비행기 시간표/예약 내역 조회]에 성공
    - 연동 전 버전에서 예약 시 나라 선택이 두번 나오는 문제를 해결.
    - Lombok을 이용해 코드(getter/setter) 간소화.
    - 빌드 도구 Maven 사용
    - 깃을 활용하여 팀원 간 기능 분업 및 클래스 연동을 효과적으로 진행함.
    - 항공 예약 서비스의 핵심 기능 (회원가입, 예약, 예약 내역 확인, 여행지 정보 표현) 구현 완료.
    - 클래스 활용 및 main 함수 호출을 통한 서비스 흐름 이해.
    - DB 연동 로직을 활용하여 재사용 가능한 클래스 및 함수 개발로 능력 향상.
    - 협업에서 깃의 활용을 경험하고, branch, 커밋, 푸쉬, 풀 등을 통한 협업 능력 향상.
    
- **Problem**
    - 회원가입하면 바로 로그인 되는 흐름으로 고정되어 있음 .
    - 이메일과 id를 분리하였고, 이메일을 받아오는 기능이 없음.
    - PK인 예약번호의 값이 중복될 경우, 예외 처리를 못함.
    - 현재 콘솔 기반 프로그램의 한계로 인해 기능에만 초점이 맞춰져 있음.
    - 과거로 여행갈 수 있음.

- **Try**
    - main을 더 깔끔하게 구성하기
    - DB 개선 - birthDate의 데이터 타입
    - 여행 일정 기능 개선
    - 회원가입/로그인을 분리하여 회원이라면 접속하여 예약/예약 조회하도록
    - 예약 내역 삭제/회원 탈퇴 기능 추가
    - 이메일도 입력 받아올 수 있는 기능 추가
    - UI/UX를 고려한 사용자 친화적인 웹 서비스로 전환
    - DB 연동에 외부 항공편 API 등을 활용하여 항공편 예약이 가능한 서비스 개발 및 배포
    - 각국의 실시간 환율을 적용하여 동적 시스템으로 전환
