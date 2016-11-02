# SQL튜닝 (2)

## 옵티마이저 연산자


## Index 활용

Index를 활용해서 튜닝을 할때는, 우선적으로 생각해야 할 것들이 있다.

만약

select /*+ index(c(cust_year_of_birth)) */
	cust_id, cust_last_name, cust_year_of_birth, cust_city, country_id
from customers c
where 1번 조건 절
	  2번 조건 절

1번의 count(*)로 찍어 보면, count가 30, 2번은 count가 19000 이라고 하면
우리는 당연히 필터링 기능이 좋은 1번에 인덱스를 적용해서  튜닝해야 한다고 생각한다. 하지만 막상 실행 예상 계획을 보면 인덱스가 2번에 적용되어 있다.

이경우

- 옵티마이저의 통계가 잘못 수집되어 있을 수도 있음
- 1번에 인덱스를 적용할 수 없는 경우 일 수도 있음 ( %Like나, isNull)


## 문장 작성 방법론

SELECT e.empno, e.ename, SUM(s.salary)
FROM emp e, sal_history s, family f
WHERE e.empno = s.empno
AND e.empno = f.empno
AND s.pay_day BETWEEN TO_DATE('2013/01/31', 'YYYY/MM/DD')
AND TO_DATE('2013/12/31', 'YYYY/MM/DD')
GROUP BY e.empno, e.ename ;


차라리 이런식으로 나눠서 써라 !! 최적의 성능

select
from (select empno, sum(salary) as sum_sal
	  from sal_histroy
	  where pay_day between TO_DATA('2013/01/31', 'YYYY/MM/DD')
	  					AND TO_DATA('2013/12/31', 'YYYY/MM/DD')
	  group by empno) s,
	  (select *
	   from emp e
	   where exists ( select 1 from family where empno = e.empno)) A
where s.empno = a.empno;

emp를 굳이 따로 서브쿼리를 작성하지 않아도 됬지만, 따로따로 어떤 수행 작업을 하는지 시각화해서 보여줄수도 있고 ... 속도도 훨씬 빠르다. 조인이라는 것은 1:m이기 때문에 성능 저하를 불러올수도 있는데 m을 1로 만들어 놓고 시작하는 것이다.



## 날짜 비교

select TRUNC(SYSDATE, 'YYYY/DD/MM')
from DUAL;

select *
from EMP
where hiredate = TRUNC(SYSDATE, 'YYYY/DD/MM');
//DB에 있는 값과 오늘 날자가 일치하는지. [시, 분, 초를 00:00:00 으로 절삭]

WHERE HIREDATE BETWEEN TRUNC(SYSDATE,'DD') AND TRUNC(SYSATE+1, 'DD')-1/86400;



## 함수 사용..

정말 필요한 경우가 아니면 함수를 쓰지 말자... 내부적으로 함수를 호출하는 비용이 들기 때문에...

TO_CHAR ........ TO_DATE / 분명히 차이가 난다.

컬럼은 꼭 필요한 상황이 아니면 가급적 건드리지 말자...!

## 정렬할 때

조건에 만족하는 행들이 적을때는 ORDER BY 해도 상관 없다.
하지만 엄청나게 크다거나, 온라인 상에서 한 화면에 50개 ~ 100개의 데이터만 앞에서부터 rownum 으로 짤라서 보여주거나 할때 처럼 제한적인 상황에서는 인덱스로 관리해서 정렬을 활용하여도 괜찮다.
하지만 이렇게 인덱스가 많이 사용 되면 DML의 성능이 떨어진 다는 것은 잊지 말자.

## 순위별 정렬할 때

부서별 연봉 2위

[rank() row_number() dense_rank]

select *
from (select dense_rank() over(partition by deptno order by sal desc) as rk, E.*
		from emp 3)
		where rk <= 2;


## 실행 계획을 확인 할 때
순차적으로 확인하면 뎁스가 가장 깊은 곳이 먼저 실행 되지만, 같은 뎁스 레벨에서 실행되는 것은 위엣것이 먼저 실행됨
0  -------
1   -------
2    -------
3    -------
4     -------

이 경우에는 2번이 먼저 실행된다.


## 블록
하나의 블록에는 2개 이상의 행 데이터가 들어갈 수 있는데, 원래 접근 했던 블록에 접근하면 I/O가 증가하지 않을 수도 있다.