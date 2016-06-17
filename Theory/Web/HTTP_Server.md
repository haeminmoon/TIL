#HTTP_Server

##Apache and Nginx

[Apache에 대한 설명 URL](https://namu.wiki/w/아파치%20HTTP%20서버)

아파치와 엔진엑스는 같은 HTTP 서버지만, 

	Apache : Blocking I/O - MultiThread
	Nginx : Non-Blocking I/O - Event Driven

이러한 차이가 존재한다. 그래서 NginX는 더 많은 요청과 클라이언트 연결을 처리할 수 있게 됐고,
요청에 더욱 빠르게 반응하는 솔루션으로 자리매김하게 됐다.
**3500개의 연결에 대해 엔진엑스의 요청이 대략 3배정도 빠르다고 한다.**


**Apache도 NginX에 해나 위기를 느껴, Event MPM등을 출시하여 대응하고 있는 중...**

