# CDN( Origin[WAS] + Edge ) [Content Delivery Network]

## CDN?

 CDN이란, 콘텐츠 전송 네트워크이다. CDN은 주로 Static content를 호스트 하는데,
Static content는 이미지나 플래시 비디오 혹은 자바스크립트와 같이 다이나믹하게 작성할 필요없는 컨텐츠 파일을 말한다.

 네이버 혹은 아마존과 같이 많은 유저가 방문하는 사이트들은 CDN을 반드시 사용하는데,
많은 유저의 수를 절대 지원할 수 없기 때문이다. 따라서 다이나믹 페이지를 생성하는 서버 호스팅과 Static conecnt만을 호스팅 하는 서버가 있다.

## CDN의 원리

 CDN은 개념적으로 2개의 서버가 있다. 
 
	첫번째, Origin server이다. 이것은 WAS를 말한다.
	두번째, Edge server이다.

보통 Origin server는 하나고 Edge server들은 여러군데 퍼져있다. 즉, 이미지 파일을 하나의 origin server로 업로드를 한 후 서버에 특별한 신호를 보내면 이 파일이 Edge server들로 카피가 되는 것이다. Edge server와 가까운 곳에 있는 클라이언트들은 이 Edge server로 부터 이미지나 동영상을 다운 받게 되는 것이다. Cache의 개념이라고 생각하면 된다.

이 CDN을 통해 메인 컨텐츠를 생성하는 서버의 사용량을 줄일 수 있게 되고, 부하를 컨트롤 하는 것이다.


CDN 서비스를 제공하는 유명한 회사로는 아카마이 등이 있다.