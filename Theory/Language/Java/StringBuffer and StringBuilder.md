#StringBuffer and StringBuilder

**Immutable 한 String 클래스**

String 클래스는 Immutable한 객체다. 불변의 라는 뜻인데, 한번 생성된 객체는 그 값을 바꿀 수 없다는 의미로 해석하면 된다.

이말은 String 가 변경되면 기존의 String 객체는 버려지게(더 이상 참조하지 않는 다면) 되고  새로운 String 객체가 생성 된다는 말이다.

StringBuffer 와 StringBuilder

지금 까지 String 클래스의 특징을 살펴 보았는데, 이러한 String 클래스의 Immutable 한 특성을 보완 하기 위해
StringBuffer 클래스와 StringBuilder 클래스가 존재 한다. 이 두 클래스는 문자열을 생성하고 변경 하는데 용이 하다.

자세한 내용은 아래의 Java API Document를 참조 하면 된다.

StringBuilder 
[StringBuilder doc](http://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html)

StringBuffer
[StringBuffer doc](http://docs.oracle.com/javase/7/docs/api/java/lang/StringBuffer.html)

- 두 클래스의 역할은 비슷 하지만. 중요한 차이점이 존재하는데 멀티 Thread 환경에서의 동작이다. 
StringBuffer 는 Thread safe 한 클래스이고, StringBuilder 는 그렇지 못하다. 
다수의 Thread 에서 StringBuilder 클래스로 부터 생성된 객체에 접근 한다면 StringBuilder 대신에 반드시 StringBuffer 로 대체 해야 한다.
