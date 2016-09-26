#Singleton

**Singleton Pattern** : 프로그램 라이프사이클 동안 하나의 클래스에 하나의 인스턴스생성만을 허락하는 패턴이다.


	public class Singleton {
		private static Singleton instance = null;
		private Singleton(){ }

		public static Singleton getInstance(){

			if( instance == null ){
				//인스턴스화 직전의 작업만 동기화시킨다.
				synchronized(Singleton.class){
					if( instance == null ){
						instance = new Singleton();
					}
				}
			}
		return instance;
		}
	}
	
	
 
Singleton은 하나의 인스턴스만을 허용하기 때문에 앞서본 Factory class와도 자주 결합된다. 인스턴스를 뽑아내는 Factory가 여러개일 필요가 없으니말이다.
 
c++로 가면 Singleton에 정적 초기화를 통한 인스턴스 생성부터 죽었다 살았다 하는 피닉스싱글톤 까지,
java에서의 방법론보다 더 많은 구현방법을 가진다. 객체의 '소멸'에 대한 이슈때문인데 아직 완벽한 싱글톤이 없다 할 정도로 발전이 많이 필요한 부분이다.

[참조 URL](http://alleysark.tistory.com/entry/Design-pattern-Singleton)