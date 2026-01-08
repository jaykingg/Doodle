## Scope Function

* `Object` 의 `Context` 서 실행되는 `block` 을 구성하는 함수

---

### Kind of functions

* let
* run
* with
* apply
* also

---

### let

* null 체크 / **일회성 작업**
* `it` 키워드로 컨텍스트 객체에 **참조** 접근
* `Lambda block` 의 결과를 반환

~~~kotlin
val name: String? = "Kotlin"
val length = name?.let {
    println("이름의 길이는 ${it.length}입니다.")
    it.length
}
~~~

* **null 이 아닌 경우에만 특정 작업을 실행**하고 싶을 때
* 반환 값을 통해 **추가적인 연산**을 수행할 때

---

### run

* **객체 초기화**나 일련의 동작을 그룹화할 때 사용
* 객체 대신 **블록의 결과를 반환**하며, this 키워드로 `Context` 객체에 접근

~~~kotlin
val person = Person("Alice", 20)
val result = person.run {
    println("이름: $name, 나이: $age")
    age + 5
}
println(result) // 출력: 25
~~~

* 객체의 여러 속성을 사용해 계산을 수행할 때
* 블록 내에서 객체에 대한 작업을 수행하고, **그 결과를 반환**하고 싶을 때

---

### with

* 객체를 **매개변수로 전달받아** 여러 작업을 수행하는 데 유용
* 주로 **객체 자체가 아닌 다른 값을 반환**하고자 할 때 사용

~~~kotlin
val person = Person("Bob", 25)
val introduction = with(person) {
    "이름: $name, 나이: $age"
}
println(introduction) // 출력: 이름: Bob, 나이: 25
~~~

* 동일한 객체에서 여러 속성이나 메서드를 사용해야 할 때
* 계산을 수행한 **결과 값을 반환**하고 싶을 때

---

### apply

* **객체 구성 또는 설정**에 유용
* 항상 `Context` 객체를 반환하며, `this` Keyword 를 통해 객체에 접근

~~~kotlin
val person = Person("Charlie", 30).apply {
    name = "Charlie Brown"
    age = 35
}
println(person) // 출력: Person(name=Charlie Brown, age=35)
~~~

* **객체를 초기화하거나 여러 속성을 설정**할 때
* 객체 자체를 반환하면서 여러 설정을 할 때

---

### also

* 객체를 **수정하지 않고**, 객체와 관련된 **추가 작업을 수행**하고 싶을 때 사용
* `Context` 객체를 `it`으로 **참조**하고, **객체 자체를 반환**

~~~kotlin
val numbers = mutableListOf("One", "Two", "Three")
numbers.also {
    println("원본 리스트: $it")
}.add("Four")
println(numbers) // 출력: [One, Two, Three, Four]
~~~

* 객체에 대한 **부수 작업을 수행**할 때 (예: 디버깅, 로깅)
* 객체를 반환하면서 중간에 작업을 수행할 때
