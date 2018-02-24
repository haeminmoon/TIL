#Exception

##try-catch-finally

try문안의 수행할 문장들에서 예외가 발생하지 않는다면 catch문 다음의 문장들은 수행이 되지 않는다. 
하지만 try문안의 문장들을 수행 중 해당예외가 발생하면 예외에 해당되는 catch문이 수행된다.

ex)
	int c;

	try {
    	c = 4 / 0;
	}catch(ArithmeticException e) {
	    c = -1;
	}

	ArithmeticException 이 발생하면 c에 -1을 대입하도록 예외처리한 것이다.

finally 구문은 try문장 수행 중 예외발생 여부에 상관없이 무조건 실행된다.

##Exception과 RuntimeException

RuntimeException은 실행 시 발생하는 예외이고 Exception은 컴파일 시 발생하는 예외이다. 

	즉, Exception은 프로그램 작성 시 이미 예측가능한 예외를 작성할 때 사용하고 RuntimeException은 발생 할수도 발생 안 할수도 있는 경우에 작성한다.

	다른 말로 Exception을 Checked Exception, RuntimeException을 Unchecked Exception이라고도 한다.

**RuntimeException 은 명시적으로 catch 하지 않을 경우, catch 블록을 통과하게 된다.**

##method 예외 처리와, main 예외 처리의 차이점 

	public class FoolException extends Exception {   << RuntimeException or Exception

	}


	// 이 경우에는 메소드에 내에서 예외 처리가 발생한다.
	public class Test {
	    public void sayNick(String nick) {
	        try {
	            if("fool".equals(nick)) {
	                throw new FoolException();
	            }
	            System.out.println("당신의 별명은 "+nick+" 입니다.");
	        }catch(FoolException e) {
	            System.err.println("FoolException이 발생했습니다.");
	        }
	    }

	    public static void main(String[] args) {
	        Test test = new Test();
	        test.sayNick("fool");
	        test.sayNick("genious");
	    }
	}

	// 이 경우에는 main에서 예외 처리를 발생시킴. throws 구문을 이용해서 예외처리를 위로 보내는 것임.
	public void sayNick(String nick) throws FoolException {
	    if("fool".equals(nick)) {
	        throw new FoolException();
	    }
    	System.out.println("당신의 별명은 "+nick+" 입니다.");
	}

	public static void main(String[] args) {
    	Test test = new Test();
	    try {
	        test.sayNick("fool");
	        test.sayNick("genious");
	    }catch(FoolException e) {
	        System.err.println("FoolException이 발생했습니다.");
	    }
	}

**메소드에서 처리하는 것과 main 메소드에서 처리하는 것에는 아주 큰 차이가 있다.**

- 메소드에서 예외를 처리하는 경우에는 다음의 두 문장이 모두 수행이된다.

		test.sayNick("fool");
		test.sayNick("genious");

		물론 test.sayNick("fool"); 문장 수행 시에는 FoolException이 발생하겠지만 
		그 다음 문장인 test.sayNick("genious"); 역시 수행이 된다.

- 하지만 main 메소드에서 다음과 같이 예외 처리를 한 경우에는 두번 째 문장인 test.sayNick("genious");가 수행되지 않을 것이다. 이미 첫번 째 문장에서 예외가 발생하여 catch 문으로 빠져버리기 때문이다.


**프로그래밍 시 Exception을 처리하는 위치는 대단히 중요하다. 프로그램의 수행여부를 결정하기도 하고 트랜잭션 처리와도 밀접한 관계가 있기 때문이다.**

[참조 URL](https://wikidocs.net/229)
[참조 URL](http://www.nextree.co.kr/p3239/)
