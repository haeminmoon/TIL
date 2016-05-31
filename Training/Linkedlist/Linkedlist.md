#linkedList

##단순 연결 리스트

단순 연결 리스트(simple linked list, singly linked list)는 가장 단순한 연결 리스트의 형태로 각 노드들은 다음 노드를 가리키는 하나의 참조만을 갖는다. 
다음 노드의 참조밖에 가지고 있지 않으므로 노드의 접근은 한 방향으로만 가능하다.

헤더는 처음 노드의 참조만 가지고 있으며 처음 노드는 두번째 노드, 두번째 노드는 세번째 노드를 가리키고 있으며 마지막 노드가 가리키는 참조값은 null이 된다.
즉, 헤더가 가리키는 노드가 처음 노드며 참조값이 null인 노드가 마지막 노드가 되는 것이다. 

**검색 효율면에서는 배열에 비해 불리하지만, 데이터의 삽입삭제가 잦은 경우에는 linkedlist가 유리하다**

Issue : 
	데이터 삽입, 삭제, 검색으로 구현한다.