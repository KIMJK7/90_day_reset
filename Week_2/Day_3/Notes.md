# Java `static` Thinking Exercises

## 1. Why can't `main()` be an instance method?

Because when the JVM starts the program, **no object exists yet**.

If `main()` were an instance method:

``` java
public void main(String[] args)
```

the JVM would first need to create an object to call it.

But **`main()` itself is the program's entry point**, so there is no
object yet.

A `static` method belongs to the class, so the JVM can directly call:

``` java
Main.main(args);
```

without creating any object.

------------------------------------------------------------------------

## 2. Why are static variables shared?

Static variables belong to the **class**, not to individual objects.

``` java
class Student {
    static int count;
}
```

Whether you create 2 objects or 200 objects, there is still only **one**
`count` variable.

    Student Class
    -------------
    count

    Heap
    ----
    Student Object 1
    Student Object 2
    Student Object 3

All objects access the same variable, so changes made through one object
are visible to all.

------------------------------------------------------------------------

## 3. Why can instance methods access static variables?

An instance method is called on an object, so Java already knows which
class the object belongs to.

``` java
class Student {
    static int count;

    void display() {
        System.out.println(count);
    }
}
```

The instance method has a `this` reference to the object and can easily
access class-level (`static`) members.

------------------------------------------------------------------------

## 4. Why can't static methods directly access instance variables?

A static method belongs to the class, not to any object.

``` java
Student s1 = new Student();
s1.name = "Rahul";

Student s2 = new Student();
s2.name = "Priya";
```

Inside:

``` java
static void show() {
    System.out.println(name);
}
```

Java doesn't know whether `name` refers to **Rahul**, **Priya**, or some
other object.

To remove this ambiguity, you must pass an object:

``` java
static void show(Student s) {
    System.out.println(s.name);
}
```

------------------------------------------------------------------------

## 5. When should you use `static`?

Use `static` when the member belongs to the **class as a whole**, not to
an individual object.

Examples:

### Shared data

``` java
static int studentCount;
```

### Utility methods

``` java
Math.sqrt();
Integer.parseInt();
Arrays.sort();
```

### Entry point

``` java
public static void main(String[] args)
```

### Constants

``` java
static final double PI = 3.14159;
```

------------------------------------------------------------------------

# Interview Questions & Answers

## What is an instance variable?

An instance variable belongs to an **object**.

Each object gets its own copy.

``` java
class Student {
    String name;
}
```

    Object 1
    ---------
    name = Rahul

    Object 2
    ---------
    name = Priya

Changing one object's value does not affect another.

------------------------------------------------------------------------

## What is a static variable?

A static variable belongs to the **class**.

Only one copy exists regardless of how many objects are created.

``` java
class Student {
    static int count;
}
```

------------------------------------------------------------------------

## Where are static variables stored?

Static variables are stored in the **Method Area (Metaspace in modern
JVMs)** as part of the class's runtime data.

    Stack
    -----
    Local variables
    References

    Heap
    ----
    Objects

    Method Area / Metaspace
    -----------------------
    Class metadata
    Static variables
    Static methods

------------------------------------------------------------------------

## Why is `main()` static?

The JVM must start the program before creating any objects.

Since static methods belong to the class, the JVM can directly execute:

``` java
Main.main(args);
```

------------------------------------------------------------------------

## Why can't a static method directly access instance variables?

Instance variables exist inside objects.

A static method belongs to the class and has **no `this` reference**, so
it doesn't know which object's data to use.

Pass an object reference if instance data is needed.

------------------------------------------------------------------------

## Difference Between Instance and Static Methods

  -----------------------------------------------------------------------
  Instance Method                       Static Method
  ------------------------------------- ---------------------------------
  Belongs to an object                  Belongs to the class

  Requires an object to call            Can be called using the class

  Has a `this` reference                No `this` reference

  Can access instance and static        Can directly access only static
  members                               members

  Used for object-specific behavior     Used for class-level behavior or
                                        utilities
  -----------------------------------------------------------------------

------------------------------------------------------------------------

## When should you use `static`?

Use `static` when:

-   The data should be shared by all objects.
-   The method doesn't depend on object-specific data.
-   You need utility/helper methods.
-   You need constants (`static final`).
-   The JVM must call the method before any object exists (such as
    `main()`).

Avoid `static` when the data or behavior belongs to individual objects.

------------------------------------------------------------------------

# 30-Second Interview Summary

> **Instance members belong to objects, so every object gets its own
> copy. Static members belong to the class, so only one copy exists and
> is shared by all objects. The JVM loads the class before creating any
> objects, which is why static members are available without an
> instance. `main()` is static because it's the program's entry point,
> and the JVM needs to invoke it before any object exists. Static
> methods can't directly access instance variables because they don't
> have a `this` reference and therefore don't know which object's state
> to use. Use `static` for shared data, utility methods, constants, and
> behavior associated with the class rather than a particular object.**
