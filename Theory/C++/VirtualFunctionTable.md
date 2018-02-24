#VirtualFunctionTable

**C++은 다형성, Polymophism을 지원하기 위해서 virtual 키워드를 제공한다.

부모 클래스 내에서 virtual 로 선언된 함수는 자식 클래스에서 재정의 될 수도 있다.

재정의 되지 않는다면, 호출시 부모 클래스의 함수가 호출되고, 재정의 된다면 호출 시 자식 클래스의 함수가 호출된다.

Base, Derived 두개의 클래스가 있다고 가정 해 보자. Base 클래스는 Derived 클래스의 부모 클래스다.  

각각 start 란 virtual 함수를 가지고 있다고 하자. virtual 함수는 재정의(Override) 될 것이다.

	Base* pBase = new Derived();

	pBase->start();

컴파일러는 pBase 가 Derived 타입인지, Base 타입인지 알지 못한다. 

즉, start 를 호출하는 런타임 시점까지는 Derived 클래스의 재정의된 start 가 호출될지 부모 클래스의 start 가 호출될지 모른다.

그렇다면, 프로그램은 어떻게 런타임에 자신의 클래스에 맞는 함수를 찾아가서 호출하는 것일까?

**답은 가상 함수 테이블(vftbl) 에 있다.** 

	클래스 내에 virtual 함수가 존재하고, 이 virtual 함수가 상위 클래스의 함수를 override 하거나, 
	하위 클래스에 의해 override 된다면 컴파일러는 클래스 내에 이 함수에 대한 가상 함수 테이블을 생성한다.


**__vftble은 각 인스턴스마다 갖는 것이 아니라, 클래스 별로 가지고 있음**


##vfptr

**가상함수를 갖는 클래스로 인스턴스를 생성하면 컴파일러가 자동으로 만들어주는 멤버변수**

이때 가상함수가 있는 클래스의 객체의 크기는 4바이트가 더해진다.

이런 식으로 객체 자신이 자기가 참조하고 있는 클래스의 가상함수 테이블을 가리키는 포인터를 가지고 있고,

이 가상함수테이블에는 해당 클래스가 실제로 실행할 함수의 주소값이 저장되어 있는것입니다.

컴파일러는 이렇게 가상함수의 기능을 구현하고 있는 것