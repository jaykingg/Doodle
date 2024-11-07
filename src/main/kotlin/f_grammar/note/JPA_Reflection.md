### 오류

~~~
javax.persistence.PersistenceException: org.hibernate.InstantiationException: No default constructor for entity
~~~

### 원인

`UserToken` 클래스에 기본 생성자가 없기 때문에 발생한 오류.   
``JPA`` 는 엔티티 인스턴스를 새로 생성하거나 조회할 때 `리플렉션` 을 통해 기본 생성자를 호출하여 객체를 만듦.   
`UserToken`에 기본 생성자가 정의되어 있지 않으므로, `Hibernate`가 객체를 인스턴스화하는 데 실패하고 오류가 발생.

### 해결 방법

1. 기본 생성자 추가.

> UserToken 클래스에 매개변수 없는 기본 생성자를 추가.   
> `JPA` 표준에서는 기본 생성자가 public 또는 protected여야 하며, `Hibernate` 이 생성자를 통해 엔티티의 인스턴스를 생성합니다.

2. Lombok 사용

> @NoArgsConstructor(access = ...protected)

### 조회(findBy) 는 왜 문제가 발생하지 않았는가?

조회 시에 문제가 발생하지 않았던 이유는 `JPA`의 `findBy...` 메서드가 엔티티 인스턴스를 직접 생성하지 않기 때문.   
`findBy...` 메서드를 사용하여 엔티티를 조회할 때 `JPA`는 내부적으로 프록시 객체를 사용하며, 실제 데이터베이스에서 값을 로드하여 엔티티 인스턴스를 구성.

### 자세한 이유

* 프록시 사용:
  `JPA`의 `findBy...` 메서드를 호출하면 엔티티의 인스턴스를 바로 생성하는 대신 프록시 객체를 사용.  
  프록시 객체는 필요한 시점에만 엔티티의 실제 데이터에 접근.
  이때 기본 생성자가 없어도 프록시가 엔티티 데이터를 가상으로 로드할 수 있기 때문에, `findBy...`로 조회하는 경우에는 오류가 발생하지 않음.
* 프록시 초기화 시점:   
  프록시는 데이터베이스에서 실제 데이터를 필요로 하는 시점에 객체를 초기화하여 엔티티의 필드를 채움.   
  이 과정에서 `JPA`는 프록시가 생성된 후 기본 생성자 호출 없이도 데이터베이스의 데이터를 프록시를 통해 가져와 `findBy...`와 같은 조회를 문제없이 처리.

* 그러나 `save` 시 문제가 발생하는 이유
  엔티티의 `save`는 새로운 객체를 인스턴스화하고 이를 데이터베이스에 직접 삽입해야함.   
  이때 `Hibernate` 리플렉션을 통해 엔티티 인스턴스를 새로 만들기 때문에 매개변수 없는 기본 생성자가 필요, 기본 생성자가 없으면 `save` 시 오류가 발생.
  됩니다.

### 요약

* 조회 시 (findBy...): 프록시를 사용하여 기본 생성자 없이도 데이터를 로드할 수 있으므로 문제가 발생하지 않는다.
* 저장 시 (save): 엔티티의 인스턴스를 직접 생성하여 저장하기 때문에 기본 생성자가 필요하고, 기본 생성자가 없으면 오류가 발생한다.

## Reflection?

* `JPA`와 같은 ORM 프레임워크가 엔티티 객체를 생성하거나, 필드 값을 설정할 때 사용하는 기능을 의미.
* 리플렉션을 사용하면 클래스의 정보를 런타임에 읽어올 수 있을 뿐 아니라, 개발자가 직접 작성하지 않은 코드로도 객체를 조작할 수 있게 됨.

### 사례

* `Hibernate` `JPA` 구현체로, 데이터베이스와 객체 간의 매핑을 처리할 때 리플렉션을 사용함.

* 엔티티 객체 생성:   
  `Hibernate` 데이터베이스에서 조회된 값을 Java 엔티티 객체로 매핑해야 합니다.   
  이때 엔티티의 기본 생성자가 호출됩니다. 엔티티 클래스에 기본 생성자가 없으면 `Hibernate`가 객체를 생성하지 못하고, 이로 인해 오류가 발생합니다.
* 필드 접근:   
  `JPA`는 데이터베이스에서 가져온 값을 필드에 설정하거나 값을 읽어와야 하는데, 리플렉션을 통해 필드에 직접 접근할 수 있습니다.
  `@Id`로 설정된 필드나 `@Column`으로 매핑된 필드에 값이 주입되며, 이 과정에서도 리플렉션을 사용해 각 필드에 접근합니다.
* 동적 프록시 생성:   
  리플렉션을 통해 인터페이스의 프록시 객체를 생성해, 필요한 시점에만 데이터베이스 접근을 트리거할 수 있게 합니다.

### 왜 기본 생성자가 필요한가?

* 리플렉션을 통해 객체를 생성할 때 `JPA`/`Hibernate` 기본 생성자가 필요합니다.
  엔티티 클래스에 기본 생성자가 없으면 `Hibernate` 객체를 생성하지 못합니다.     
  이는 아래와 같은 이유에서 발생합니다:

1. 리플렉션이 기본 생성자를 사용하여 인스턴스를 생성합니다. 매개변수가 있는 생성자를 자동으로 호출하기 어렵기 때문에, 리플렉션을 사용할 때는 기본 생성자가 필요합니다.
2. `JPA`는 프레임워크 특성상 객체의 생성과 필드 접근을 자유롭게 해야 하므로, 엔티티 클래스는 접근 가능한 기본 생성자가 있어야 합니다. 이를 통해 데이터베이스에서 읽어온
   데이터를
   객체에 바로 적용할 수 있습니다.

### 요약

* `Hibernate`와 같은 프레임워크에서 리플렉션은 데이터베이스 조회 시 객체 생성과 필드 접근을 수행하는 데 핵심적인 역할을 합니다.
* 이때 리플렉션이 기본 생성자를 필요로 하므로, 엔티티 클래스는 매개변수 없는 생성자가 있어야 하며, 이는 저장 및 조회 시 문제없이 객체를 생성하고 매핑할 수 있게 합니다.
