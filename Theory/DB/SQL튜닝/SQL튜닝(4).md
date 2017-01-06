# SQL튜닝(4)

## Materialized view

Materialized view 는 실행 결과 자체를 저장한다.

Materialized View는 일명 MView라고들 말한다

우리가 소위 알고 있는 view는 실시간의 데이터는 유지하지만 시간이 많이 걸린다는 단점이 존재한다

그에 반해 Summary table이라는 것이 있다. 일명 CTAS라 불리는 것이다

CREATE TABLE AS SELECT ...... 로 생성하는 테이블을 CTAS라 불린다

이건 실시간의 데이터는 아니지만 성능상의 장점이 존재한다

 

이런 VIEW와 CTAS 의 장점을 다 갖추고 있는 것이 Materialized View라는 넘이다

오늘 Materialized View에 대해 자세히 설명한다.

 

▷ Materialized View란??

너무 빈번하게 발생하는 특정 쿼리가 존재한다. 이런 쿼리들을 VIEW 형식으로 저장을 하는 것이 Materialized View라고 생각한다. BUT 이것은 VIEW처럼 논리적인 공간이 아닌 물리적인 공간이라 보면 된다

간단하게 설명하면 대용량의 데이터를 SUM, MIN, MAX, AVG, COUNT(*)와 같은 명령어를 사용해 너무나도 자주 조회하는 Query가 있을 것이다. 이런 Query의 결과 만큼의 새로운 테이블을 생성해 놓는 벙법이 Materialized View라고 이해하자

* Mview에도 성능 향상을 위해 인덱스를 생성할 수 있으며, 파티션도 가능하다. 그리고 Base Table의 변경을 Mview에 반영하는 방법은 일정시간 혹은 특정 이벤트별로 전체를 읽어와서 재작성하는 Complete Refresh방식과 변경된 부분만 반영시키는 Fast Refresh방식이 있다.

*How many MViews?

하나의 MView를 이용하여, 다중쿼리에서 이용하는 것이 좋다.


▷ MView의 생성

Materialized View를 생성하기 위해서는 Query Rewrite권한과  CREATE MATERIALIZED VIEW 권한을 MView를 생성하는 유저에게 부여해야 한다. 부여하는 놈은 당연 SYSDBA 유저인 SYS이다.

##병렬처리

진짜 잘못하면 큰일난다.... !!!!!!!!! 

## WITH

WITH 절은 무조건 디스크에 쓴다. 읽을때도 쓴다.... 그래서 WITH절을 사용할때는 그룹핑을 하거나 중복을 제거 할때만 사용하는 것이 좋다. ( 데이터가 엄청나게 클때, )
