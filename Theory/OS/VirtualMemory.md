#VirtualMemory

[참조 URL1](http://snowwiki.fuzewire.com/wiki/applied_sciences/computer_science/infor_science/read.html?psno=*D30ACDF27AEAFC44D3AF426EF24F0DA54E784B89)
[참조 URL2](http://destiny738.tistory.com/324)
[참조 URL3](http://sweeper.egloos.com/viewer/2988689)


- 응용 소프트웨어는 하드웨어에 직접 접근하는 것이 아니고 운영 체제의 메모리에 먼저 접근한 후 실행
- 응용 소프트웨어와 물리 메모리 사이에 가상의 계층을 만들어 응용 소프트웨어가 접근하게 함

##페이징(Paging)

- Vitual Memory를 논리적 의미와는 관계 없이 모두 같은 크기의 블록으로 나누어 운용하는 기법
- 나누어진 일정한 크기의 블록을 페이지라고 부름
- 페이지 단위만큼만 메모리로 읽어 들임으로써 보다 많고 불연속적인 데이터 영역을 실제 메모리에 저장

- 단점:
	- 내부 단편화가 발생 할 수 있음
	- 외부 단편화가 없어 주기억장치를 효율적으로 사용할 수 있으나 페이지 테이블을 자주 참조하고 실제 메모리를 계산해야함

##세그멘테이션

- Vitual Memory를 서로 크기가 다른 논리적 단위인 세그먼트로 분할하고 메모리를 할당하며 주소 변환을 함
- 메모리에 적재될 때 빈 공간을 찾아 할당하는 사용자 관점의 가상 메모리 관리 기법

- 단점:
	- 하나의 세그먼트 단위로 통제가 가능한 장점이 있으나 서로 다른 크기의 세그먼트들에 대해 필요 시에 메모리에 올리고 필요없을 경우 내리면 외부 단편화가 생기는 문제점이 있음

