# pay_jihyun

### 개발 프레임웍크 및 버전

- spring boot 2.2.2
- mysql 8.0.18
- java 8
- maven

### 문제해결 방법

- 

### 빌드 및 실행 방법
- 빌드
- Run -> payJihyunApplication

- 실행방법
크롬 앱스토어 "Talend API Tester - Free Edition" 설치 및 이용함

- 1번 API
- Method : GET 설정, http://localhost:8080/one
- Send 버튼클릭

- 2번 API
- Method : GET 설정, http://localhost:8080/two
- Send 버튼클릭

- 3번 API
- Method : GET 설정, http://localhost:8080/three
- Send 버튼클릭

- 4번 API
- Method : POST 설정, http://localhost:8080/four
- Headers : Content-Type, application/json
- Body : 예시
{
  "brName":"판"
}
- Send 버튼클릭

- Response : 예시결과
[
{
"brName": "A",
"brCod": "판교점",
"sumAmt": 171210000
}
]
