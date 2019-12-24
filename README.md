# kpay_jihyun
카카오페이 과제

# 개발 프레임웍크 및 버전

- spring boot 2.2.2
- mysql 8.0.18
- java 8
- maven

# 문제해결 방법

1. 1번 API
* HTTP Method Get 사용
* 연도별 합계금액이 가장 많은 고객을 추출하였음

2. 2번 API
* HTTP Method Get 사용
* 연도별 거래가 없는 고객을 추출하였음

3. 3번 API
* HTTP Method Get 사용
* 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 추출하였음

4. 4번 API
* HTTP Method Post 사용
* 분당점과 판교점을 통폐합하여 판교점으로 이관된 것을 계좌정보의 관리점을 이관한 것처럼 추출하여 적용함
* 지점명을 입력하면 해당 지점의 거래금액 합계를 추출함
* 찾는 지점이 없으면 404 에러메세지가 나오게끔 적용함

# 빌드 및 실행 방법

## 빌드
- Run -> payJihyunApplication

## 실행방법
* 데이터는 사전에 Insert되어 있다고 가정한다. (과제 제시)
  * Database : pay_assign(utf8 설정), Table : ac_list, tr_list, br_list
  * 참고
      * 데이터베이스 : CREATE DATABASE PAY_ASSIGN DEFAULT CHARACTER SET UTF8;
      * 테이블 생성
      1. 거래내역 : 
      CREATE TABLE tr_list
      (
          tr_dt   VARCHAR(8)
        , acno    VARCHAR(8)
        , tr_s    INT
        , tr_a    LONG
        , fee     LONG
        , cncl_yn VARCHAR(1)
        , PRIMARY KEY (tr_dt, acno, tr_s)
      );
      2. 계좌정보 : 
      CREATE TABLE ac_list
      (
          acno    VARCHAR(8)
        , ac_nm   VARCHAR(50)
        , br_cod  VARCHAR(1)
        , PRIMARY KEY (acno)
      );
      3. 관리점정보 : 
      CREATE TABLE br_list
      (
          br_cod  VARCHAR(1)
        , br_nm   VARCHAR(50)
        , PRIMARY KEY (br_cod)
      );
  
* 빌드 진행후, 크롬 앱스토어 "Talend API Tester - Free Edition" 설치하여 아래 설정을 통해 결과 확인함

### 1번 API
1. Method : GET 설정, http://localhost:8080/one
2. Send 버튼클릭

### 2번 API
1. Method : GET 설정, http://localhost:8080/two
2. Send 버튼클릭

### 3번 API
1. Method : GET 설정, http://localhost:8080/three
2. Send 버튼클릭

### 4번 API
1. Method : POST 설정, http://localhost:8080/four
2. Headers : Content-Type, application/json
3. Body : 예시
{
  "brName":"판"
}
- Send 버튼클릭

4. Response : 예시결과
[
{
"brName": "A",
"brCod": "판교점",
"sumAmt": 171210000
}
]
