# 온라인 주문 서비스 프로젝트

## 프로젝트 설명
- 스타벅스 사이렌 오더를 참고하여 설계된 Spring 프로그램
- 특정 매장으로부터 상품을 주문
- 개조가 없으면 주문할 수 없음
- MySQL 연결

## 프로젝트 구조
```
project-root
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- com.project.orderservice
|   |   |       |-- controller
|   |   |       |   |-- CustomerController.java
|   |   |       |   |-- GlobalExceptionHandler.java
|   |   |       |   |-- NewOrderRequest.java
|   |   |       |   |-- OrderController.java
|   |   |       |   |-- Response.java
|   |   |       |-- domain
|   |   |       |   |-- CreateCustomer.java
|   |   |       |   |-- CreateOrder.java
|   |   |       |   |-- Customer.java
|   |   |       |   |-- CustomerDTO.java
|   |   |       |   |-- Order.java
|   |   |       |   |-- OrderItem.java
|   |   |       |   |-- Product.java
|   |   |       |   |-- Store.java
|   |   |       |   |-- StoreProduct.java
|   |   |       |-- repository
|   |   |       |   |-- CustomerRepository.java (interface)
|   |   |       |   |-- OrderRepository.java (interface)
|   |   |       |   |-- StoreProductRepository.java (interface)
|   |   |       |-- service
|   |   |       |   |-- CustomerService.java
|   |   |       |   |-- OrderService.java
|   |   |       |   |-- StoreService.java
|   |   |       |-- OrderserviceApplication
|   |   |-- resources
|   |   |   |-- data
|   |   |       |-- data.sql
|   |   |       |-- schema.sql
|   |   |   |--application-local.yml
|   |-- test
|   |   |-- java
|   |   |   |-- com.project.orderservice
|   |   |       |--service
|   |   |       |   |-- OrderserviceApplication.java
|-- README.md
```

## 기술 스택
- **백엔드**: Spring Framework (Spring Boot, Spring JDBC)
- **데이터베이스**: MySQL
- **빌드 도구**: Gradle
- **환경**: Java17, IntelliJ
- **테스트**: JUnit5, Mockito

## 도메인
1. **주문(Order)**
    - 사용자는 원하는 수량만큼 상품을 주문할 수 있음.
    - 주문을 할 땐, 특정 매장을 지정해야 함.(재고)
    
2. **고객(Customer)**
    - 고객을 등록할 수 있음.
    - 이름, 주소, 전화번호가 필요.

3. **매장(Store)**
    - 매장을 등록할 수 있음.
    - 이름, 주소, 전화번호, 오픈/종료 시간이 필요.

4. **상품(Product)**
    - 상품을 등록할 수 있음.
    - 이름, 설명, 가격을 등록해야 함.

## 주요 도전 과제
1. **단위 테스트와 Mock 활용**
    - 단위 테스트를 JUnit 5와 Mockito를 활용해 Mock 데이터로 테스트를 진행.

2. **상품 주문**
    - 각 매장에는 판매할 수 있는 재고가 정해져 있음.
    - 재고를 업데이트 할 수 있어야 함.
    - 매장은 주문이 들어오면 재고가 존재하는 지 확인.
    - 만약 주문 내 하나의 상품이라도 품절일 경우에는 주문을 취소
    - 주문이 성공하면 매장 내 재고 개수 조정.

## 향후 개선 사항
1. **Spring Data JPA**로 마이그레이션

2. **알림 기능 추가**
    - 주문 알림 기능 등 (이메일 또는 SMS)

