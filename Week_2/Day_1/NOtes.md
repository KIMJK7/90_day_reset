# Java Memory & Object Concepts

## 1. Why doesn't Java store objects on the stack?

The stack has limited memory and follows a **Last-In-First-Out (LIFO)** structure, meaning everything stored there is automatically removed when a method returns. Many objects need to live longer than the method that created them or be accessed from different methods, objects, or classes. Therefore, Java stores objects in the **heap**, which provides dynamically managed memory and allows objects to remain alive until they are no longer referenced.

---

## 2. Why are references stored on the stack?

Reference variables are **local variables**, and local variables are stored on the stack. The stack provides very fast memory allocation and automatic cleanup when a method finishes. A reference acts as a link to an object stored in the heap, while the object's lifetime is managed independently by the Garbage Collector.

---

## 3. How many objects are created by the following code?

```java
Student a = new Student();

Student b = a;
```

**Answer:**

Only **one object** is created.

- `new Student()` creates a single `Student` object on the heap.
- `a` is a reference variable that points to that object.
- `b = a` copies the reference, **not** the object.

As a result, both `a` and `b` refer to the **same object**.

---

## 4. What is the difference between an object and a reference?

### Object

An **object** is an instance of a class stored in the **heap**. It contains its own **state (instance variables/fields)** and represents the actual data of the program.

### Reference

A **reference** is a variable that stores a reference to an object. It is used to access the object's fields and invoke its methods, but it is **not the object itself**.

**Simple analogy:** A reference is like a **remote control**, and the object is the **TV**. The remote lets you control the TV, but it is not the TV itself.

---

## 5. Why can multiple references point to the same object?

A reference variable stores only a **reference to an object**, not the object itself. Since references are independent variables, multiple references can store the same object reference.

Example:

```java
Student a = new Student();
Student b = a;
```

Both `a` and `b` point to the same object in the heap. Therefore, any changes made through one reference are visible through the other because they access the same object.

# Java Classes, Objects & References

## 1. What is a class?

A **class** is a blueprint or template for creating objects. It defines the **fields (instance variables)** that an object will have and the **methods** (behaviors/actions) that can be performed on those fields. A class itself does not occupy memory for its objects until an object is created.

---

## 2. What is an object?

An **object** is an instance of a class that is created in the **heap memory**. It contains its own **state (instance variables/fields)** and represents the actual data of the program. Objects use the methods defined in their class to perform operations on their data.

> **Note:** Methods are defined in the class and shared by all objects of that class. Each object has its own copy of the instance variables, but not its own copy of the methods.

---

## 3. What is a reference?

A **reference** is a variable that stores a **reference to an object** in the heap. Reference variables are typically stored in the **stack** (when they are local variables) and are used to access an object's fields and invoke its methods.

> Java uses references rather than exposing actual memory addresses to the programmer.

---

## 4. Explain `Student s = new Student();` step by step.

```java
Student s = new Student();
```

### Step 1: Declaration

```java
Student s;
```

- A reference variable `s` is declared.
- Since it is a local variable, it is stored in the **stack**.
- At this point, no object has been created yet.
- The reference is uninitialized until a value is assigned to it.

### Step 2: Object Creation

```java
new Student();
```

- A new `Student` object is created in the **heap**.
- The JVM allocates enough memory for all the object's instance variables.
- Each instance variable is initialized with its default value.
  - `int` → `0`
  - `double` → `0.0`
  - `boolean` → `false`
  - Object references (e.g., `String`) → `null`

### Step 3: Assignment

```java
s = new Student();
```

- The reference to the newly created object is assigned to `s`.
- Now `s` can be used to access the object's fields and invoke its methods.

---

## 5. When does an object become eligible for Garbage Collection?

An object becomes **eligible for Garbage Collection (GC)** when it is **no longer reachable** by any live reference in the program.

In other words, if no reference variable points to an object and there is no way for the program to access it, the object becomes **eligible** for garbage collection.

Example:

```java
Student s = new Student();

s = null;
```

After assigning `null` to `s`, if no other reference points to that object, it becomes eligible for Garbage Collection.

> **Important:** Being eligible for Garbage Collection does **not** mean the object is immediately removed from memory. The Garbage Collector decides when to reclaim its memory.

# Question of the day

## "What actually happens inside the JVM when we write new Student()?"

Student s = new Student();

        │
        ▼

1. JVM checks whether Student.class is loaded.
   │
   ▼

2. If necessary, Class Loader loads the class.
   │
   ▼

3. Heap memory is allocated for the object.
   │
   ▼

4. Instance variables receive default values.
   │
   ▼

5. Constructor executes.
   │
   ▼

6. new Student() returns a reference.
   │
   ▼

7. Reference assigned to s.
