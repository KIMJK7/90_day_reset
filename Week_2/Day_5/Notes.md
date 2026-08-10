# `this` — Answers to Notes

### 1. Why does an instance method need to know which object called it?

Because an instance method works with **object-specific state**.

The method definition is shared, but fields like `name` belong to individual objects.

```java
s1.display();
s2.display();
```

Both call the same `display()` method, but:

```text
s1.display() → this = s1 → this.name = "Aman"

s2.display() → this = s2 → this.name = "Jasleen"
```

So the method needs the current object to know **whose fields it should access or modify**.

---

### 2. Why does `this.name` work but `name = name` fail to update the field?

Suppose:

```java
Student(String name) {
    this.name = name;
}
```

There are two different `name`s:

```text
this.name  → instance field of the object
name       → constructor parameter
```

So:

```java
this.name = name;
```

means:

> Put the parameter's value into the object's `name` field.

But:

```java
name = name;
```

has no `this`, so both `name`s refer to the **parameter**.

Conceptually:

```text
parameter = parameter
```

The object's field is never modified.

---

### 3. If two references point to the same object, how many `this` references exist?

There is **one object**, but `this` is determined whenever an instance method is executing.

For example:

```java
Student a = new Student();
Student b = a;
```

Now:

```text
a ──────┐
        ↓
      Object
        ↑
b ──────┘
```

If you do:

```java
a.display();
```

then inside `display()`:

```text
this → that object
```

If you do:

```java
b.display();
```

then:

```text
this → the SAME object
```

So don't think of `this` as a permanent variable stored inside the object.

> **`this` is the reference to the current object during an instance-method execution.**

---

### 4. Why does `a == b` return `false` for two separately created objects containing identical data?

Because `==` compares **references**, not the contents of objects.

For example:

```java
Student a = new Student("Aman");
Student b = new Student("Aman");
```

There are two different objects:

```text
a ─────→ Object 1
         name = "Aman"

b ─────→ Object 2
         name = "Aman"
```

Even though their data is identical:

```text
Object 1 ≠ Object 2
```

Therefore:

```java
a == b   // false
```

`==` asks:

> **Are these two references referring to the exact same object?**

It does **not** ask:

> Do these two objects contain the same data?

If you want to compare object contents, you generally use `.equals()` after implementing/using it appropriately.

---

### 5. What is the difference between:

```java
Student b = a;
```

and:

```java
Student b = new Student();
```

This is extremely important.

#### `Student b = a;`

No new object is created.

```text
a ─────┐
       ↓
     Object
       ↑
b ─────┘
```

Both `a` and `b` refer to the **same object**.

Therefore:

```java
b.name = "Rahul";
```

also changes what you see through `a`:

```java
System.out.println(a.name);
```

because `a` and `b` point to the same object.

---

#### `Student b = new Student();`

A **new object is created**.

```text
a ─────→ Object 1

b ─────→ Object 2
```

They are separate objects with separate instance fields.

So changing `b` does not change `a`.

### The core difference

```text
Student b = a;
        ↓
same object

Student b = new Student();
        ↓
new/different object
```

---

### 6. Why must `this()` be the first statement in a constructor?

Because `this(...)` means:

> **Delegate construction to another constructor of the same class.**

Java requires that constructor delegation happen **before the current constructor executes its other statements**.

For example:

```java
Student() {
    this("Unknown", 0);    // must come first
    System.out.println("Done");
}
```

The flow is:

```text
Student()
   ↓
this("Unknown", 0)
   ↓
Student(String, int)
   ↓
initialize object
   ↓
return to Student()
   ↓
System.out.println("Done")
```

If you put something before `this()`:

```java
Student() {
    System.out.println("Hello");
    this("Unknown", 0);    // ❌
}
```

Java rejects it because the constructor delegation has to happen **first**.

### Remember this distinction

```text
this.name
    ↓
current object's field

this.display()
    ↓
current object's method

this(...)
    ↓
another constructor in the same class
```

The common idea behind all three is **the current object**, but `this(...)` is specifically used for **constructor chaining**.

## What exactly is `this`?

> `this` is a **reference to the current object**.

When an instance method is executing, `this` refers to the particular object on which the method was invoked.

For example:

```java
s1.display();
```

Conceptually:

```text
this → s1
```

---

## Why does every instance method operate on a particular object?

Because an instance method works with **object-specific state**.

The method definition is shared, but instance fields belong to individual objects.

For example:

```java
Student s1 = new Student("Aman");
Student s2 = new Student("Jasleen");

s1.display();
s2.display();
```

The same `display()` method is used in both cases, but:

```text
s1.display() → this = s1 → this.name = "Aman"

s2.display() → this = s2 → this.name = "Jasleen"
```

So the method needs a current object so it knows **whose state it should access or modify**.

---

## How does `this.name = name` work?

Suppose:

```java
Student(String name) {
    this.name = name;
}
```

There are two different `name`s:

```text
this.name → instance field belonging to the current object

name      → constructor parameter
```

`this` refers to the current object.

Therefore:

```java
this.name
```

means:

> The `name` field belonging to the current object.

So:

```java
this.name = name;
```

means:

