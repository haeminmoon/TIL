# Mount	

## Mount?
Windows에는 마운트(Mount)라는 개념이 별로 사용되지 않지만, 리눅스에서는 하드디스크의 파티션, CD/DVD, USB메모리 등을 사용하려면 특정한 위치에 연결을 해 줘야 한다. 이렇게 물리적인 장치를 특정한 위치(대개는 디렉토리)에 연결시켜 주는 과정을 마운트라고 한다.

			 <-3번
/dev/sda1/	 1번->     /data/	 <-2번    data.txt
물리적 장치        마운트 디렉토리		저장될 데이터

기차는 서울역에서 정차한다. (=디스크를 디렉토리에 마운팅)
홍길동은 서울역에서 기차를 탄다. (=데이터를 마운트 디렉토리에 저장)
기차는 홍길동을 태우고 목적지까지 간다. (=실제 물리적으로 디스크에 저장됨)

여기에서 기차는 리눅스 상에 있는 물리적 장치이고, 서울역은 마운트 된 디렉토리, 홍길동은 저장될 데이터라고 보면 된다.
test.txt라는 데이터를 /data 아래에 저장하면 실제로 해당 데이터는 /dev/sda1 디스크에 저장이 된다.
그렇다면 그 후 /dev/sda1에 /data2 디렉토리를 마운트 시키면 test.txt 데이터는 어떻게 될까?
정답은 test.txt는 안보이는 것일 뿐, 실제로는 /dev/sda1에 저장되어 있다.

유닉스에서는 마운트 되어있는 상태에서는 CDROM 드라이브의 eject 버튼이 먹히지 않는다.
그 이유는 아직 마운트 되어있기 때문에 유닉스에게 언마운트 명령을 주어야 그제서 eject가 먹힌다. 
(mount <-> umount)



[참조 URL](http://sksstar.tistory.com/7)