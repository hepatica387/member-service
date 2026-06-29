# 회원관리 플랫폼 (Member-Service)

## 📋 프로젝트 개요

**member-service**는 Spring Boot의 기본 구조와 CRUD 흐름을 이해하기 위해 개발되는 회원관리 플랫폼입니다.

- **개발 목적**: Spring Boot MVC 패턴의 실무적 이해 및 CRUD 기능 구현
- **아키텍처**: MVC (Model-View-Controller) 패턴
- **데이터베이스**: MySQL
- **버전관리**: Git

---

## 🏗️ 프로젝트 구조

```
member-service
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/memberService/member_service/
│   │   │       ├── MemberServiceApplication.java
│   │   │       ├── controller/          # 요청 처리 담당
│   │   │       ├── service/             # 비즈니스 로직 처리
│   │   │       ├── repository/          # 데이터 저장/조회 (Spring Data JPA)
│   │   │       └── domain/              # 회원 데이터 객체
│   │   └── resources/
│   │       ├── application.properties   # 설정 파일
│   │       └── templates/               # HTML 템플릿
│   │           ├── home.html
│   │           └── members/
│   │               ├── list.html        # 회원 목록
│   │               ├── add.html         # 회원 등록
│   │               ├── detail.html      # 회원 상세
│   │               └── edit.html        # 회원 수정
│   └── test/
│       └── java/com/memberService/member_service/
│           └── MemberServiceApplicationTests.java
├── build.gradle
├── settings.gradle
├── gradlew
└── README.md
```

---

## 🛠️ 기술 스택

- **Framework**: Spring Boot
- **Build Tool**: Gradle
- **Database**: MySQL
- **ORM**: Spring Data JPA
- **Template Engine**: Thymeleaf
- **Language**: Java

---

## 📐 MVC 패턴 설명

| 계층 | 역할 |
|------|------|
| **Controller** | 사용자의 요청을 받고 응답을 반환 |
| **Service** | 핵심 기능 및 비즈니스 로직 처리 |
| **Repository** | 데이터베이스와의 데이터 저장/조회 담당 |
| **Domain** | 회원 데이터 객체 (Model) |
| **View** | HTML 화면 (Thymeleaf 템플릿) |

---

## 📅 개발 일정

### 1차: ~ 7월 8일 ⚙️
**CRUD 기능 구현**

| 기능 | 담당자 | 설명 |
|------|-------|------|
| **C (Create)** | 석진 | 회원 등록 기능 |
| **R (Read)** | 석진 | 회원 조회 기능 |
| **U (Update)** | 동규 | 회원 수정 기능 |
| **D (Delete)** | 동규 | 회원 삭제 기능 |

### 2차: ~ 7월 20일 🔍
- 코드 리뷰
- 코드 리팩토링
- 코드 테스트
- 서비스 아이디어 회의 → 추가 기능 정의

### 3차: ~ 7월 29일 🎯
- 추가 기능 구현 (미정)
- 기능 테스트
- 최종 완성
- GitHub Push

---

## 🚀 개발 방식

1. **단계별 기능 구현**: 각 기능을 순차적으로 구현
2. **리팩토링**: 코드 품질 개선 및 최적화
3. **테스트**: 기능 동작 검증
4. **기능 확장**: 추가 요구사항 반영

---

## 💾 버전관리 규칙

- **기본 브랜치**: main
- **커밋 규칙**: 각자 코딩 작업 후 Git에 올림
- **코드 리뷰**: 주기적인 리팩토링 및 리뷰 진행

---

## 🔧 설치 및 실행

### 사전 요구사항
- Java 11 이상
- MySQL 설치 및 실행
- Gradle

### 1. 프로젝트 클론
```bash
git clone https://github.com/hepatica387/member-service.git
cd member-service
```

### 2. MySQL 데이터베이스 설정
```sql
CREATE DATABASE member_service;
USE member_service;
```

### 3. 데이터베이스 연결 설정
`src/main/resources/application.properties` 파일 수정:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/member_service
spring.datasource.username=root
spring.datasource.password=your_password
```

### 4. 애플리케이션 실행
```bash
./gradlew bootRun
```

### 5. 접속
브라우저에서 `http://localhost:8080`으로 접속

---

## 📝 API/기능 명세

### 회원 관리 기능

| 기능 | HTTP Method | URL | 설명 |
|------|------------|-----|------|
| 회원 목록 조회 | GET | `/members` | 모든 회원 목록 조회 |
| 회원 상세 조회 | GET | `/members/{id}` | 특정 회원 상세 정보 |
| 회원 등록 페이지 | GET | `/members/new` | 회원 등록 폼 페이지 |
| 회원 등록 | POST | `/members` | 새 회원 등록 |
| 회원 수정 페이지 | GET | `/members/{id}/edit` | 회원 수정 폼 페이지 |
| 회원 수정 | PUT/POST | `/members/{id}` | 회원 정보 수정 |
| 회원 삭제 | DELETE/POST | `/members/{id}/delete` | 회원 정보 삭제 |

---

## 📚 참고 자료

- [Spring Boot 공식 문서](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf](https://www.thymeleaf.org/)

---

## 👥 팀원

- **석진**: 회원 등록(C), 회원 조회(R)
- **동규**: 회원 수정(U), 회원 삭제(D)

---

**최종 업데이트**: 2026년 6월 29일