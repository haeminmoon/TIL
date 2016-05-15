# SQL

**SQL의 정의**

- Structured Query Language, 데이터베이스에서 원하는 기능을 사용하기 위한 언
- SQL은 High-Level Language이다.


**DDL(Data Definition Language)**

__객체의 생성,변경,삭제 명령 : SCHEMA, DOMAIN, TABLE, VIEW, INDEX를 정의하거나 변경 또는 삭제할 때 사용하는 언어__

- CREATE TABLE (생성)

	* 테이블 생성
	CREATE TABLE book(
			bookno NUBMEr(5),
			tile VARCHAR2(50),
			author VARCHAR2(10),
			pubdate DATE
	);

	* subquery를 이용한 테이블 생성도 가능하다. (NOT NULL 제약 조건만 상속됨)
	CREATE TABLE empSALES 
	AS
		SELECT * FROM emp
		WEHRE job = 'SALES';


- ALTER TABLE (변경)

	* 컬럼 추가
	ALTER TABLE book ADD(pubs VARCHAR2(50));

	* 컬럼 수정
	- ALTER TABLE book MODIFY(tilte VARCHAR2(100));

	* 컬럼 삭제
	- ALTER TABLE book DROP author;

	* UNUSED 컬럼
	- ALTER TABLE book SET UNUSED(author);
	  ALTER TABLE book DROP UNUSED COLUMNS;		<< 이렇게 하면, unused된 컬럼을 선택 삭제가 가능하다.


- DROP TABLE (삭제)

	* 테이블 삭제
	- DROP TABLE book;


- RENAME (이름 변경)

	* RENAME
	- RENAME book TO article;


- TRUNCATE (테이블의 모든 데이터 삭제)

	* 데이터 삭제
	- TRUNCATE TABLE book;		<< TRUNCATE는 ROLLBACK의 대상이 아니다. 그래서 로깅을 하지 않기 때문에 원상 복구를 할 수가 없다.


- COMMENT (테이블에 설명 추가)

	* Comment
	- COMMENT ON TABLE book IS 'this is commnet';


- DDL의 제약 사항 (Constraint)

	- DB 테이블 레벨에서 특정한 규칙을 성정해둠으로서, 예상치 못한 데이터의 손실이나 일관성을 어기는 데이터의 추가, 변경 등을 예방한다.

	- 종류

		* NOT NULL
			-NULL 값이 들어올 수 없음
			-컬럼형태로만 제약조건 정의할 수 있음 ( 테이블 제약 조건 불가 )

			CREATE TABLE book (
				bookno NUMBER(5) NOT NULL
			);

		* UNIQUE
			-중복된 값을 허용하지 않음 ( NULL은 들어올 수 있음 )
			-복합 컬럼에 대해서도 정의 가능 
			-자동적으로 인덱스 생성

			CREATE TABLE book (
				bookno NUMBER(5) CONSTRAINT c_emp_u UNIQUE
			);

		* PRIMARY KEY
			-NOT NULL + UNIQUE (인덱스 자동 생성)
			-테이블 당 하나만 나올 수 있음
			-복합 컬럼에 대해서 정의 가능 (순서 중요) 	<< 성능에 차이가 있을 수 있기 때문에..

			CREATE TABLE book (
				ssn1 NUMBER(6),
				ssn2 NUMBER(7),
				PRIMARY KEY (ssn1, ssn2)
			);

		* FOREIGN KEY
			- 참조 무결성 제약
			- 일반적으로 REFERENCE 테이블의 PK를 참조
			- REFERENCE 테이블에 없는 값은 삽입 불가
			- REFERENCE 테이블의 레코드 삭제 시 동작
				* ON DELETE CASCADE: 해당하는 FK를 가진 참조행도 삭제
				* ON DELETE SET NULL: 해당하는 FK를 NULL로 바꿈

			CREATE TABLE book(
				author_id NUMBER(10),
				ONSTRAINT c_book_fk FOREIGN KEY (author_id)		<< foreign key 설정
				REFERENCES author(id)		<< 참조 테이블 설정
				ON DELETE SET NULL
			);

		* CHECK
			- 임의의 조건 검사, 조건식이 참이어야 변경 가능
			- 동일 테이블의 컬럼만 이용 가능

			CREATE TABLE book (
				rate NUMBER CHECK (rate IN (1,2,3,4,5))
			);

		* ADD/DROP CONSTRAINTS
			- 제약조건 추가 (NOT NULL은 추가 못함)
			ALTER TABLE emp ADD CONSTRAINT emp_mgr_fk
				FOREIGN KEY(mgr) REFERENCES emp(empno);

			- 제약조건 삭제
			ALTER TABLE book DROP CONSTRAINT c_emp_u;
			ALTER TABLE dept DROP PRIMARY KEY CASCADE;	<<primary eky의 경우 fk조건이 걸린 경우에는 cascade로 삭제해야만 한다. FK까지 한방에 삭제 가능함.

