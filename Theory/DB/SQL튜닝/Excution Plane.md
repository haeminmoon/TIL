# Excution plane

## 실행계획 이란...

SQL 튜닝을 위해서 각종 정보들을 확인 하기 위해 DBMS_XPLAN 패키지를 이용하여 실행계획을 주로 확인한다.


함수는 총 6개 이지만, 가장 자주 사용하는 함수는 아래의 3가지 이다.

1.DISPLAY             	--> 예측 실행계획을 보여준다.
2.DISPLAY_CURSOR   		--> 실제 실행된 실행계획을 보여준다.
3.DISPLAY_AWR         	--> 실제 실행된 실행계획을 보여준다.

sql_id를 활용하여 조회.
ex) select * from table(dbms_xplan.display_awr(:v_sql_id,null,null,'advanced allstats last'));

@xplan 을 활용할 수 도 있음.



실행 계획의 항목은 크게 7가지로 나눌 수 있다.

1)Basics 항목 (Always Available)
Id         :각 Operation 의 ID 임.
                  * 가 달려있는 경우는 predicate 정보에 access 및 filter 에 관한정보가 나옴을 표시한것임.
Operation  : 각각 실행되는 JOB 을 나타냄
                    row source operation.의 줄임말임.
Name       : Operation 이 엑세스하는 테이블 및 인덱스를 나타냄.



2)Query Optimizer Estimations(옵티마이져의 예상 row 수 및 bytes, cost , temp 사용량)
Rows (E-Rows)   : 각 operation 이 끝났을 때 return되는 건수를 나타냄.
                              이것은 예측 건수 이므로 실제 건수와는 다름.
Bytes (E-Bytes) : 각 operation 이 return 한 byte 수.
                              예상치 이므로 실제 받은 byte와는 다름
TempSpc         : 각 operation. 이 temporary space 를 사용한 양(예상치임)
Cost (%CPU)     : 각 operation 의 Cost. (예상치 임)
                              괄호안의 내용은 CPU Cost 의 백분율임.
                               이값은 Child Operation 의 Cost 를 합친 누적치임.
Time             : 예측 수행시간


 
3)Partitioning (파티션을 엑세스 할경우만 나타남)
Pstart  : 파티션을 엑세스 하는경우 시작파티션을 나타냄
             상수로 들어올때는 파티션 번호로 나타나며 변수로 들어올때는 KEY 로 나타남
Pstop  : 마지막 파티션을 나타냄.
              따라서 patart, pstop 를 이용하면 access 한 파티션을 알수 있음. 



4)Parallel and Distributed Processing (Parallel Processsing 을 사용하거나 DB-LINK 를 사용하는경우)
Inst         :  DB-LINK 명(사용하는 경우만 나타남).
TQ            :  PARALLEL SQL 사용시 table queue 명을 나타냄
                   TQ 는 PARALLEL SLAVE 간의 통신을 담당함.
IN-OUT      :  Parallel processing 시에 각각의 Operation 이 Serial 로 실행되는지 parallel 로 진행되는지를
                     나타냄.
PQ Distrib :  Parallel processing 시에 producers 와 consumers 간의 데이터의 분배방식을 나타냄.

[url 1](http://scidb.tistory.com/entry/Parallel-Query-의-조인시-Row-Distribution)
[url 2](http://scidb.tistory.com/entry/Parallel-Query-의-조인시-또다른-튜닝방법pxjoinfilter) 




5)Runtime Statistics (실제 수행시간밑 실제수행건수)
Starts   : 각 operation 을 try 한 건수(예를 들어 nested loop join 이라면 인덱스를 여러 번 scan 함)
A-Rows   : 각 operation 이 return 한 건수
A-Time   : 실제 실행시간
0.1초까지 나타남 (HH:MM:SS.FF).
                 이값은 Child Operation 의 Cost 를 합친 누적치임.             


 
6)I/O Statistics (I/O 관련하여 READ / WRITE 한 블록수)
Buffers  : 각 Operation 이 메모리에서 읽은 block 수.
Reads    : 각 Operation 이 disk 에서 읽은 block 수.
Writes   : 각 Operation 이 disk 에 write한 block 수.
 


7)Memory Utilization Statistics(hash 작업이나 sort 작업시 사용한 메모리 통계)
OMem     : optimal execution 에 필요한 메모리(예측치임).
1Mem     : one-pass execution. 에 필요한 메모리(예측치임)
O/1/M    : 각 operation 이 실행한 optimal/one-pass/multipass 횟수가 순서대로 표시됨.
Used-Mem : 마지막 실행시의 사용한 메모리
Used-Tmp : 마지막 실행시 메모리가 부족하여 temporary space 를 대신 사용할 때 나타남. 
                      보이는값에 1024 를 곱해야함.
                      예를들어 32K 로 나타나면 32MB 를 의미함.
Max-Tmp  : 메모리가 부족하여 temporary space 를 사용할 때 최대 temp 사용량임.
                     USED-TMP 와 다른점은 마지막 수행시가 아니라 SQL을 여러 번 수행했을경우에 
                     항상 최대값만 보인다는 것이다.
                     보이는값에 1024 를 곱해야함.
                     예를들어 32K 로 나타나면 32MB 를 의미함.