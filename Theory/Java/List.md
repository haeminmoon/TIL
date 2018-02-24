#ArrayList, LinkedList

**LinkedList 와 ArrayList 는 모두 Java에서 제공하는 List 인터페이스를 구현한 Collection 이다. 
하지만 내부적으로 서로 다른 점이 존재하며, 어떠한 차이가 있는지 LinkedList 와 ArrayList 를 어떻게 적절하게 사용 할지 간단히 정리 해 보려 한다.** 


**먼저 위와 같은 List 인터페이스를 구현하는 LinkedList 또는 ArrayList 를 왜 사용할까?**

Java에서는 보통 여러 개의 Primitive Types (기본 자료형) 또는 Reference Type(인스턴스) 를 저장 하기 위해서 배열을 사용 하곤 한다. 
하지만 배열은 초기화 시 배열의 길이를 초기화 해야 하며, 생성된 배열은 길이를 동적으로 변경 할 수 없다는 점 때문에, 
데이터를 관리 할 때 이러한 점을 고려해야 하는데, 얼마나 많은 데이터를 사용하게 될지 예상하기 힘들 뿐 만 아니라, 가변적으로 리스트의 수를 늘려야 할 때도 있다.

Java 1.0 에서는 이러한 문제를 해소 하기 위해 Vector를 주로 사용 하고는 했다.
하지만 Vector 역시 초기화 시 10 으로 capacity가 정해져, capacity 이상이 되며 두배 씩 늘려 나가게 되고, 
다수의 Thread에 대한 접근에 동기화를 보장 하는 등의 성능 이슈 등으로 인해, 
1.2 이후 Version 에서는 호환성을 위해 제공 한다고 보며되며, List 인터페이스를 구현한 리스트로 대체 되었다.


**동기화 이슈**

Java 1.0 의 Vector 클래스는 다수의 Thread에 대해 동기화를 보장한다고 하였다. LinkedList 또는 ArrayList 는 Thread Safe한 구조를 개발자가 고려해야 하며, 필요하다면 Collections.synchronizedList(List<T> list)  를 통해 동기화를 제공하는 List 를 구현 할 수 있다.

- ArrayList

ArrayList는 내부적으로 자료를 Array구조로 가지며, 데이터의 추가/삭제를 위해서는 임시배열을 생성해 데이터를 복사하는 방법을 사용하고 있다.

- LinkedList

LinkedList 는 데이터를 저장하는 각 노드가 이전 노드와 다음 노드의 상태만 알고 있다고 보면 된다. 

ArrayList 와 같이 데이터의 추가/삭제 시에 불필요한 나머지 데이터의 복사가 이루어 지지 않아 데이터의 추가/삭제 시에 유리하지만, 반면 데이터의 검색 시에는 ArrayList 와 비교해 불리 하다고 볼 수 있다.


**데이터의 검색 / 삽입 / 삭제 시 성능 비교**

- 검색

		위에 설명 했지만 데이터 검색 시에는 ArrayList 가 검색 동작이 LinkedList에 비해 굉장히 빠르다. 

		ArrayList 는 인덱스를 기반으로 한 자료 구조 이며, get(int index) 를 통해 O(1) 의 시간 복잡도를 가지며, LinkedList 는 linked list 로 이루어져 있어, 검색 시 모든 요소를 탐색 해야 하기 때문에, 최악의 경우에는 O(N) 의 시간 복잡도를 가진다



- 삽입 & 삭제

		LinkedList 의 데이터의 삽입/삭제 시에는 ArrayList 와 비교해 굉장히 빠른데, LinkedList 이전 노드와 다음 노드를 참조하는 상태만 알고 있으면 되며, 삽입/삭제 가 일어 날 때 참조 상태만 변경 하여 O(1)의 시작 복잡도를 가진다. 

		하지만 ArrayList 의 경우 삽입/삭제 이후 다른 데이터를 복사해야 하기 때문에 최악의 경우 O(N) 의 성능을 내게 된다.



__정리__

	Array | 정적인 길이를 제공하는 배열
	
	Vector | Java 1.0 에서 추가, 동기화 기능이 제공되는 가변이 가능한 자료구조

	ArrayList | Java 1.2 에서 추가, Vector를 대체해서 사용가능하며, 동기화가 제공되지 않음. 
             데이터의 검색에 유리하며, 추가/삭제에는 성능을 고려해야 한다.

	LinkedList | Java 1.2 에서 추가, ArrayList 에 비해 데이터의 추가/삭제에 유리하며, 
			 데이터 검색 시에는 성능을 고려해야 한다.
