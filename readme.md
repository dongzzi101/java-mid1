### [섹션 2. Object 클래스](#섹션-2-object-클래스)
### [섹션 3. 불변 객체](#섹션-3-불변-객체)
### [섹션 4. String 클래스](#섹션-4-string-클래스)

---
# **섹션 2. Object 클래스**

## **java.lang 패키지 소개**
자바가 기본 제공하는 라이브러리 중 가장 핵심적인 패키지.

### **대표적인 클래스**
- `Object`
- `String`
- `Integer`, `Long`, `Double` (Wrapper 클래스)
- `Class`
- `System`

> `java.lang` 패키지의 클래스들은 **import 없이 사용 가능**

---

## **Object 클래스**
- **자바에서 모든 클래스의 최상위 부모 클래스는 항상 `Object` 클래스**
- 클래스에 별도의 부모 클래스를 명시하지 않으면 **묵시적으로 `Object` 클래스를 상속**

### **묵시적(Implicit) vs 명시적(Explicit)**
| 개념 | 설명 |
|------|------|
| **묵시적(Implicit)** | 개발자가 직접 코드에 작성하지 않아도 컴파일러가 자동 처리 |
| **명시적(Explicit)** | 개발자가 코드에 직접 명시적으로 작성 |

---

## **자바에서 `Object` 클래스가 최상위 부모인 이유**

### **1. 공통 기능 제공**
모든 객체에서 필요한 공통 기능을 `Object` 클래스에서 미리 제공한다.
- **객체 정보 조회:** `toString()`
- **객체 비교:** `equals()`
- **클래스 정보 확인:** `getClass()`

> 매번 개발자가 직접 메서드를 정의하면 **중복 코드 증가 및 일관성 문제 발생**

### **2. 다형성의 기본 구현**
- 부모 타입은 자식 객체를 참조할 수 있음 (`Object`는 모든 클래스의 부모)

```java
Object obj = new String("Hello");
System.out.println(obj.toString()); // "Hello"
```

---

## **Object 다형성**
- `Object` 타입 변수는 **모든 객체를 다형적으로 참조 가능**
- 하지만, 원래 타입의 기능을 사용하려면 **다운캐스팅이 필요**

```java
Object obj = new Integer(10);  
Integer num = (Integer) obj; // 다운캐스팅
```

---

## **Object 배열**
- 다양한 타입의 객체를 하나의 배열로 관리할 수 있음

```java
Object[] objects = { "Hello", 10, 3.14 };
System.out.println(objects[0]); // "Hello"
System.out.println(objects[1]); // 10
System.out.println(objects[2]); // 3.14
```

---

## **toString() 메서드**
- **객체의 정보를 문자열로 반환** (디버깅과 로깅에 유용)

```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

### **toString() 오버라이딩**
- 기본 `toString()`은 객체의 메모리 주소를 반환 → **유용한 정보 제공을 위해 오버라이딩 필요**

```java
class Person {
    String name;
    
    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}

