# Hashcode

자바 해시코드(hashcode) 란?
객체를 구별하기 위해 고유한 정수값으로 출력시켜주는 메소드가 hashCode()이다.
객체 참조변수를 출력할 때, 출력되는 Reference Address는 바로 hashCode를 16진수로 출력한 값이다.

hashCode() 메소드는 무엇을 반환하며 어떻게 구현되어 있을까?
reference 주소를 반환해준다.

- Object 클래스 내부의 hashCode() 메소드 구현
public native int hashCode();

- String 클래스 내부의 hashCode() 메소드 구현


	public int hashCode() {
		int h = hash;
		if(h==0 && value.length > 0) {
			char val[] = value;

			for(int i=0; i < value.length; i++) {
				h = 31 * h + val[i];
			}
			hash = h;
		}
		return h;
	}

**31을 더하는 이유**   
  31은 소수이면서 홀수이다. 소수를 사용하는 장점은
명확하지는 않지만 전통적이다.
31이 좋은 속성은 곱셉 변화 및 성능 향상을 위한
감산에의해 대체될 수 있다.
문자열의 각각 Byte의 ASCII 코드 공식을 통해 더해진
총합을 hash값으로 사용하고 있다.



**equals()메소드를 재정의할 때 hashCode() 메소드도 재정의를 해야하는 이유는 무엇인가요?**
hashcode는 데이터셋이나 해시테이블을 쓰기위한 하나의 생성된 인덱스라고 볼 수 있다.
우리가 자주쓰는 Integer클래스나 String클래스 같은 경우 같은 멤버 값에 대해서
같은 hashcode가 나올 수 있도록 오버라이딩 되어 있다.
object클래스 안의 hashcode메소드는 쓰레기 값을 반환해준다고 보면된다.
즉, 사용자 정의된 클래스의 객체를 생성하여 hashcode를 찍어보면 멤버변수가 같다할지라도
hashcode가 제각각 다른 것을 알 수 있다.

이는 사용자가 hashcode를 오버라이딩해서 만들어써야 한다는 뜻이다.
set의 관점에서 보면 모든 들어오는 자료들에 대하여 해시테이블을 준다
즉, 참조만을 받아서 저장해주는 형태,
그같은 테이블에 대해서 equals연산을 수행해주며, 그결과 같으면 set에 들여보내지 않는다.
즉, 사용자 정의 클래스르 equals만 재정의해주고 hashcode()메소드는 재정의 해주지 않으면
서로 다른 집합이기 때문에 무조건 들어간다.

** equals같은 메소드를 오버라이딩할 때, public int hashCode()를 반드시 오버라이드 해야한다. **
equals()메소드가 true이면 두 객체의 hashCode값은 같다.
equals()메소드가 false이면 두객체의 hashCode가 꼭 다를 필요는 없다.
hashCode를 재정의 하지 않으면 위반되는 핵심규약은 같은 객체는 같은 해시코드 값을 가져야 한다는 규약이 위반되는 것이다.
즉, a.equals(b) 라면 a.hashCode()와 b.hashCod()의 값이 같다고 가정한다.
따라서 equals() 메소드를 override 했다면
hashCode()메소드도 override해주어야 한다.
아래 이미지는 str1과 str2의 객체가 서로다르지만
String클래스에서 equals()메소드를 재정의하여 객체의 내용이 같으면 equals() 메소드의 결과가 true가 나온다. 결론적으로 equals()메소드가 true이므로 hashCode()의 값은 동일하다.



결론적으로 equals() 메소드를 재정의하면
hashCode() 메소드도 재정의해줘야 한다.

equals()가 true이면 hashCode()의 값은 같다.
하지만 hashCode()의 값이 같다해서 두 객체가 같은 객체라고는 볼 수 없다.

[참조 URL](http://blog.naver.com/PostView.nhn?blogId=premiummina&logNo=220696126884)



