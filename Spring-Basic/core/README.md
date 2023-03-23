# 비즈니스 요구사항과 설계

## 회원
- 회원을 가입하고 조회할 수 있다.
- 회원은 일반과 VIP 두 가지 등급이 있다.
- 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
                        
#### 회원 도메인 협력 관계
![image](https://user-images.githubusercontent.com/50781066/227105216-e7a5ad77-6ea0-4f58-96d7-dffd23ad2ebe.png)

#### 회원 클래스 다이어그램
![image](https://user-images.githubusercontent.com/50781066/227105417-a64de3f0-bf29-4d12-828b-e91fe5430cea.png)

#### 회원 객체 다이어그램
![image](https://user-images.githubusercontent.com/50781066/227105452-ce18a4e6-c968-4ca3-914e-8417ea0e8b6d.png)

## 주문과 할인 정책
- 회원은 상품을 주문할 수 있다.
- 회원 등급에 따라 할인 정책을 적용할 수 있다.
- 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. (나중에 변경 될 수
있다.)
- 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을
미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. (미확정)

#### 주문 도메인 협력, 역할, 책임
![image](https://user-images.githubusercontent.com/50781066/227105883-8e2c8e3d-2a12-48ce-a7d8-3776f6eb34ff.png)

#### 주문 클래스 다이어그램
![image](https://user-images.githubusercontent.com/50781066/227106063-a3c6c0ae-d383-40c3-84d5-213332c5db56.png)

#### 주문 객체 다이어그램
![image](https://user-images.githubusercontent.com/50781066/227120080-9d9750b1-bfd7-4ebf-b5d5-696be8c39970.png)