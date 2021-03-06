# Integration Test

## 정의

통합 테스팅에서 각각의 소프트웨어 모듈들이 논리적으로 통합되고 그룹으로 테스트된다.

일반적인 소프트웨어 프로젝트는 다른 프로그래머들이 코딩한 여러 소프트웨어 모듈로 구성되어 있다.
통합 테스팅은 이러한 모듈들 사이의 데이터 통신(communication)을 확인하는 데에 초점을 맞춘다.

이러한 이유로, 이것은 'I & T'(통합 및 테스팅), '문자열 테스팅' 때로는'스레드 테스팅'이라 불리기도 한다.

## 통합 테스팅의 필요성

각 소프트웨어 모듈이 단위 테스트되었지만, 결함들은 여전히 다음과 같이 다양한 이유로 존재한다.

* 일반적으로 모듈은 다른 프로그래머와 다른 이해와 프로그래밍 로직을 가진 개개의 소프트웨어 개발자가 설계한다. 
* 통합 테스팅은 소프트웨어 모듈들이 결속하여 동작하는지 검증하기 위해 필요하게 된다.
* 모듈 개발시에, 고객에 의해 요구사항가 변할 수 있는 폭넓은 가능성들이 존재한다. 새로운 요구사항들은 단위 테스트되지 않을것이고 그렇기에 통합 테스팅이 필요하게 된다.
* 데이터베이스로 된 소프트웨어 모듈들의 인터페이스들이 잘못되었을 수 있다.
* 외부 하드웨어 인터페이스들이 있는 경우, 잘못되었을 수 있다.
* 부적절한(inadequate) 예외 처리가 문제들을 발생시켰을 수도 있다.

[Integration-Test](https://sites.google.com/site/knowingmoresoftware/software-testing/integration-testing)