# Nodejs

## 설치

## npm

- 프로젝트 패키지화
 > 해당 프로젝트로 경로 이동 -> npm init

- Global 모듈 설치
 > npm install 모듈명 -g

- 프로젝트에 종속된, Dependency 모듈 설치
 > npm install 모듈명 --save (해당 프로젝트로 이동) - 프로젝트 내, package.json에 dependency에 추가됨

## 동기 & 비동기

nodejs는 비동기 프로그래밍 기능을 지원한다.
보통 메소드 명 뒤에 'Sync'가 붙어 있으면 동기, 붙어있지 않으면 비동기 메소드 호출이다.
비동기 호출시에는 항상 함수 파라미터를 전달(callback)하여 비동기 작업이 끝났음을 알리고, 알린 후 동작을 지정한다.

동기 -> 빨래 설거지 청소 - 순서대로 (총3시간 걸림) - 일이끝남!
비동기 -> 빨래 설거지 청소 - 각각 업체에 전화하고 완료되면 완료보고를 받음(총1시간 걸림) - 일이끝남!
 > 요청을 해놓는 동안에 나는 다른 일을 할 수 있음.

* 비동기 - 순서가 중요하지 않을땐 사용 해도됨, 뭐가 언제 끝날지는 모름

## GET & POST Routing

- GET (URL에 request 내용을 포함할 수 있는 경우)
 > GET방식 요청의 경우 request.query.name의 형태로 쿼리스트링에 접근 가능함 (URL에 포함된 파라미터)

- POST (URL에 request 내용을 포함할 수 없는 경우 : ID/PW, URL length limit을 초과하는 문장의 경우.. 등..)
 > POST방식 요청의 경우 requst.body.name의 형태로 데이터에 접근이 가능함 (body-parser 미들웨어가 필요)

* get과 post든 어떤 방법을 취해서든 request를 탈취하거나 하이재킹 할 수 있다. 보안 이슈로 get과 post를 분류해서 쓴다면 원론적으론
https, 즉 ssl과 같은 프로토콜을 사용해야만 한다.

---
routing

정적 파일 서비스 : /public
동적 파일 서비스 :


templet engine / jade

------------------

react, redux