-Data Dictionary
	* 오라클이 관리하는 몯느 정보를 저장하는 카탈로그이다.
	* 모든 스키마 객체 정보, 스키마 객체의 공간 정보, 컬럼의 기본값, 제약조건 정보, 오라클 사용자 정보, 권한 및 롤 정보, 기타 데이터베이스 정보...
	* Base-Table과 View로 구성되며, View는 USER(로그인한 사용자레벨), ALL(모든 사용자 정보), DBA(관리자)로 구성된다.
	* SYS 스키마에 속한다.
	* 주의사항:DICTIONARY의 테이블이나 컬럼 이름은 모두 대문자를 사용해야 한다!

	* 모든 Dictionary 정보 조회
	SELECT * FROM DICTIONARY;

	* 사용자 스키마 객체 확인(테이블)
	SELECT object_name
	FROM user_objects
	WHERE object_type = 'TABLE';

	* 제약조건 확인 (EMP 테이블의...)
	SELECT constraint_name, constraint_type, search_condition
	FROM user_constraints
	WHERE table_name = 'EMP';

	* 제약조건 컬럼 확인
	SELECT constraint_name, column_name
	FROM user_cons_columns
	WHERE table_name = 'EMP';

	* 모든 사용자 확인
	SELECT username,default_tablespace,temporary_tablespace
	FROM DBA_USERS;

**DML (Data Manipulation Language)**

__레코드 제어 명령어 : 데이터베이스 사용자가 응용 프로그램이나 질의어를 통하여 저장된 데이터를 실질적으로 처리하는데 사용하는 언어__

-트랜잭션의 대상
	*트랜잭션은 DML의 집합으로 이루어진다.

- INSERT (Add new row)
	* 묵시적 방법 : 컬럼 이름, 순서 지정하지 않음. 테이블 생성시 정의한 순서에 따라 값 지정
	INSERT INTO dept VALUES (777, 'MARKETING', NULL);

	* 명시적 방법 : 컬럼 이름 명시적 사용. 지정되지 않은 컬럼 NULL자동 입력
	INSERT INTO dept(dname, deptno) VALUES ('MARKETING', 777);

	* Subquery 이용 : 타 테이블로부터 데이터 복사 (테이블은 이미 존재하여야 한다.)
	INSERT INTO deptusa
		SELECT deptno, dname FROM dept WHERE country = 'USA';		

- UPDATE (Modify existing rows)
	* 조건을 만족하는 레코드를 변경 (ex: 10번 부서원의 월급 100인상 & 수수료 0으로 변경)
	UPDATE emp SET sal = sal + 100, comm = 0
	WHERE deptno = 10;	

	* WHERE 절이 생략되면 모든 레코드에 적용 (ex: 모든 직원의 월급 10%인상)
	UPDATE emp SET sal = sal * 1.1;

	* Subquery를 이용한 변경 (ex: 담당업무가 'SCOTT'과 같은 사람들의 월급을 부서 최고액으로 변경)
	UPDATE emp SET sal = (SELECT MAX(sal) FROM emp)
	WHERE job = (SELECT job FROM emp WHERE ename='SCOTT');

- DELETE (Remove existing rows)
	* 조건을 만족하는 레코드 삭제
	DELETE FROM emp WHERE ename = 'SCOTT';

	* 조건이 없으면 모든 레코드 삭제 (주의!)
	DELETE FROM emp; (모든 데이터가 삭제되니 주의해야 한다.)

	* Subquery를 이용한 DELETE (ex: 'SALES'부서의 지구언 모두 삭제)
	DELETE FROM emp WHERE deptno = 
		(SELECT deptno FROM dept WHERE dname = 'SALES');

- 참고사항
	* 데이터 입력, 수정시 자주 사용되는 Pseudo 컬럼
	- USER : Current user name.
	- SYSDATE : Current data and time.
	- ROWID : Location information of rows

	INSERT INTO emp(eno, hiredate) VALUES (200, SYSDATE) ;

	* DEFAULT: default값이 정의된 컬럼에 기본값을 입력할 경우 사용할 수 있다.
	INSERT INTO book VALUES (200, 'Gems', DEFAULT);

	* DELETE와 TRUNCATE의 차이점
	- Delete는 Rollback 가능 but 대량의 log등을 유발하므로 Truncate보다 느림

	* 모든 DML문은 integrity Constraint를 어길 경우 에러가 발생한다.

**DCL (Data Control Language**
	
__객체 권한 부여등의 제어어 : 데이터의 보안, 무결성, 데이터 회복, 병행 수행 제어 등을 정의하는 데 사용하는 언어 __

- COMMIT
	* 데이터베이스 조작 작업이 정상적으로 완료되었음을 관리자에게 알려줌

- ROLLBACK
	* 데이터베이스 조작 작업이 비정상적으로 종료되었을때 원래의 상태로 복구함

- GRANT
	* 데이터베이스 사용자에게 사용권한을 부여함

- REVOKE
	* 데이터베이스 사용자의 사용권한을 취소함




**SELECT 관련 명령어 분석 **

- 데이터베이스에서 원하는 데이터를 검색, 추출
- Syntax
	* SELECT [ALL | DISTINCT] 열_리스트
	  [FROM 테이블_리스트]
	  [WHERE 조건]
	  [GROUP BY 열_리스트 [HAVING 조건]]
	  [ORDER BY 열_리스트 [ASC | DESC]]
- 기능
	* Projection : 원하는 컬럼 선택
	* Selection : 원하는 튜플 선택
	* Join : 두개의 테이블 결합
	* 기타 : 각종 계산, 정렬, 집계(Aggregation)


__각 명령어의 기능들 및 예제는 PDF를 참조하자__
