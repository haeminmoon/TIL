# WebSocket and Socket.io

## Socket?

TCP/IP의 4계층의 구조를 알지 못해도, 응용프로그램(애플리케이션) 단계에서 소켓을 통해 네트워크 프로그래밍, 통신을 가능하게끔 하는 통신 기술. 기본적으로 클라이언트와 서버가 존재한다고 하면 TCP hanshaking 과정을 통해 컨넥션을 맺고 통신한다.

## Websocket?

전형적인 브라우저 렌더링 방식은 HTTP 요청(HTTP Request)에 대한 HTTP 응답(HTTP Response)을 받아서
브라우저의 화면을 깨끗하게 지우고 받은 내용을 새로 표시하는 방식이다. 내용을 지우고 다시 그리면 브라우저의 깜빡임이 생기게 된다.
이러한 깜빡임 없이 원하는 부분만 다시 그리며 실시간으로 사용자와 상호작용하는 방식이 나타나고 사용자와 상호작용하는
웹 서비스를 선호하는 사용자가 증가하면서 RIA(Rich Internet Application) 기술의 발달이 촉진되었다.

상호작용하는 웹 서비스를 위해 숨겨진 프레임(Hidden Frame)을 이용한 방법이나 Long Polling, Stream 등 다양한 방법을 사용했다.
그러나 이러한 방식은 브라우저가 HTTP 요청를 보내고 웹 서버가 이 요청에 대한 HTTP 응답를 보내는 단방향
메세지 교환 '규칙'을 변경하지 않고 구현한 방식이다. 그렇기 때문에 상호작용하는 웹 페이지를 복잡하고 어려운 코드로 구현해야 했다.

보다 쉽게 상호작용하는 웹 페이지를 만들려면 브라우저와 웹 서버 사이에 더 자유로운 양방향
메시지 송수신(bi-directional full-duplex communication)이 필요하다. 그래서 HTML5 표준안의 일부로 WebSocket API(이후 WebSocket)가 등장했다.

WebSocket은 그 이름에서 알 수 있듯이 소켓을 이용하여 자유롭게 데이터를 주고 받을 수 있다.
즉 기존의 요청-응답 관계 방식보다 더 쉽게 데이터를 교환할 수 있다.

**웹소켓 프로토콜**

표준 WebSocket의 API는 W3C에서 관장하고, 프로토콜은 IETF(Internet Engineering Task Force)에서 관장한다.
그리고 WebSocket은 다른 HTTP 요청과 마찬가지로 80번 포트를 통해 웹 서버에 연결한다. HTTP 프로토콜의 버전은 1.1이지만 다음 헤더의 예에서 볼 수 있듯이,
Upgrade 헤더를 사용하여 웹 서버에 요청한다. 당연한 이야기겠지만 클라이언트인 브라우저와 마찬가지로 웹 서버도 WebSocket 기능을 지원해야한다.

	GET /... HTTP/1.1  
	Upgrade: WebSocket  
	Connection: Upgrade  

브라우저는 "Upgrade: WebSocket" 헤더 등과 함께 랜덤하게 생성한 키를 서버에 보낸다. 웹 서버는 이 키를 바탕으로 토큰을 생성한 후 브라우저에 돌려준다.
이런 과정으로 WebSocket 핸드쉐이킹이 이루어진다.

그 뒤 Protocol Overhead 방식으로 웹 서버와 브라우저가 데이터를 주고 받는다. Protocol Overhead 방식은
여러 TCP 커넥션을 생성하지 않고 하나의 80번 포트 TCP 커넥션을 이용하고, 별도의 헤더 등으로
논리적인 데이터 흐름 단위를 이용하여 여러 개의 커넥션을 맺는 효과를 내는 방식이다.

이런 방식을 사용하기 때문에 방화벽이 있는 환경에서도 무리 없이 WebSocket을 사용할 수 있다.

* TCP socket과 websocket의 차이점이라 한다면, 컨넥션 방식에서의 차이가 있다. (websocket은 http request를 통해 컨넥션을 맺음)

## Socket.io?

Socket.io는 JavaScript를 이용하여 브라우저 종류에 상관없이 실시간 웹을 구현할 수 있도록 한 기술이다.

Guillermo Rauch가 만든 Socket.io는 WebSocket, FlashSocket, AJAX Long Polling, AJAX Multi part Streaming,
IFrame, JSONP Polling을 하나의 API로 추상화한 것이다. 즉 브라우저와 웹 서버의 종류와 버전을 파악하여 가장 적합한 기술을 선택하여 사용하는 방식이다.
가령 브라우저에 Flash Plugin v10.0.0 이상(FlashSocket 지원 버전)이 설치되어 있으면
FlashSocket을 사용하고, Flash Plugin이 없으면 AJAX Long Polling 방식을 사용한다.

개발자가 각 기술을 깊이 이해하지 못하거나 구현 방법을 잘 알지 못해도 사용할 수 있다.
Web Socket과 달리 Socket.io는 표준 기술이 아니고 Node.js 모듈로서
Guillermo Rauch가 CTO로 있는 LearnBoost(https://www.learnboost.com) 라는 회사의 저작물이며 MIT 라이센스를 가진 오픈소스이다.
현재 Node.js가 아닌 다른 프레임워크에서 Socket.io를 사용할 수 있도록 하는 시도가 있다.
