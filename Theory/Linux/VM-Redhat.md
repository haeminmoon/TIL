# VM-Redhat 설치 과정

## VM VirtualBox 설치
오라클 버츄얼 박스를 사이트에 들어가서 설치

## ISO Redhat-linux
ISO Redhat-linux를 다운로드 

## VM에 linux-RedHat 설치
1. 새로만들기 -> linux-redhat(bit) -> 확인
2. Linux-redhat 설정 -> 저장소 -> vdi 새로만들기 -> iso 가상 디스크 삽입 -> 실행
3. 실행 후 -> 스킵 -> YES -> 한국어 -> 영어 -> 마우스 선택 ( 제네릭 - PS/2 )
4. 디스크 사용자 지정으로 할당 -> swap(800mb로 설정) -> 만들기 완료
5. 새로 만들기 한번 더 클릭 -> 남은 디스크 모두 설정하여 만들기 ex3
6. 쭉 설치 진행 ( 서버로 설정 할꺼면 서버에 필요한 것들 추가해서 셋팅 )

## 인코딩 설정
설치 완료 후 인코딩 설정해 주기. 
1. 현재 설정된 인코딩 설정 확인
[root@localhost etc]$ echo $LANG
ko_KR.UTF-8

2. 인코딩 설정 해제
[root@localhost sysconfig]# unset LANG
[root@localhost sysconfig]# LANG=C

3. 사용 가능한 인코딩 설정 확인
[root@localhost etc]$ locale -a | grep ko
ko_KR
ko_KR.euckr
ko_KR.utf8
korean
korean.euc
ru_RU.koi8r
ru_UA.koi8u
tg_TJ.koi8t
uk_UA.koi8u

4. /etc/sysconfig/i18n 파일 수정
[root@localhost sysconfig]# vi i18n 
#LANG="ko_KR.UTF-8"
LANG="ko_KR.euckr"

# SSH와 CVS 연결을 위한 포트 포워딩
1. VM에서 파일 -> 설정 으로 들어가서, 호스트 IP 확인 ( only - ip .....)
2. 설치한 OS의 설정 -> 네트워크 -> NAT으로 설정 후 -> 고급 -> 포트포워딩
	- [HOST IP에 1번에서 찾은 HOST IP 입력, GUEST IP에 가상 OS에서 ifconfig 입력 후 확인]
	- [SSH PORT : 22, CVS PORT : 22] 포트마다 추가를 해주어야 함. (PUTTY나 CVS로 메인 PC에서 접속할 경우, HOST IP를 입력하고 접속해야함.)

[linux 한글 인코딩](http://egloos.zum.com/abctank/v/9215895)
[virtualBox 리눅스 SSH 연결 - NAT](http://zetawiki.com/wiki/VirtualBox_%EB%A6%AC%EB%88%85%EC%8A%A4_SSH_%EC%97%B0%EA%B2%B0_(NAT))
[VirtualBox에서 Red Hat 9 설치하기.](http://m.blog.naver.com/hks8902/220244567429)

