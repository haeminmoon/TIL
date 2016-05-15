# 데이터베이스

## SQL

**SQL의 정의**

**DDL(Data Definition Language)**

	- CREATE TABLE (생성)

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


	- DROP TABLE (삭제)
	- RENAME (이름 변경)
	- TRUNCATE (테이블의 모든 데이터 삭제)
	- COMMENT (테이블에 설명 추가)

**DML**

**DCL**



