# Linux Command

## 리눅스 버전 확인
cat /etc/issue
or
cat /etc/redhat-release

## OS 커널 비트수 확인
getconf WORD_BIT

## 리눅스 CPU 정보 확인
cat /proc/cpuinfo

## 리눅스 메모리 정보 확인
cat /proc/meminfo

## 리눅스 DISK 용량 확인
df -h

## 리눅스 방화벽 포트 오픈 확인
http://zetawiki.com/wiki/%EB%A6%AC%EB%88%85%EC%8A%A4_%EC%9B%90%EA%B2%A9%EC%84%9C%EB%B2%84_%ED%8F%AC%ED%8A%B8_%EC%A0%90%EA%B2%80

* client port 확인
netstat -nap | grep LISTEN
netstat -nap | grep servicename(ex:webtob)

* destination port 확인
nc -z 0.0.0.0 80
	   [ip] [port] 