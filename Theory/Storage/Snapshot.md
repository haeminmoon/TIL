# Snapshot

## Snapshot이란?

일반적으로 스냅샷이란, 읽기만 가능한 특정 시간의 가상 복제 파일시스템이라 할수 있다. 
스냅샷이란 특정 시간에 파일시스템을 복사해서 (Point-In-Time Copy) 보관하다가 나중에 원본에 문제가 생겼을 때 복원을 해주는 기능이다. 
데이터를 복사했던 시간까지는 복원을 할수 있으니 스냅샷을 짧은 간격으로 생성해 놓으면 그만큼 가장 최근 데이터로 돌려 놓기가 수월하다. 
업계에서는 이것을 RPO(Recovery Point Objective)라고 하는데 예를 들어 1시간 간격으로 스냅샷을 생성하면 원본 데이터가 손실되더라도 
손실된 시간으로부터 1시간 이전까지로는 데이터를 복원할수 있기 때문이다.

[스냅샷 참조 URL](http://hybridstoragekorea.blogspot.kr/2013/10/blog-post_4204.html)