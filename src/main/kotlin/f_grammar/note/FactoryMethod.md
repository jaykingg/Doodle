## Factory method

* 객체 생성 방식을 캡슐화
* 객체 생성 로직을 쉽게 관리하고 코드의 유연성을 높여주는 디자인 패턴

### 핵심 개념

* 객체 생성 캡슐화: 팩토리 메서드는 객체 생성 로직을 메서드로 감싸서 캡슐화
* 코드 가독성 및 유지보수성 증가: 다양한 생성자 매개변수 조합이 있는 경우,    
  팩토리 메서드를 사용하여 의미 있는 이름을 부여

### 장점

* 객체 생성의 유연성:
    * 팩토리 메서드는 객체 생성 방식을 동적으로 결정할 수 있어, 다양한 객체를 생성하는 상황에서 유리
* 코드 가독성:
    * 메서드 이름을 통해 생성자의 목적을 설명할 수 있어, 생성자를 직접 호출할 때보다 의도를 더 명확하게 전달
* 캡슐화:
    * 객체 생성의 내부 로직을 감출 수 있어, 내부 구현이 변경되어도 외부 코드에 영향을 주지 않음
* 상속 및 서브타입 활용:
    * 팩토리 메서드는 서브타입 객체를 생성하기에 적합하여 다형성을 활용하는 데 유리

### 사용

* 복잡한 객체 생성 로직이 있을 때
    * 객체를 생성할 때 초기화 로직이 복잡한 경우, 생성자에 직접 넣기보다 팩토리 메서드를 통해 정의하면 로직을 깔끔하게 분리

~~~kotlin
data class Product(val id: Long, val name: String, val price: Double)

class ProductFactory {
    companion object {
        fun createDiscountedProduct(id: Long, name: String, price: Double): Product {
            val discountedPrice = price * 0.9 // 10% 할인 적용
            return Product(id, name, discountedPrice)
        }
    }
}

val product = ProductFactory.createDiscountedProduct(1L, "Laptop", 1500.0)
~~~

* 여러 종류의 객체를 생성할 때
    * 팩토리 메서드를 통해 부모 클래스의 서브타입을 동적으로 생성가능(다형성 보장)

~~~kotlin
data class User(val id: Long, val name: String, val isAdmin: Boolean)

class UserFactory {
    companion object {
        fun createAdminUser(id: Long, name: String): User {
            return User(id, name, true)
        }

        fun createNormalUser(id: Long, name: String): User {
            return User(id, name, false)
        }
    }
}

val adminUser = UserFactory.createAdminUser(1L, "Alice")
val normalUser = UserFactory.createNormalUser(2L, "Bob")
~~~

* 특정 조건에 따라 객체를 다르게 초기화해야 할 때
    * 특정 조건이나 상태에 따라 객체 생성이 달라져야 할 때 팩토리 메서드를 사용

~~~kotlin
특정 조건에 따라 객체를 다르게 초기화해야 할 때
•    특정 조건이나 상태에 따라 객체 생성이 달라져야 할 때 팩토리 메서드를 사용할
~~~
