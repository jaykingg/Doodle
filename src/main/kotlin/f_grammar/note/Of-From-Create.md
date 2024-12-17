### `of` 메서드

## **의미**

- 기존의 **단순한 값을 기반**으로 새로운 객체를 생성할 때 사용합니다.

---

## **특징**

1. 입력값이 명확하고 간단한 경우에 사용됩니다.
2. 주로 **값 객체(Value Object)**나 **불변 객체** 생성에 유용합니다.
3. 불필요한 복잡성을 제거하고 객체의 생성 과정을 단순화합니다.

---

## **사용 사례**

### **값 객체 생성**

```kotlin
data class AccountId(val value: Long) {
    companion object {
        fun of(value: Long): AccountId {
            require(value > 0) { "AccountId must be greater than 0." }
            return AccountId(value)
        }
    }
}
```

---

### `from` 메서드

### **의미**

- 다른 객체나 데이터를 **변환**하거나 **매핑**해서 새로운 객체를 생성할 때 사용합니다.

---

### **특징**

1. **입력값이 복합적이거나 다른 타입**의 객체인 경우 사용됩니다.
2. DTO → Domain 객체와 같은 변환 로직에서 유용합니다.
3. 복잡한 데이터 매핑을 명확하게 표현합니다.

---

### **사용 사례**

### **DTO → Domain 객체 변환**

```kotlin
data class User(val id: Long, val name: String) {
    companion object {
        fun from(dto: UserDto): User {
            require(dto.id > 0) { "ID must be greater than 0." }
            return User(id = dto.id, name = dto.fullName)
        }
    }
}

data class UserDto(val id: Long, val fullName: String)
```

---

### `create` 메서드

### **의미**

- 객체를 **새로 생성**할 때 사용되며, 생성 과정에 **비즈니스 로직**이나 **검증**이 포함됩니다.

---

### **특징**

1. 객체 초기화 시 **비즈니스 검증**과 **일관된 상태**를 보장합니다.
2. 복잡한 생성 로직이나 초기 설정이 필요한 경우 사용됩니다.
3. 객체의 상태를 보호하고 명확한 생성을 강제합니다.

---

### **사용 사례**

### **비즈니스 검증이 필요한 객체 생성**

```kotlin
class CorpAccount private constructor(
    val accountName: String,
    val createdBy: Long
) {
    companion object {
        fun create(accountName: String, createdBy: Long): CorpAccount {
            require(accountName.isNotBlank()) { "Account name must not be blank." }
            require(createdBy > 0) { "CreatedBy must be a positive value." }
            return CorpAccount(accountName, createdBy)
        }
    }
}
```
