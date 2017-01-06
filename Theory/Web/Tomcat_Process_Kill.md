# Tomcat process kill command

## Tomcat port conflict

실행 -> cmd
1. netstat -ao 로 전체 검색 [tomcat port PID 확인]
2. taskkill /f /im PID
