# SQL튜닝(1)

## 시작 이론

- Excution plan을 확인해보면 SQL 검색 우선 순위 조건과 실행 순서를 확인 할 수 있다.
- SQL은 옵티마이저의 실행 정보 통계를 가지고 예상값을 뽑아내서 실행한다. 


##Optimizer

1. Parse : 실행 계획 확보
2. Bind : 바인드 변수에 값 치환
3. Execute : 실행 계획대로 결과 도출
4. Fetch : Query 결과 반환 ( Select 문장일 경우에만 수행)

현재는 룰베이스 옵티마이저가 아닌 코스트 베이스 옵티마이저를 사용하고 있다. 
	- 룰베이스의 경우 같은 조건이면 우선순위를 순서별로 정하지만, 코스트 베이스의 경우 테이블에 구성되어 있는 비용으로 구분한다.


##Optimizer 통계

- 통계를 잘 수집하면, 옵티마이저의 실행계획을 잘 세울 수 있어서 성능을 많이 향상 시킬 수 있다. 
- 통계가 바뀌면 똑같은 문장을 실행해도 다른 결과가 나올 수도 있다.
- 튜닝에서 가장 큰 영향을 주는 것은 통계 지표이다.
- 통계가 오래되 있으면, 변화되어 있는 테이블에 최적화된 성능이 아니게 될 수도 있다.
- cost 계산의 중요한 지표로 사용된다.
- 비 대칭적인 데이터 존재 시 히스토그램을 통해 처리


##SQL문 처리 과정

1. UP(User Process)에서 sql을 던지면 SP(Server Process)는 가장 먼저 구문 및 의미(객체 및 권한)를 확인한다. ( 실행가능한 문장인지 밸리데이션)
	: Dictinary Data는 Dictionary Cache, 또는 Recursive Call 사용 [Dictionary Data는 DB를 운영하는데 필요한 메타 데이터 이다.]


2. 동일 문장 확인
3. 동일 문장이 발견되면 Soft Parse, 발견되지 않으면 Hard Parse

	alter system flush shared_pool  <<<< DB영역중 하나인 shared_pool 영역을 초기화 시킨다는 이야기 ( flush )
		: shared_pool은 캐쉬 영역을 쌓아 놓는 곳이다. 그래서 한번 실행 한 것은 리커시브 콜이 다시 불러지지 않는다.

	user가 던지는 sql은 단순한 text일 뿐이다. 실행계획을 세우기 위한.. 하지만 대부분 실행계획이 캐쉬되어 있기 때문에 굳이 다시 만들지 않는다. 
		:실행계획은 많은 비용을 소모해야만 한다.
4. Hard Parse 단계
	- Query Transformer
	- Estimator (실행 계획의 Cost 산출, dictionary Data 이용)
	- Plan Generator
	- 생성된 실행 계획은 Library Cache에 저장 (공유 커서)
5. 명령문 확인 : FETCH 단계 준비 ( 실행 결과를 저장할 수 있는 영역 구성)
6. Bind : 호출 환경에서 선언된 변수에 값 입력
7. Parallelize : 병렬 작업 배분(병렬 실행 시)
8. Execute : 실행 (실행 계획 사용)
9. FETCH : Query 결과 반환 (Select 문장일 경우에만 수행)




ex)
select * from emp where deptno = 10;
select * from emp where deptno = 20;
select * from emp where deptno = 30;

이러한 예제에서 살펴볼때 deptno으로 인덱스를 타긴 하지만 각각 실행계획이 다 다르다 (쿼리의 아이디도 틀리다.[아스키 코드가 변하면 무조건 다 다른 실행계획을 만듦])
그래서 서버에 메모리를 자꾸만 사용하기 때문에 우리는 "select * from emp where deptno = :b1"같은 바인드 변수를 사용하는 것이다.


* 서브쿼리와 조인 : 서브쿼리 또한 실행계획에 보면 조인절로 변환됨. 





##1. Excution plan

- hard Parsing 도중 생성되며, Shared Pool의 라이브러리 캐시에 저장된다.
- 문장 실행 전 예측되는 실행 계획은 PLAN_TABLE에 저장된다.


