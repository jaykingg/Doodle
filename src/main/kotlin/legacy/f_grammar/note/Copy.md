## Function in Data class

### Copy

* in Data class
* 기존 객체를 기반으로 일부 속성만 변경한 **새로운 객체**를 만들 때 사용
* 불변 객체를 다룰 때 매우 유용
* 원본 객체는 변경되지 않고, 새로운 객체가 반환

~~~kotlin
data class Person(val name: String, val age: Int)

val original = Person("Alice", 30)
val modified = original.copy(age = 31)

println(original) // 출력: Person(name=Alice, age=30)
println(modified) // 출력: Person(name=Alice, age=31)
~~~

---

### Copy with let

* 특정 조건에 따라 처리를 진행

~~~kotlin
val person = Person("Bob", 25)

val updatedPerson = person.let {
    if (it.age < 30) it.copy(age = 30) else it
}

println(updatedPerson) // 출력: Person(name=Bob, age=30)
~~~

* Description
    * `Person` 의 나이가 30 미만이면 age 속성을 30으로 설정한 **새로운 객체를 반환**
    * 그렇지 않으면 기존 객체를 그대로 반환

---

### Copy with run

* 복사된 객체를 기반으로 추가적인 계산이나 작업을 수행한 후 그 결과를 반환

~~~kotlin
val book = Book("Kotlin Guide", 300)
val newBookPrice = book.copy().run {
    price * 0.9 // 책 가격의 10% 할인 계산
}

println(newBookPrice) // 출력: 270.0
~~~

* Description
    * `book` 객체를 `copy`하여 **새로운 객체를 생성**하고, `run`을 통해 새로운 객체에서 할인된 가격을 계산

---

### Copy with apply

* 복사한 객체에 추가 설정을 할 때 유용
* 새로 생성된 객체의 여러 속성을 한 번에 설정하고 싶을 때 `apply` 와 조합

~~~kotlin
data class Car(val model: String, var price: Int, var mileage: Int)

val car = Car("Sedan", 20000, 0)
val newCar = car.copy(price = 19000).apply {
    mileage = 100
}

println(newCar) // 출력: Car(model=Sedan, price=19000, mileage=100)
~~~

* Description
    * `price`가 19000으로 수정된 **새로운 객체를 생성**한 후, `apply`를 사용하여 `mileage`를 100으로 설정
    * `apply`를 통해 여러 속성을 설정하는 초기화가 가능

---

### Copy with also

* 복사된 객체에 대해 부수 작업(로깅, 디버깅)을 수행
* 원본 객체를 유지하면서 새로운 객체를 반환

~~~kotlin
val user = Person("Charlie", 29)

val updatedUser = user.copy(age = 30).also {
    println("Updated user: $it")
}

println(user)         // 출력: Person(name=Charlie, age=29)
println(updatedUser)   // 출력: Person(name=Charlie, age=30)
~~~

* Description
    * `copy`로 나이를 30으로 수정한 **새로운 객체를 생성**한 후, `also`로 **새로운 객체**를 로깅하고 결과를 반환
    * **원본 user 객체는 변경되지 않음**

---

