#Abstract

##abstract class

추상 클래스는 객체가 가지는 특성들을 추상화시켜 놓았을 뿐 아직 구체화 시키지 못한 클래스이므로, 이 추상클래스를 상속하는 하위 클래스에서 좀 더 구체화 시키도록 하는 것이다. 따라서, 추상클래스를 상위 클래스로 하여 상속하는 하위 클래스는 추상클래스 인 상위 클래스에서 완전히 구현하지 못한 부분들을 완전하게 구현해 주어야만 하위 클래스에 대한 객체 생성이 가능하고, 그렇지 못할 경우 하위 클래스는 상위 클래스인 추상 클래스와 같이 미완성이므로 자체적으로 객체를 생성할 수 없고, 이 하위 클래스는 다시 추상 클래스가 된다.

##abstract method

 - 추상메소드는 추상클래스와 마찬가지로 아직 구현이 이루어지지 않고 단지 그 프로토입만 가지고 있는 메소드이다.

  1. 추상메소드는 미완성 메소드이어야 하므로, 메소드의 몸체(body)를 가질수 없다

  2. 추상메소드는 클래스가 가져야 할 인터페이스에 대한 프로토타입(메소드의 형태)을 정의하고 있다.

  3. 추상메소드는 하위클래스가 가져야 할 인터페이스를 정의한다.

  4. 추상메소드를 포함하는 클래스는 반드시 추상클래스로 선언되어야 한다.

##추상클래스(메소드) 선언시 주의 사항

  1. abstract 메소드를 하나라도 가지고 있다면 그 클래스는 반드시 abstract 클래스로 선언되어야 한다.

  2. abstract 클래스는 직접 객체를 생성할 수 없다.

  3. abstract 클래스를 사용하기 위해서는 이 클래스를 상속한 클래스에서 abstract 메소드를 구현해 주어야만 한다.

  4. 만약 abstract 클래스를 상속했는데 abstract 메소드를 구현해 주지 않았다면 이 클래스 역시 abstract 클래스로 선언되어야 한다.

  5. abstact 한 메소드가 없어도 abstract class로 선언할 수 있다.( 상속을 통해서만 접근 가능)

 ****