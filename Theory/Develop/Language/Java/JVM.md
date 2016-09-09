#JVM 메모리 구조

- 응용프로그램이 실행되면, JVM은 시스템으로부터 프로그램을 수행하는데 필요한 메모리를 할당받고 JVM은 이 메모리를 용도에 따라 여러 영역으로 나누어 관리한다. 그 중 3가지 주요영역(Method Area, 호출스택, Heap)에 대해서 알아보도록 하자. 

1. 메소드영역(Method Area)
		프로그램 실행 중 어떤 클래스가 사용되면, JVM은 해당 클래스의 클래스파일(*.class)을 읽어서 분석하여 클래스에 대한 정보(클래스 데이타)를 Method Area에 저장한다. 이 때, 그 클래스의 클래스변수(class variable)도 이 영역에 함께 생성된다. 

		프로그램 실행 중 클래스가 사용되면 JVM은 해당 클래스 파일을 읽어서 분석하여 클래스 정보(인스턴스 변수 / 메소드 코드등) 를 Method Area에 저장한다. 이때, 그 클래스의 클래스 변수 (인스턴스 변수) 도 이 영역에 함께 생성된다.

		프로그램이 실행되면 모든 코드가 저장되어 있는 상태가 아니다, new 를 통해 동적으로 생성되기 이전에는 텍스트 일 뿐이다.

		new 를 통해 생성 후에 메소드를 실행하게 되면, 이때 해당 클래스 코드에 대한 정보를 Method Area에 저장 하게 된다. 저장되는 내역은 아래와 같다.

		 - Type Infomation

		    * Type은 클래스와 인터페이스를 통칭하는 것으로 이해하면 된다.
		    Type 의 전체 이름 ( 패키지명 + 클래스명 )
		    Type 의 직계 하위 클래스 전체 이름
		    Type 의 클래스 / 인터페이스 여부
		    Type 의 modifier ( public / abstract / final )
		    연관된 인터페이스 이름 리스트
		    
		 - Runtime Constant Pool 

		   * Type의 모든 상수 정보를 가지고 있다.
		   Type, Field, Method로의 모든 Symbolic Reference 정보를 포함
		   Constant Pool의 Entry는 배열과 같이 인덱스 번호를 통해 접근
		   Object의 접근 등 모든 참조를 위한 핵심 요소

		 - Field information

		  * Field는 인스턴스 변수를 가르킨다.
		  Field Type
		  Field modifier ( public / private / protected / static / final / volatile / transient )

		 - Method Information

		  * Constructor도 포함
		 Method Name
		 Method Return Type
		 Method Parameter 수와 Type 
		 Method modifier ( public / private / protected / static / final / syncronized / native / abstract )
		 Method 구현 부분이 있을 경우 ( abstract 또는 native 가 아닐 경우 )
		 - Method의 byteCode
		 - Method의 Stack Frame의 Operand Stack 및 Local variable section의 크기
		 - Exception Table

		- Class Variable

		 * Class Variable 은 Static Variable을 의미 한다.
		- 모든 인스턴스에 공유 되며 인스턴스가 없어도 직접 접근이 가능하다.
		- 이 변수는 인스턴스의 것이 아니라 클래스에 속하게 된다.
		- 클래스 를 사용 하기 이전에 이 변수들은 미리 메모리를 할당 받아 있는 상태가 된다.
		- final class 변수는 상수로 치환 되어 Runtime Constant Pool에 값을 복사한다.

		* static 변수는 Method Area의 Class Variable에 저장
		* static 클래스형 변수는 레퍼런스 변수만 저장되고 실제 인스턴스는 Heap에 저장되어 있다.

		그 후 이 인스턴스의 변수를 저장하기 위해 Heap에 메모리가 확보가 되고 Heap의 인스턴스가 Method Area의 어느 클래스 정보와 연결되는지 설정 하게 된다.

2. 힙(Heap)
		인스턴스가 생성되는 공간. 프로그램 실행 중 생성되는 인스턴스는 모두 이 곳에 생성된다. 즉, 인스턴스변수(instance variable)들이 생성되는 공간이다. 

3. 호출스택(Call Stack 또는 Execution Stack)

	 	호출스택은 메서드의 작업에 필요한 메모리 공간을 제공한다. 메서드가 호출되면, 호출스택에 호출된 메서드를 위한 메모리가 할당되며, 
	 	이 메모리는 메서드가 작업을 수행하는 동안 지역변수(매개변수 포함)들과 연산의 중간결과 등을 저장하는데 사용된다. 그리고, 메서드가 작업을 마치게 되면, 할당되었던 메모리공간은 반환되어 비워진다. 

		각 메서드를 위한 메모리상의 작업공간은 서로 구별되며, 첫 번째로 호출된 메서드를 위한 작업공간이 호출스택의 맨 밑에 마련되고, 
		첫 번째 메서드 수행중에 다른 메서드를 호출하게 되면, 첫 번째 메서드의 바로 위에 두 번째로 호출된 메서드를 위한 공간이 마련된다. 
		이 때 첫 번째 메서드는 수행을 멈추고, 두 번째 메서드가 수행되기 시작한다. 두 번째로 호출된 메서드가 수행을 마치게 되면, 
		두 번째 메서드를 위해 제공되었던 호출스택의 메모리공간이 반환되며, 첫 번째 메서드는 다시 수행을 계속하게 된다. 첫 번째 메서드가 수행을 마치면, 
		역시 제공되었던 메모리 공간이 호출스택에서 제거되며 호출스택은 완전히 비워지게 된다. 

		호출스택의 제일 상위에 위치하는 메서드가 현재 실행 중인 메서드이며, 나머지는 대기상태에 있게 된다. 
		따라서, 호출스택을 조사해 보면 메서드 간의 호출관계와 현재 수행중인 메서드가 어느 것인지 알 수 있다. 
		호출스택의 특징을 요약해보면 다음과 같다. 

		- 언제나 호출스택의 제일 위에 있는 메서드가 현재 실행 중인 메서드이다. 
		- 아래에 있는 메서드가 바로 위의 메서드를 호출한 메서드이다. 

**반환타입(return type)이 있는 메서드는 종료되면서 결과값을 자신을 호출한 메서드(caller)에게 반환한다. 
대기상태에 있던 호출한 메서드(caller)는 넘겨받은 반환값으로 수행을 계속 진행하게 된다.** 

4. Native Method Stack

		자바 이외의 이기종 언어에서 제공되는 Method의 정보가 저장되는 공간, JNI를 통해 표준에 가까운 방식으로 구현이 가능하다.


!!!java에서  multi thread programming 시, 구조는? 동기화가 될까? 아니면 각 영역을 분할해서 사용할까?
 멀티 쓰레드 프로그래밍 시에는, 힙영역은 공유하고, 스택 영역은 자신의 스택 영역을 갖게됨, 그래서 Thread-safe하지 않는 이슈에 주의하며 프로그래밍을 해야한다. 
 결론적으로 말하자면 heap영역 자체가 Thread-safe하지 않는 상태이다.

[예제 참조 URL](http://arabiannight.tistory.com/entry/자바Java-JVM-메모리-구조)