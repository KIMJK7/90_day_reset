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
