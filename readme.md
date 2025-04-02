### [섹션 2. Object 클래스](#섹션-2-object-클래스)

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
