#Tree

##이진트리(BinaryTree)


 	- 일반적인 트리는 한 노드가 N개의 자식을 가질 수 있지만 이진트리의 경우 한 노드가 최대 2개의 자식만 가질 수 있다. 

 	- 다양한 분야에 활용되는 자료구조이다. 수식을 트리 형태로 표현하여 계산하게 하는 수식 이진 트리(Expression Binary Tree),
   	  아주 빠른 데이터 검색을 가능케 하는 이진 탐색 트리(Binary Search Tree) 등등.

 	- 이진트리의 종류 : 포화 이진 트리(Full Binary Tree), 완전 이진 트리(Complete Binary Tree),
                    높이 균형 트리(Height Balanced Tree), 완전 높이 균형 트리(Completely Height Balanced Tree) 

![image1](http://cfile27.uf.tistory.com/image/160DC4384F2693692D7BF3)


##포화 이진 트리(Full Binary Tree)

	- 모든 레벨의 노드가 꽉 차있는 이진 트리.

	- 단말 노드를 제외한 모든 노드의 차수가 2인 형태를 말한다.

![image2](http://cfile4.uf.tistory.com/image/12236F384F2693E9121BB3)


##완전 이진 트리(Complete Binary Tree)

	- 단말 노드들이 트리의 왼쪽부터 차곡차곡 채워진 형태. 

	- 무조건 왼쪽부터 채워져 있어야 한다.(왼쪽 하위 트리 중 하나라도 비워져있다면 해당 안됨)

![image3](http://cfile10.uf.tistory.com/image/132892354F2693DD1B4936)

##트리 순회법

	- 트리 순회 방법에는 3가지가 있다.

	- 전위 순회(Preorder Traversal), 중위 순회(Inorder Traversal), 후위 순회(Postorder Traversal) 

##전위 순회법(Preorder Traversal)

 1. 루트 노드부터 시작해서 아래로 내려 오면서

 2. 왼쪽 하위 트리를 방문하고 왼쪽 하위 트리의 방문이 끝나면

 3. 오른쪽 하위 트리를 방문하는 방식 

 ![image4](http://cfile3.uf.tistory.com/image/195405474F26960F04874F)

 ##중위 순회법(Inorder Traversal)

	 - 트리는 하위 트리의 집합이라고 할 수 있고 하위 트리 역시 또 다른 하위 트리의 집합이라고 할  수 있다.

	 - 따라서 아래와 같은 방법으로 탐색할 수 있다.

 1. 왼쪽 하위 트리부터 시작해서

 2. 루트를 거쳐

 3. 오른쪽 하위 트리를 방문하는 방법

![image5](http://cfile9.uf.tistory.com/image/110CF14C4F26961B1B6A7F)

	- 응용 사례 : 수식 트리(Expression Tree), 중위 표기식

	- (1 * 2) + (7 - 8)을 수식 트리로 표현하면 다음 그림과 같이 나타낼 수 있다.

![image6](http://cfile25.uf.tistory.com/image/1369F5364F26971E2CA092)

##후위 순회법(Postorder Traversal)

	- 전위 순회의 반대

 1. 왼쪽 하위 트리부터 시작해서

 2. 오른쪽 형제 노드를 방문 후

 3. 루트 노드를 방문하는 방법.

![image7](http://cfile25.uf.tistory.com/image/203FEA484F26962D05FDEF)

	- 응용 사례 : 후위 표기식. 후위 순회법을 통해 출력되는 노드를 살펴보면 후위 표기식으로 나타난다.

	- 1 2 * 7 8 - +

![image8](http://cfile25.uf.tistory.com/image/196E3F3C4F26972B06309F)
