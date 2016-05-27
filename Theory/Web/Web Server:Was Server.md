#Was Server와 Web Server차이

##Was Server [Web Application Server]

	웹 애플리케이션 서버 [ WAS, Web Application Server ] 용어사전 :
	 
	웹과 기업의 기간 시스템 사이에 위치하면서, 웹 기반 분산 시스템 개발을 쉽게 도와주고 안정적인 트랜잭션 처리를 보장해 주는 일종의 미들웨어소프트웨어 서버. 3계층 웹 컴퓨팅 환경에서 기존 클라이언트/서버환경의 애플리케이션 서버와 같은 역할을 하며, 클라이언트와 서버 환경에서 트랜잭션 처리 및 관리와 다른 기종 시스템 간의 애플리케이션 연동 등을 주된 기능으로 하고 있다.
	 
	WAS는 웹이 탄생한 이래, 주로 데이터베이스조회나 일반적인 비즈니스 로직에 대한 처리를 위해 다양한 언어로 개발된 인터넷/인트라넷환경의 소프트웨어를 지칭한다. 자바스크립트나 JSP등과 같은 스크립트및 서비스들은 대개 최신의 데이터를 검색하기 위해 데이터베이스에 접근하고, 브라우저또는 클라이언트프로그램을 통해 사용자들에게 검색 결과를 제공한다.
	WAS를 비롯한 애플리케이션 서버들은, 웹서버 즉 HTTP서버와 같은 컴퓨터를 공유할 수도 있지만, 별개의 컴퓨터를 독립적으로 사용하는 경우도 많다. 대규모 사이트에서는, 오히려 WAS와 웹서버등을 위해 여러 대의 컴퓨터가 동원되기도 한다. 넷스케이프의 Netscape Application Server, BEA의 Weblogic Enterprise, 볼랜드의 AppServer, 그리고 IBM의 Websphere Application Server 등이 WAS의 대표적인 제품들이다.

	Was Server 종류 : tomcat, tMax jeus, BEA Web Logic, IBM Web Spere, JBOSS,
                             Bluestone, Gemston, Inprise, Oracle, PowerTier, Apptivity, SilverStream

##Web Server

	- 웹 서버 (소프트웨어) : 웹 브라우저클라이언트로부터 HTTP요청을 받아들이고, HTML문서와 같은 웹 페이지에서 흔히 찾아 볼 수 있는 자료 콘텐츠에 따라 HTTP에 반응하는 컴퓨터 프로그램

	- 웹 서버 (하드웨어) : 위에 언급한 기능을 제공하는 컴퓨터 프로그램을 실행하는 컴퓨터

	Web Server 종류 : IIS, apache, tMax WebtoB

##Web server와  WAS의 이해

	**Web Server의 정의** 
	Web Client(웹 브라우저)에게 컨텐츠를 제공하는 서버, 정적인 HTML이나 jpeg, gif 같은 이미지를 HTTP 프로토콜을 통해 웹 브라우저에 전송함 => WebToB

	**WAS(Web Application Server)의 정의**
	Server 단에서 Application을 동작할 수 잇도록 지원함. => Jeus
	기존 웹 서버와 달리 동적인 요구에 대응하기 위해 적합한 형태로 변화, Web Client(브라우저)에게는 결과값만 전송함.

	Container(컨테이너)라는 용어로 쓰이며, 초창기는 CGI, 그 후에서는 Servlet, JSP, ASP 등의 프로그램으로 사용됨

##Was의 도입 효과

	안정된 시스템 구성 : 안정적 서비스 보장, 자동적인 어플리케이션 복구기능 제공, 업무 로직이 중간 어플리케이션 서버에 존재, 쉽고 빠르게 구축할 수 있다.

	DB 성능 보장 : WAS서버가 DB서버와의 최적 사용을 조절화, DB connection pool을 총해 DB connection 관리 및 트랜잭션 처리

[참조 URL](http://egloos.zum.com/slog2/v/3787621)