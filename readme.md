## 진행 순서
1. docker desktop 실행
2. terminal 에 `$ docker-compose-up` 실행 # MongoDB 와 springBootServer 일괄 실행
3. 서버 API 접근 주소: `localhost:8080`
4. swagger 접근 주소: `http://localhost:8080/swagger-ui/index.html` # swagger 에서 source 경로를 `/v2/api-docs` 로 변경해주어야 함
5. mongoDB 에 들어가있는 data 목록은 `GET /localhost:8080/board/` 경로 혹은 mongoDB compass 에서 `localhost:27017` 로 접근하여 확인할 수 있음


## source code build 명령어
- `$ mvn package spring-boot:repackage`
