# Jenkins Install

## CI - Jenkins (2.49)

 1. linux: RedHat Jenkins 설치 방법

 	sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo

	sudo rpm --import http://pkg.jenkins-ci.org/redhat/jenkins-ci.org.key

	sudo yum install jenkins

 2. Jenkins Service start/stop/restart

	sudo service jenkins start/stop/restart

	sudo chkconfig jenkins on

	* 설치 확인  : rpm –qa | grep jenkins

 3. Jenkins에서 사용할 기본 톰캣 포트 변경 ( Jenkins는 톰캣에서 구동 )

 	vi /etc/sysconfig/jenkins

 	JENKINS_PORT="" <<변경

 4. Jenkins 사용을 위한 방화벽 설정

   sudo firewall-cmd --permanent --zone=public --add-port=9090/tcp sudo

   firewall-cmd --reload

 5. Jenkins Admin passwd 복사 경로

   vi /var/lin/jenkins/secrets/initialAdminPassword 복사 후, Jenkins WEB에 등록

 6. 필요한 플러그인 설치. 

 *-----WEB Admin 셋팅 완료-----* 

[Jenkins 설치](http://kimseunghyun76.tistory.com/353)


## Jenkins - Setting 

1. Jenkins : Join

2. jenkins management > Configure Global Security
	- Check jenkins' own user database
 	* Check 사용자의 가입 허용

	- Matrix-based security
 	* User/group to add : 추가 후, 권한 Check all

3. jenkins management > Plug-in Installration 
	- CVS, GIT, GRADLE, MAVEN, Publish Over SSH, Email Extension, LDAP,  View Graph... 등 필요한 플러그인 설치

4. jenkins management > Global Tool Configuration
 * 이미 설치 되어 있다면, 경로를 입력 아니면 Install automatically 진행 (빌드 시 설치 된다.)

	- JDK 설치 
	- Git 설치
	- Gradke 설치

 추가적으로 필요한 것들이 있다면 설치하면 됨. 

 ## jenkins - Add Project

 1. Freestyle project Click

 2. General
 	- 이름 설명 작성

 3. Manageing source code
 	- CVS or Git 정보 입력
 		* CVS의 경우 "CVSROOT"에 :pserver:userid@host_ip:cvs_path

 4. Controll build time
 	- Schedule 등록 / 크론탭 시간 규약
 	- Console Output - check
 
 5. Build
 	- Check Invoke Gradle (다른 툴을 사용하거나 script를 사용해도됨)

 6. After built
 	- 이메일 설정


## Installration Info
	var/lib/jenkins