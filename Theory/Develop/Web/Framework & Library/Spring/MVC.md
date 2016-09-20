# MVC (Model View Controller)

사용자 뷰 관점에서의 웹 동작 원리를 패턴 방식으로 나누어 논것.

	View - Controller - Service - DAO - DTO - DB

서비스를 예를 들어 설명하자면 "빅맥 세트 주세요"라는 주문을 하면 햄버거,콜라,감자튀김 이 나옴.. 
주문자의 입장에서는 빅맥세트를 달라는 하나의 요청을 한것임. 하지만 직원은 햄버거,콜라,감자튀김을 각각 준비해야 함
즉, 서비스는 요청에 의한 단위를 말하는 것임/ 

여기서 햄버거, 콜라, 감자튀김은 각각 DAO, DTO를 나타냄
DAO는 쿼리를 날리는 부분 / DTO는 객체 단위임 