##2. autotrace
전체적으로 간단한 통계들을 확인 할 수 있다. 하지만 실제 튜닝을 하는데 써먹기에는 약한 부분이 있다. (통합적인 통계 데이터만으로 판단하기에는 .. 무리가 있음)

##3. Library Cache

라이브러리 캐시에서 최근에 실행된 실행 계획을 검사할 수 있다.
----
dbms_xplan.display_cursor에 대한 접근 권한을 획득할려면...

SQL> GRANT SELECT ON V_$SESSION TO sqlt ;
SQL> GRANT SELECT ON V_$SQL TO sqlt ;
SQL> GRANT SELECT ON V_$SQL_PLAN TO sqlt ;
SQL> GRANT SELECT ON V_$SQL_PLAN_STATISTICS_ALL TO sqlt ;
SQL> GRANT sqlt TO user01 ;

권한을 달라고 하면 됨 !

----

cd adsql
sqlplus / as sysdba

@myxplan

dbms_xplan	->호출자 권한
myxplan		->생성자 권한

ex)	select * from table(myxplan.display_cursor);

display_cursor 함수 조회가 안되는 튜닝에 제한적이게 될 수 밖에 없다.

sql문을 실행하고 "select * from table(myxplan.display_cursor);"을 실행하면 정보를 확인 할 수 있다.


sql문을 실행하면 라이브러리 캐시안에 통계가 저장되는데, 그 정보를 그대로 .display_cursor가 가져 오는 것이다. 
하지만 예측 통계 정보만을 가지고 튜닝을 할 순 없다. 그래서 실행 통계를 수집하기 위해서는 

- 문장레벨에서 실행 통계 수집을 해야 한다. (힌트를 사용해야함)
SELECT /*+ gather_plan_statistics */ * FROM dept WHERE deptno = 10 ;
SELECT * FROM table(myxplan.display_cursor(null, null, 'ALLSTATS LAST')) ;

- 세션 레벨의 실행 통계 수집 (파라미터 수정, ALTER SESSION 권한 필요)
ALTER SESSION SET statistics_level = all ;
SELECT * FROM dept WHERE deptno = 10 ;
SELECT * FROM table(myxplan.display_cursor(null, null, 'ALLSTATS LAST')) ;


- 가장 쉽게 실행 통계 수집하는 방법은 !
sqlDeveloper-> Tools -> preference -> worksheet -> select adsql on Browse
	-> 쿼리 실행
	-> @xplan 실행


* 실행 통계에서 ID는 라이브러리 캐시에서 해당 SQL문을 구분하기 위한 ID이다.


##Index

- ROWID는 하나의 행에 물리적인 주소이다. 이 ROWID를 WHERE절 조건으로 사용할때 가장 빠른 검색 속도를 보인다. 하지만 이 ROWID를 다 외울 수가 없기 때문에, 
우리는 Index를 만들어서 사용한다.

- 하나의 검색결과에 ROWID를 사용하기는 좀 그렇지만, 이 검색결과를 가지고 업데이트나 딜리트를 할때는 ROWID를 가지고 와서 작업하는 것도 좋다. 
[속도는 가장 빠른 속도를 보장한다.] - 사용할 수 있는 케이스는 분명히 있다.

- Index를 사용할 수 없는 문
장1. IS NULL은 항상 인덱스를 사용할 수 없습니다.
2. IS NOT NULL은 인덱스 사용 시 "INDEX FULL SCAN"만 가능합니다.
3. 인덱스가 존재하는 컬럼이 조건식에 존재해야 합니다.
4. 명시적, 암시적 컬럼 가공이 있어서는 안됩니다.
5. 부정형 비교보다는 긍정형 조건식을 사용합니다.
6. "%"를 앞에 사용한 LIKE는 인덱스 사용 시 "INDEX FULL SCAN"만 가능합니다.


ex) 날짜 타입은 between 으로 TO DATE 해서 비교.
	있냐 없냐의 유무는 항상 exists