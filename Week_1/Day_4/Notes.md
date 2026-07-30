# Java Methods -- Complete Notes

## What is a Method?

A **method** is a reusable block of code that performs a specific task.

Instead of writing all the code inside `main()`, we divide a program
into smaller methods, where each method is responsible for one job.

Methods contain instructions, calculations, decision-making, loops, and
variable manipulations. They are written once and can be called multiple
times, making programs easier to understand and maintain.

```java
public static int add(int a, int b) {
    return a + b;
}
```

---

# Why do Methods Exist?

Methods make programs:

- More readable
- Modular (divide large problems into smaller parts)
- Easier to debug
- Easier to test
- Easier to update
- Reusable (avoid writing the same code repeatedly)

Without methods, every program would become one huge block of code
inside `main()`.

---

# Explain Every Part of a Method Declaration

```java
public static int add(int a, int b){
    int sum = a + b;
    return sum;
}
```

### 1. Access Modifier (`public`)

Determines who can access the method.

Common access modifiers: - `public` - `private` - `protected` - Default
(package-private)

### 2. Static Keyword (`static`)

The method belongs to the class instead of an object.

Example:

```java
Math.max(5, 8);
```

### 3. Return Type (`int`)

Specifies what value the method returns.

Examples: - `int` - `double` - `char` - `boolean` - `String` - `void`

### 4. Method Name (`add`)

The name used to call the method.

Examples: - `calculateSalary()` - `depositMoney()` - `withdrawMoney()`

### 5. Parameters (`int a, int b`)

Variables that receive values when the method is called.

### 6. Method Body

```java
{
    int sum = a + b;
    return sum;
}
```

Contains the instructions executed by the method.

### 7. Return Statement

```java
return sum;
```

Ends the method and sends a value back to the caller.

---

# Difference Between Parameters and Arguments

### Parameters

Variables declared in the method definition.

```java
public static int add(int a, int b)
```

`a` and `b` are parameters.

### Arguments

Actual values passed during the method call.

```java
add(10, 20);
```

`10` and `20` are arguments.

**Easy Remember:** - Method Definition → Parameters - Method Call →
Arguments

---

# Difference Between `void` and a Return Value

### `void`

Returns nothing.

```java
public static void greet() {
    System.out.println("Hello");
}
```

Used when the method only performs an action.

### Return Value

Returns data back to the caller.

```java
public static int square(int x) {
    return x * x;
}
```

```java
int answer = square(5);
```

---

# How Does the JVM Execute a Method Call?

```java
public static int add(int a, int b){
    return a + b;
}

public static void main(String[] args){
    int result = add(5, 10);
}
```

Execution steps:

1.  JVM starts executing `main()`.
2.  Encounters `add(5, 10)`.
3.  Creates a new **stack frame** on the call stack.
4.  Assigns:
    - `a = 5`
    - `b = 10`
5.  Executes the method.
6.  Returns `15`.
7.  Removes the stack frame.
8.  Continues execution in `main()`.

---

# What is Method Overloading?

Method overloading means having multiple methods with the same name but
different parameter lists.

```java
public static int add(int a, int b){
    return a + b;
}

public static double add(double a, double b){
    return a + b;
}

public static int add(int a, int b, int c){
    return a + b + c;
}
```

Java chooses the correct method based on: - Number of parameters - Data
types - Order of parameter types

---

# Why are Methods Better Than Writing Everything Inside `main()`?

Methods:

- Reduce duplicate code
- Improve readability
- Make debugging easier
- Make testing easier
- Encourage code reuse
- Break large problems into smaller tasks

Instead of:

```text
main()
400 lines
```

You get:

```text
main()
 ├── login()
 ├── calculateSalary()
 ├── generateReport()
 └── logout()
```

---

# What Happens After a Method Finishes Executing?

After reaching `return` (or the closing `}` for `void` methods):

1.  Execution stops.
2.  Local variables are destroyed.
3.  The stack frame is removed.
4.  Control returns to the calling method.
5.  Returned value (if any) is passed back.

---

# Why Can't One Method Access Another Method's Local Variables?

Local variables exist only inside the method where they are declared.

```java
public static void first() {
    int x = 10;
}

public static void second() {
    System.out.println(x); // Error
}
```

When `first()` finishes, `x` is removed from memory.

To share data: - Pass it as a parameter. - Return it from a method. -
Use a field (instance/static variable) if appropriate.

---

# When Should a Method Return a Value Instead of Printing It?

Return a value when it will be used later in the program.

```java
public static int area(int length, int width){
    return length * width;
}
```

```java
int roomArea = area(5, 4);
int totalArea = roomArea + area(3, 2);
```

Printing is only appropriate when the goal is to display information.

```java
System.out.println(length * width);
```

**Rule of Thumb**

- **Return** → when another part of the program needs the result.
- **Print** → when the user only needs to see the output.

---

# Important Correction

This is **incorrect**:

```java
public static void add(int a, int b){
    return a + b;
}
```

A `void` method **cannot return a value**.

Correct versions:

```java
public static int add(int a, int b){
    return a + b;
}
```

or

```java
public static void add(int a, int b){
    System.out.println(a + b);
}
```