Person p = new Person("John");
System.out.println(p); // "Person{name='John'}"
```

---

## **Object와 OCP (개방-폐쇄 원칙)**
자바의 `Object` 클래스는 기본 제공 메서드들을 **개발자가 오버라이딩할 수 있도록 설계됨**

### **정적 의존관계 vs 동적 의존관계**
| 개념 | 설명 |
|------|------|
| **정적 의존관계** | 컴파일 시점에 결정 (클래스 간의 관계) |
| **동적 의존관계** | 실행(런타임) 시점에 결정 |

---

## **equals() - 동일성과 동등성**

### **1. 동일성 (Identity)**
- `==` 연산자를 사용하여 **두 객체의 참조(메모리 주소)가 같은지 확인**

```java
String a = new String("hello");
String b = new String("hello");
System.out.println(a == b); // false (다른 객체)
```

### **2. 동등성 (Equality)**
- `equals()` 메서드를 사용하여 **논리적으로 같은 객체인지 비교**

```java
System.out.println(a.equals(b)); // true (문자열 값이 같음)
```

> `equals()`를 오버라이딩하지 않으면 기본적으로 `==`와 동일한 비교 수행

### **Object의 `equals()` 기본 구현**

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

- 동등성 비교를 원하면 **반드시 `equals()` 메서드를 오버라이딩해야 함**

---

## **equals() 구현 규칙**
`equals()` 메서드를 올바르게 구현하려면 다음 규칙을 지켜야 한다.

1. **반사성(Reflexive)**: `x.equals(x) == true`
2. **대칭성(Symmetric)**: `x.equals(y) == y.equals(x)`
3. **추이성(Transitive)**: `x.equals(y) && y.equals(z) → x.equals(z)`
4. **일관성(Consistent)**: 비교 결과가 변하지 않아야 함
5. **null 비교**: `x.equals(null) == false`

### **equals()와 hashCode()는 함께 사용**
- `equals()`를 재정의하면 `hashCode()`도 같이 재정의해야 한다.

---

# **섹션 3. 불변 객체**

## **기본형과 참조형의 공유**

자바의 데이터 타입에는 **기본형(primitive type)**과 **참조형(reference type)**이 있음

- **기본형**: 하나의 값을 여러 변수에서 절대로 공유하지 않음
- **참조형**: 하나의 객체를 참조값을 통해 여러 변수에서 공유 가능

---

## **공유 참조와 사이드 이펙트**

**사이드 이펙트(Side Effect)**:  
프로그래밍에서 어떤 계산이 주된 작업 외에 **추가적인 부수 효과**를 일으키는 것.

> **여러 변수가 하나의 객체를 공유하는 것을 막을 방법은 없음.**

### **객체 공유 예제**
```java
Address a = new Address("서울");
Address b = a; // 같은 객체를 참조
```

### **객체 공유 방지 예제**
```java
Address a = new Address("서울");
Address b = new Address("서울"); // 새로운 객체 생성
```

하지만 **참조값의 공유 자체를 완전히 막을 방법은 없움**

---

## **불변 객체**

공유하면 안 되는 객체가 여러 변수에서 공유되면서 발생하는 문제  
하지만 **객체의 공유 자체를 막을 방법은 없음**

> 문제의 직접적인 원인은 **공유된 객체의 값이 변경되었기 때문.**

### **불변 객체(Immutable Object)란?**
객체의 **상태(내부 값, 필드, 멤버 변수)**가 변하지 않는 객체

### **정리**
- 불변 객체는 **객체 공유로 인한 사이드 이펙트를 방지**할 수 있음
- 불변이라는 제약 조건이 **의도치 않은 상태 변경을 막아 안전한 코드 작성**이 가능

---

# **섹션 4. String 클래스**

## **String 클래스 - 기본**

자바에서 **문자**를 다루는 대표적인 타입:
1. **char**
2. **String**

### **문자열 생성 방법**
```java
String str1 = "hello";              // 리터럴 방식
String str2 = new String("hello");  // new 키워드 사용
```

> **참고:** 자바 9 버전 이후 `char[]` 대신 `byte[]` 사용
> - `char`는 **2byte** 차지 → `byte[]` 사용으로 메모리 효율성 증가

### **String 주요 메서드**
- `length()`
- `charAt(int index)`
- `substring(int beginIndex, int endIndex)`
- `indexOf(String str)`
- `toLowerCase()`, `toUpperCase()`
- `trim()`
- `concat(String str)`

---

## **String 클래스 - 비교**

문자열 비교 시 `==` 비교가 아닌 **항상 `equals()` 비교**해야 함

### **문자열 리터럴 & 문자열 풀(String Pool)**
- 문자열 리터럴을 사용하면 **문자열 풀**을 통해 메모리 최적화
- 자바는 실행 시 **문자열 풀**에 `String` 인스턴스를 미리 생성
- **같은 문자열이 존재하면 새로운 객체를 만들지 않고 기존 인스턴스를 재사용**

> **따라서, 문자열 리터럴을 사용할 경우 `==` 비교 성공**

> **참고:**
> - 문자열 풀은 **힙(Heap) 영역** 사용
> - 문자열을 찾을 때 **해시(Hash) 알고리즘**을 사용해 빠르게 검색 가능

---

## **String 클래스 - 불변 객체(Immutable Object)**

### **String은 불변 객체**
- **한 번 생성된 `String` 객체는 내부 값 변경 불가**
- 새로운 문자열을 만들면 **새로운 객체가 생성됨**

### **불변 객체로 설계된 이유**
- **문자열 풀**에서 공유되는 `String` 인스턴스가 변경되면 **다른 변수에도 영향을 미침 → 사이드 이펙트 발생**

---

## **String 클래스 - 주요 메서드**

### **문자열 정보 조회**
- `length()`, `charAt(int index)`, `substring()`, `indexOf()`

### **문자열 비교**
- `equals()`, `compareTo()`

### **문자열 검색**
- `contains()`, `startsWith()`, `endsWith()`

### **문자열 분할 및 조합**
- `split()`, `join()`, `concat()`

> **참고:**
> - `CharSequence`는 `String`, `StringBuilder`의 상위 타입
> - **다양한 문자열 관련 객체를 처리할 수 있도록 설계됨**

---

## **StringBuilder - 가변 String**

### **불변인 `String`의 단점**
- 문자열을 더하거나 변경할 때 **새로운 객체를 계속 생성** → **비효율적**

### **해결 방법: `StringBuilder` 사용**
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");  // 기존 객체 내부에서 수정됨
```

### **가변 객체 vs 불변 객체**
| 구분 | 특징 |
|------|------|
| **String** | 불변(Immutable) |
| **StringBuilder** | 가변(Mutable) → **추가, 삭제, 수정 가능** → 성능 향상 (단, 사이드 이펙트 주의) |

---

## **String 최적화**

### **자바 컴파일러의 최적화**
- **문자열 리터럴 + 연산 시 컴파일러가 자동 최적화**
- **런타임에 별도의 문자열 결합 연산 수행 X → 성능 향상**

### **`StringBuilder`를 직접 사용하는 것이 좋은 경우**
- **반복문**에서 반복적으로 문자열을 연결할 때
- **조건문**을 통해 동적으로 문자열을 조합할 때
- **복잡한 문자열 일부를 변경해야 할 때**
- **대용량 문자열을 다룰 때**

> **참고:** `StringBuilder vs StringBuffer`
> - `StringBuffer`는 **동기화(synchronized)** 지원 → **멀티 스레드 환경에서 안전**
> - `StringBuilder`는 동기화 없음 → **싱글 스레드 환경에서 성능 우수**

---

## **메서드 체이닝 (Method Chaining)**

**메서드 체이닝 기법**을 사용하면 **가독성이 좋아지고 코드가 간결해짐**

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" World").append("!");
System.out.println(sb.toString());
```

> **참고:**
> - `StringBuilder.append()` 메서드는 자기 자신의 참조값을 반환
> - **연속적으로 메서드를 호출할 수 있도록 설계됨**

---

### 📌 **정리**
- `String`은 **불변(Immutable)** 객체 → 한 번 생성되면 변경 불가
- 문자열을 다룰 때 문자열 풀(String Pool)을 활용해 최적화
- 문자열 조작이 많을 경우 **`StringBuilder` 사용 권장**
- 메서드 체이닝을 활용하면 **가독성과 코드 효율성 향상**

---

