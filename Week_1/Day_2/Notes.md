# Day 2

# Module 1: Variables & Data Types

---

# What is a Variable?

A **variable** is a named memory location used to store data that can change during program execution. It acts like a container that holds values.

Variables can be declared in different places depending on their purpose:

- Inside a method or block (Local Variable)
- Inside a class (Instance/Non-static Variable)
- Inside a class using the `static` keyword (Static Variable)
- Inside a method's parameter list (Parameter Variable)

## Types of Variables

1. Local Variables
2. Instance (Non-static) Variables
3. Static Variables
4. Parameter Variables

---

# What is a Literal?

A **literal** is the actual value that is directly written in the source code.

If a variable is the container, then the literal is the data stored inside that container.

### Example

```java
int age = 25;
```

Here,

- `age` → Variable
- `25` → Integer Literal

Some other literals include:

```java
'A'
"Hello"
true
3.14
```

---

# Variable Declaration

Variable declaration means creating a variable by specifying its data type and name.

### Syntax

```java
dataType variableName;
```

### Example

```java
int age;
String name;
double salary;
```

---

# Variable Initialization

Variable initialization means assigning a value to a variable for the first time.

### Example

```java
int age = 20;
```

or

```java
int age;
age = 20;
```

### Important Note

- Local variables **do not** get default values.
- Instance and static variables receive default values automatically.

| Variable Type     | Default Value |
| ----------------- | ------------- |
| Local Variable    | ❌ No         |
| Instance Variable | ✅ Yes        |
| Static Variable   | ✅ Yes        |

---

# Variable Naming Conventions

A variable name should follow Java naming rules.

## Rules

- The first character must be:
  - A letter
  - `_` (underscore)
  - `$` (dollar sign)

- Remaining characters can contain:
  - Letters
  - Digits
  - `_`
  - `$`

- A variable name cannot start with a digit.

- Variable names cannot be Java keywords.

### Valid Examples

```java
age
studentName
_marks
$salary
```

### Invalid Examples

```java
2age
class
int
```

### Naming Convention

Java follows **camelCase**.

Examples:

```java
studentAge
greenGarden
totalMarks
```

---

# Scope of Variables

The **scope** of a variable determines where it can be accessed in a program.

## 1. Local Variables

- Declared inside a method or block.
- Accessible only within that block.
- Created when execution reaches their declaration.
- Destroyed when the block ends.
- Do not receive default values.

### Example

```java
void display() {
    int age = 20;
}
```

---

## 2. Instance (Non-static) Variables

- Declared inside a class but outside methods.
- Belong to an object.
- Every object has its own copy.
- Accessible throughout the class.
- Receive default values.

### Example

```java
class Student {
    int age;
}
```

---

## 3. Static Variables

- Declared using the `static` keyword.
- Belong to the class rather than individual objects.
- Shared among all objects.
- Created when the class is loaded into memory.
- Receive default values.

### Example

```java
class Student {
    static String college = "ABC College";
}
```

---

## 4. Parameter Variables

- Declared inside the parentheses of a method.
- Used to receive values when a method is called.
- Accessible only inside that method.
- Exist only during the execution of the method.

### Example

```java
void display(int age) {
    System.out.println(age);
}
```

---

# Summary

| Variable Type         | Declared In       | Belongs To   | Lifetime                    | Default Value |
| --------------------- | ----------------- | ------------ | --------------------------- | ------------- |
| Local                 | Method/Block      | Method/Block | Until block ends            | ❌ No         |
| Parameter             | Method Parameters | Method Call  | Until method ends           | ❌ No         |
| Instance (Non-static) | Class             | Object       | Until object is destroyed   | ✅ Yes        |
| Static                | Class (`static`)  | Class        | Until program/class unloads | ✅ Yes        |

---

# Key Takeaways

- A variable stores data.
- A literal is the actual value assigned to a variable.
- Declaration creates a variable.
- Initialization assigns its first value.
- Java follows **camelCase** naming conventions.
- Local variables have no default values.
- Instance variables belong to objects.
- Static variables belong to the class and are shared among all objects.
- Parameter variables exist only while a method is executing.

# Self-Test – Variables, Data Types & Type Casting

---

# 1. Why does `5 / 2` produce `2` when both operands are integers?

Both `5` and `2` are of type `int`. When Java divides two integers, it performs **integer division**, which discards the decimal part of the result.

```java
int a = 5;
int b = 2;

int ans = a / b;
System.out.println(ans);
```

### Output

```text
2
```