> **Set the current object's `name` field to the value stored in the parameter `name`.**

For example:

```java
Student s1 = new Student("Jasleen");
```

Conceptually:

```text
this → s1

this.name = "Jasleen"
```

---

## What does `this()` mean?

```java
this(...)
```

means:

> **Call another constructor of the same class.**

For example:

```java
Student() {
    this("Unknown", 0);
}
```

calls:

```java
Student(String name, int age)
```

This is called **constructor chaining**.

It is useful because it allows constructors to reuse initialization logic instead of duplicating it.

---

## Why must `this()` be first in a constructor?

Java requires constructor delegation to happen **before the current constructor executes its other statements**.

Therefore:

```java
Student() {
    this("Unknown", 0);   // ✅ first statement
    System.out.println("Created");
}
```

is valid.

But:

```java
Student() {
    System.out.println("Created");
    this("Unknown", 0);   // ❌
}
```

is invalid.

The idea is:

```text
Current constructor
       ↓
Call another constructor first
       ↓
Initialization happens
       ↓
Continue with current constructor
```

---

# What is object identity?

Your definition needs correction.

You wrote:

> "the current state that the object is in with its fields and methods"

That's **not object identity**.

### Object identity means:

> **The fact that an object is a particular, distinct object in memory.**

For example:

```java
Student a = new Student("Jasleen");
Student b = new Student("Jasleen");
```

Even though they contain identical data:

```text
a → Object 1
     name = "Jasleen"

b → Object 2
     name = "Jasleen"
```

They are still **two different objects**.

Their identity is different.

Think:

```text
Object 1 ≠ Object 2
```

even though:

```text
Object 1.name == Object 2.name
```

in terms of value.

**State** = the data currently stored in the object.

**Identity** = which particular object it is.

---

# Difference between `==` and `.equals()`

Your idea is mostly right, but don't say `==` compares "the memory address" as the Java language definition.

For object references:

```java
a == b
```

checks whether `a` and `b` refer to the **same object**.

Example:

```java
Student a = new Student("Jasleen");
Student b = new Student("Jasleen");
```

Then:

```java
a == b
```

is:

```text
false
```

because they are two separate objects.

But:

```java
Student a = new Student("Jasleen");
Student b = a;
```

then:

```java
a == b
```

is:

```text
true
```

because both references point to the same object.

### `.equals()`

`.equals()` is used to compare objects according to their **logical equality**, but its exact behavior depends on how the class implements/overrides it.

For example, `String` overrides `.equals()` to compare its contents:

```java
String a = new String("Jasleen");
String b = new String("Jasleen");

System.out.println(a == b);       // false
System.out.println(a.equals(b));  // true
```

So don't memorize:

> `.equals()` always compares data.

Instead memorize:

> **`==` checks reference identity for objects. `.equals()` checks logical equality according to the class's implementation.**

---

# What is aliasing?

Your explanation here is correct.

Consider:

```java
Student a = new Student("Jasleen");
Student b = a;
```

There is:

```text
1 object
2 references
```

Conceptually:

```text
a ─────┐
       ↓
    Student
    name = "Jasleen"
       ↑
b ─────┘
```

Now:

```java
b.setName("Aman");
```

changes the **same object**.

Therefore:

```java
System.out.println(a.getName());
```

prints:

```text
Aman
```

because `a` and `b` refer to the same object.

This situation is called **aliasing**.

> **Aliasing occurs when multiple references refer to the same object.**

---

# What happens when two references point to the same object?

When two references point to the same object, either reference can be used to access or modify that same object's state.

For example:

```java
Student a = new Student("Jasleen");
Student b = a;

b.setName("Aman");
```

Both references still point to the same object:

```text
a ─────┐
       ↓
    Student
    name = "Aman"
       ↑
b ─────┘
```

Therefore:

```java
System.out.println(a.getName());
```

prints:

```text
Aman
```

The important point is:

> **There aren't two objects being synchronized. There is only one object.**

You're simply accessing the **same object through two different references**.

---

# Why can one method definition operate on thousands of different objects?

Because an **instance method is shared**, while the object it operates on can be different.

For example:

```java
class Student {

    String name;

    void display() {
        System.out.println(this.name);
    }
}
```

You could create:

```java
Student s1 = new Student("Aman");
Student s2 = new Student("Jasleen");
Student s3 = new Student("Rahul");
// ...
Student s1000 = new Student("Someone");
```

There is still only **one `display()` method definition**.

When you call:

```java
s1.display();
```

conceptually:

```text
this → s1
this.name → "Aman"
```

When you call:

```java
s2.display();
```

conceptually:

```text
this → s2
this.name → "Jasleen"
```

When you call:

```java
s1000.display();
```

conceptually:

```text
this → s1000
this.name → whatever s1000's name is
```

So the fundamental idea is:

```text
             ONE METHOD DEFINITION
                     │
        ┌────────────┼────────────┐
        ↓            ↓            ↓
       s1           s2           s3
        │            │            │
      this          this         this
        │            │            │
      state         state        state
```

The **logic is shared**.

The **object state is different**.

That's why one instance method can operate on thousands—or millions—of objects without having to write the method again for each object.
