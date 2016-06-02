#Thread

- 자바에서는 두 가지 방식으로 쓰레드를 사용할 수 있다.
	1. extend Thread
	2. implement Runnable


	성능상으론 모두 차이가 없지만, Runnable을 구현하여 사용하면 좋은점이 있다.

	1. 자바에서는 다중상속을 지원하지 않기 때문에, implement 하여 사용하면 다른 클래스 상속이 가능하다.
	2. 더욱 객체지향적인 구조를 갖게 된다.
	3. Thread class의 모든 것을 상속받는 것이 너무 부담되는 경우에는 Runnable을 구현하는 편이 더 좋다.

