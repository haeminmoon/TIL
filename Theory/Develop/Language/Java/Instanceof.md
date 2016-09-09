#Instanceof

	참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 instanceof 연산자를 사용합니다. 주로 조건문에 사용되며, instanceof의 왼쪽에는 참조변수를 오른쪽에는 타입(클래스명)이 피연산자로 위치합니다. 그리고 연산의 결과로 boolean값인 true, false 중의 하나를 반환 합니다.

	instanceof를 이용한 연산결과로 true를 얻었다는 것은 참조변수가 검사한 타입으로 형변환이 가능하다는 것을 뜻합니다.

	public class Instanceof {
	    public static void main(String[] args) {
	 
	        FireEngine f = new FireEngine();
	        Ambulance a = new Ambulance();
	         
	        Instanceof test = new Instanceof();
	        test.doWork(f);
	        test.doWork(a);
	 
	    }
	 
	    public void doWork(Car c) {
	        if (c instanceof FireEngine) {
	            FireEngine f = (FireEngine)c;
	            f.water();
	             
	        } else if (c instanceof Ambulance) {
	            Ambulance a = (Ambulance)c;
	            a.siren();
	        }
	    }
	}
 
	class Car {
	    String color;
	    int door;
	 
	    void drive() { //운전하는 기능
	        System.out.println("drive, brrrr~");
	    }
	 
	    void stop() { // 멈추는 기능
	        System.out.println("stop!!!");
	    }
	}
	 
	 
	class FireEngine extends Car {  // 소방차
	    void water() {              // 물 뿌리는 기능
	        System.out.println("warter!!!");
	    }
	}
	 
	class Ambulance extends Car {  // 앰뷸런스
	    void siren() {             // 사이렌을 울리는 기능
	        System.out.println("siren~~~~");
	    }
	}

	실행결과 :
		warter!!!
		siren~~~~


**Class변수 instanceof Class이름**

[참조 URL](http://arabiannight.tistory.com/entry/301)