## Companion object

* `Kotlin` 에서 특정 클래스와 결합된 싱글톤 객체로, 자바의 `static` 과 비슷한 역할
* 이를 통해 클래스의 모든 인스턴스가 공유하는 정적 멤버(함수나 변수를 정의할 수 있는 객체)를 만듦

### Characteristics(특징)

* 정적(static) 멤버와 유사한 역할:
    * 자바에서는 `static` 키워드를 사용하여 클래스의 정적 멤버를 선언하지만, `Kotlin` 에는 `static`이 없음
    * `companion object`를 통해 클래스와 연결된 정적 멤버처럼 사용되는 객체를 선언
    * `companion object`는 클래스의 인스턴스를 생성하지 않아도 사용할 수 있으므로, 정적 메서드나 변수를 정의하고자 할 때 적합
* 싱글톤(Singleton) 패턴:
    * `companion object` 는 클래스당 하나만 존재하며, 프로그램 실행 동안 하나의 인스턴스만 생성
    * 메모리 효율적이며, 전체 애플리케이션에서 공통으로 사용할 상태나 메서드를 관리하기 좋음
* 메모리 효율성:
    * `companion object` 는 일반적인 인스턴스 객체가 아니기 때문에 클래스당 **하나**만 메모리에 올라감
    * 여러 개의 인스턴스를 생성할 필요 없이 클래스당 하나의 인스턴스만 메모리에 올라감
* 다른 객체의 companion 역할을 수행:
    * `companion object` 내부에 함수를 정의하고 이를 통해 다양한 유틸리티 메서드나 팩토리 메서드를 제공 가능
    * 예를 들어 `companion object` 에서 `createInstance()`라는 팩토리 메서드를 정의하면, 객체 생성 시 편리하게 사용

### Example

~~~kotlin
class MyClass(val name: String) {
    companion object {
        const val DEFAULT_NAME = "Default Name"

        fun createWithDefault(): MyClass {
            return MyClass(DEFAULT_NAME)
        }
    }
}

// 사용
val instance = MyClass.createWithDefault()
println(instance.name) // 출력: Default Name
~~~