The actual mathematical result is `2.5`, but since the result is an `int`, Java removes the fractional part, leaving `2`.

---

# 2. Why does `5.0 / 2` produce `2.5`?

`5.0` is a `double` literal by default. Since one operand is a `double`, Java automatically performs **implicit widening conversion**, converting `2` into `2.0`.

The operation becomes:

```java
5.0 / 2.0
```

which produces:

```text
2.5
```

Example:

```java
double ans = 5.0 / 2;
System.out.println(ans);
```

### Output

```text
2.5
```

---

# 3. Why can an `int` be assigned to a `double` without casting, but not the other way around?

This is because of **widening** and **narrowing** conversions.

### Widening Conversion (Implicit)

A smaller data type can be stored inside a larger data type without any data loss.

```java
int num = 25;
double value = num;
```

Here, Java automatically converts `25` into `25.0`.

---

### Narrowing Conversion (Explicit)

A larger data type cannot be stored inside a smaller one automatically because data may be lost.

```java
double value = 25.75;

// int num = value;   // Compile-time error

int num = (int) value;
```

### Output

```text
25
```

The decimal part (`.75`) is discarded during explicit casting.

---

# 4. What happens when you cast `65` to a `char`?

Java converts the integer into its corresponding **Unicode (ASCII-compatible)** character.

```java
char ch = (char) 65;
System.out.println(ch);
```

### Output

```text
A
```

Since the Unicode value of `65` is `'A'`, the output is `A`.

---

# 5. Why is `==` different for primitives and objects?

For **primitive data types**, `==` compares the actual values.

```java
int a = 10;
int b = 10;

System.out.println(a == b);
```

### Output

```text
true
```

---

For **objects**, `==` compares whether both references point to the **same object in memory**, not whether their contents are equal.

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
```

### Output

```text
false
```

To compare object contents, use `.equals()`.

```java
System.out.println(s1.equals(s2));
```

### Output

```text
true
```

---

# 6. Explain the difference between a variable and a literal.

A **variable** is a named memory location used to store data.

A **literal** is the actual value written directly in the program.

Example:

```java
int age = 25;
```

- `age` → Variable
- `25` → Integer Literal

---

# 7. When would you use `double` instead of `float`?

Use `double` when:

- Higher precision is required.
- Performing scientific or mathematical calculations.
- Working with large decimal values.

Use `float` when:

- Saving memory is more important.
- Lower precision is acceptable (such as graphics programming).

Generally, `double` is preferred because it provides greater precision.

---

# 8. Why does narrowing require an explicit cast?

Narrowing conversion may result in **data loss**, so Java requires the programmer to perform it manually.

Example:

```java
double num = 12.99;

int value = (int) num;

System.out.println(value);
```

### Output

```text
12
```

Since the decimal part is removed, Java requires an explicit cast to make the programmer aware of the possible loss of data.

---

# 9. Explain the difference between prefix and postfix increment.

## Prefix Increment (`++x`)

The variable is incremented **before** it is used.

```java
int x = 5;

System.out.println(++x);
```

### Output

```text
6
```

---

## Postfix Increment (`x++`)

The variable is used first, then incremented.

```java
int x = 5;

System.out.println(x++);
System.out.println(x);
```

### Output

```text
5
6
```

---

# 10. Predict the output of simple arithmetic expressions before running them.

### Example 1

```java
System.out.println(10 + 5 * 2);
```

Output:

```text
20
```

Explanation:

Multiplication has higher precedence.

```
5 × 2 = 10
10 + 10 = 20
```

---

### Example 2

```java
System.out.println((10 + 5) * 2);
```

Output:

```text
30
```

Explanation:

Parentheses are evaluated first.

---

### Example 3

```java
System.out.println(10 / 3);
```

Output:

```text
3
```

Integer division removes the decimal part.

---

### Example 4

```java
System.out.println(10 / 3.0);
```

Output:

```text
3.3333333333333335
```

Since one operand is a `double`, Java performs floating-point division.

---

### Example 5

```java
System.out.println(10 % 3);
```

Output:

```text
1
```

The `%` operator returns the remainder after division.

---

# Key Takeaways

- Integer division discards decimal values.
- If one operand is a `float` or `double`, Java performs floating-point division.
- Widening conversions happen automatically.
- Narrowing conversions require explicit casting.
- Variables store data; literals are the actual values.
- `==` compares values for primitives but memory references for objects.
- `double` provides higher precision than `float`.
- Prefix increment changes the value before use, while postfix increment changes it after use.
- Understanding operator precedence helps predict arithmetic expression results correctly.
