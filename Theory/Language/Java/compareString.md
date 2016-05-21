#equlas, ==, compareTo 등 문자열 비교와 메서드에 대한 분석

**Java에서 equals()를 사용하여 객체들이 멤버변수들의 값을 비교할때는 Override를 해줘야한다.**

		public class test{
			public static void main(String[] args) {
				equalTest e1 =new  equalTest(1, "test");
				equalTest e2 =new  equalTest(1, "est");
				
				System.out.println(e1.equals(e2));
			}
		}

		class equalTest{
			int num;
			String str;
			
			public equalTest(int num, String str) {
				this.num = num;
				//this.str = str;
			}
			
			@Override
			public boolean equals(Object obj) {
				return this.num==((equalTest)obj).num && this.str==((equalTest)obj).str;
			}
		}	//결과는 false!


그 이뉴는 equlas는 객체의 고유 값을 비교하기 때문에, 그 객체가 같은 객체인지만을 판별한다. 그래서 재정의를 통해 비교해야함.


**equals와 ==의 차이**

		public class test{
			public static void main(String[] args) {
				
				String a="test";
				String b="test";
				String c=new String("test");
				String d=new String("test");
				
				System.out.println(a==b);			//true
				System.out.println(a.equals(b));	//true
				System.out.println(a==c);			//false
				System.out.println(a.equals(c));	//true
				System.out.println(c==d);			//false
				System.out.println(c.equals(d));	//true
			}
		}

- Java에서 String은 call by reference이다. 그래서 그냥 new연산자를 사용하지 않아도 객체가 생성됨.
- new를 사용하여 생성하면, 무조건 객체가 새로 생성된다.
- String a="test", String b="test"의 경우 a와 b는 참조값이 같기 때문에 b가 a의 참조값을 가르킨다.
- String class에는 equals가 override 되있음.

	==은 참조하고 있는 값을 비교하는 것
	equals는 객체 고유의 값을 비교 

	**그래서 문자열을 비교할때는 equals를 사용해서 비교해야함**가


[compareTo 문자열을 비교하는 메서드 URL](http://najuung.tistory.com/42)