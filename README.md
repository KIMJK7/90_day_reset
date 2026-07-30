# 90-Day Software Engineering Bootcamp

# Week 1 – Java & Programming Fundamentals

## Day 1 – Understanding How Programs Work

### 🎯 Mission

**From Java Code to a Running Program**

Understand what happens between writing Java code and seeing the output on your screen.

---

# Question 1

## How does Java code become a running program?

When a Java program is executed, the source code (`.java` file) is first passed to the **Java Compiler (`javac`)**.

The compiler checks the source code for syntax errors. If no errors are found, it converts the source code into **bytecode** (`.class` file).

The **Java Virtual Machine (JVM)** then starts the execution process.

1. The **Class Loader** loads the required `.class` files into memory.
2. The **Bytecode Verifier** checks the bytecode to ensure it is valid, secure, and follows JVM rules.
3. The JVM **links** and **initializes** the classes before execution.

Initially, the JVM executes the bytecode using its **Interpreter**, which translates the bytecode into machine instructions one line at a time.

As the program continues to run, the **Just-In-Time (JIT) Compiler** identifies frequently executed code (called **hot code**) and compiles it into **native machine code**.

The native machine code is executed directly by the **CPU**, making the program much faster while still maintaining Java's **Write Once, Run Anywhere (WORA)** principle.

---

# Execution Flow

```text
Java Source Code (.java)
          │
          ▼
Java Compiler (javac)
          │
          ▼
Bytecode (.class)
          │
          ▼
JVM
 ├── Class Loader
 ├── Bytecode Verifier
 ├── Linking & Initialization
 ├── Interpreter
 └── JIT Compiler
          │
          ▼
Native Machine Code
          │
          ▼
CPU Execution
```

---

# Key Takeaways

- Java source code is written in a `.java` file.
- The **Java Compiler (`javac`)** converts source code into bytecode (`.class`).
- The **JVM** loads, verifies, links, and initializes the bytecode.
- The **Interpreter** executes bytecode initially.
- The **JIT Compiler** converts frequently executed code into native machine code for better performance.
- The CPU executes the native machine code.
- This architecture allows Java programs to be **platform-independent** while still achieving good performance.

## Question 2: How does Java represent data internally, how is that data stored in memory, and how do variables, data types, type casting, and operators work together to manipulate it?

### 1. Definition

All data inside a computer is ultimately stored as **binary (bits: 0s
and 1s)**.

Java data types tell the JVM how to interpret those bits---for example,
as an integer, floating-point number, character, or boolean.

- **Primitive Data Types** -- Built-in types such as `int`, `double`,
  `char`, `boolean`, `short`, etc.
- **Reference Types (Objects)** -- Complex data such as `String`,
  arrays, and custom objects. The actual objects are stored in the
  heap, while their references are stored in the stack.

---

### 2. Internal Working

The JVM divides memory into two major areas:

#### Stack (Fast and Temporary)

- Stores local variables.
- Stores method parameters.
- Stores primitive values.
- Stores references to objects.
- Memory is allocated when a method starts.
- Memory is automatically released when the method finishes.

#### Heap (Dynamic and Shared)

- Stores objects created using the `new` keyword.
- The stack contains references that point to these objects.
- Objects remain in memory until no references point to them.
- Unused objects are removed automatically by the **Garbage
  Collector**.

Variables, data types, type casting, and operators work together as
follows:

- **Variables** store values or memory addresses.
- **Data types** define what kind of data a variable can store and
  what operations are valid.
- **Type casting** converts one data type into another.
  - **Implicit (Widening):** Smaller type → Larger type (automatic,
    no data loss).
  - **Explicit (Narrowing):** Larger type → Smaller type (manual,
    possible data loss).
- **Operators** perform calculations, comparisons, assignments, and
  logical operations on data.

---

### 3. Execution Flow

```java
double originalPrice = 200;
int discount = 15;
int finalPrice = (int) (originalPrice - discount);
```

Step-by-step:

1.  `originalPrice` (`double`) and `discount` (`int`) are created in the
    stack.
2.  The `-` operator executes.
3.  Since one operand is a `double`, Java automatically converts
    `discount` into a `double`.
4.  The subtraction result is a `double`.
5.  The explicit cast `(int)` converts the result into an integer.
6.  `finalPrice` stores the integer result.

---

### 4. Memory Perspective

- Primitive variables are stored directly in the stack.
- Objects live in the heap.
- References pointing to heap objects are stored in the stack.
- When an object has no remaining references, the Garbage Collector
  eventually removes it from the heap.

---

### 5. Java Example

```java
double originalPrice = 200;
int discount = 15;

int finalPrice = (int) (originalPrice - discount);

System.out.println(finalPrice);
```

**Output**

    185

---

### 6. Real-world Analogy

Think of the **stack** as your work desk.

- Papers currently being worked on are on the desk.
- The **heap** is a storage room.
- The desk contains sticky notes (references) telling you where each
  file is stored in the storage room.
- When nobody needs a file anymore, the cleaner (Garbage Collector)
  throws it away.

---

### 7. Common Beginner Mistakes

- Thinking objects are stored directly in variables. (Variables store
  references, not the objects themselves.)
- Confusing the stack with the heap.
- Forgetting explicit casting when narrowing data types.
- Assuming the Garbage Collector removes objects immediately after
  they become unused.

---

# Question 3: How does a Java program make decisions and repeat tasks?

### 1. Definition

Java controls program execution using **control flow statements**. By
default, statements execute sequentially from top to bottom.

Decision-making statements such as `if`, `else if`, `else`, and `switch`
choose which block of code should execute.

Looping statements such as `for`, `while`, and `do-while` repeat a block
of code.

---

### 2. Internal Working

- The JVM evaluates conditions one by one.
- If a decision-making condition is `true`, the corresponding block
  executes.
- For loops, the JVM repeatedly checks the loop condition.
- The loop continues until the condition becomes `false`.

---

### 3. Execution Flow

1.  Program starts executing from top to bottom.
2.  A control-flow statement is encountered.
3.  Java evaluates its condition or expression.
4.  If the condition is satisfied, the associated block executes.
5.  For loops, the condition is checked again after each iteration.
6.  When the condition becomes `false`, execution continues after the
    loop.

---

### 4. Memory Perspective

- Control-flow statements themselves do **not** allocate additional
  memory.
- Variables declared inside an `if` block or loop have **block
  scope**.
- These variables exist only while execution remains inside that
  block.

---

### 5. Java Example

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

**Output**

    1
    2
    3
    4
    5

---

### 6. Real-world Analogy

Think of a traffic signal.

- **If** the light is green, you drive.
- **Else**, you stop.

A loop is like doing push-ups:

- Perform one push-up.
- Check if you've reached your target.
- If not, repeat.
- Stop once the target is reached.

---

### 7. Common Beginner Mistakes

- Forgetting to update the loop variable, causing an infinite loop.
- Using `=` instead of `==` in conditions.
- Choosing `switch` when complex boolean expressions require an `if`
  statement.
- Assuming a `while` loop always executes at least once (only
  `do-while` guarantees this).

# Why do Methods Exist, and How Does Java Use Them to Organize and Execute Code?

A **method** is a reusable block of code that performs a specific task. Instead of writing every statement inside the `main()` method, Java allows programmers to divide a program into smaller, well-defined methods. Each method is responsible for a single task, making the program easier to understand and maintain.

## Why Do Methods Exist?

Methods exist to improve the quality and organization of code by:

- **Improving readability** – Large programs become easier to understand when broken into smaller methods.
- **Increasing modularity** – Each method performs one specific task, making the program well-organized.
- **Promoting code reuse** – A method can be written once and called multiple times, reducing duplicate code.
- **Simplifying debugging** – Bugs can be isolated and fixed within a specific method.
- **Making updates easier** – Changes to a method automatically affect every place where it is called.
- **Improving testing** – Individual methods can be tested independently.

Without methods, most of the program's logic would have to be written inside `main()`, making the code long, difficult to read, and harder to maintain.

## How Does Java Use Methods to Organize Code?

Java organizes programs by dividing them into methods, where each method has a specific responsibility.

For example:

- `getInput()` collects user input.
- `calculateTotal()` performs calculations.
- `displayResult()` prints the output.

The `main()` method acts as the starting point of the program and coordinates the execution by calling these methods in the required order.

This modular design makes programs easier to develop, understand, test, and maintain.

## How Does Java Execute a Method?

Consider the following program:

```java
public class Example {

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = add(5, 10);
        System.out.println(result);
    }
}
```

### Execution Steps

1. The JVM starts executing the program from the `main()` method.
2. It encounters the method call `add(5, 10)`.
3. A new **stack frame** is created on the **call stack** for the `add()` method.
4. The arguments are copied into the parameters:
   - `a = 5`
   - `b = 10`
5. The method executes its instructions and computes `5 + 10`.
6. The `return` statement sends the value `15` back to the calling method.
7. The `add()` method finishes, and its stack frame is removed from the call stack.
8. Execution returns to `main()`, where the returned value is stored in the variable `result`.
9. The program continues executing the remaining statements.

## Summary

Methods help Java organize programs by breaking complex problems into smaller, reusable tasks. The JVM executes methods by creating a new stack frame for each method call, running its instructions, returning any required value, removing the stack frame, and then continuing execution from the point where the method was called.

# Day 5 Notes – Arrays (Deep Understanding)

# What Happens if Method A Calls Method B, Method B Calls Method C, and Method C Throws an Exception Before Returning?

When `MethodC()` throws an exception, it does **not** return normally.

Instead, the JVM begins a process called **stack unwinding**.

It checks whether `MethodC()` has a matching `catch` block.

- If a matching `catch` block exists, the exception is handled there.
- If not, `MethodC()`'s stack frame is removed from the call stack, and the exception is propagated to `MethodB()`.

The JVM repeats this process for every calling method until:

- a matching `catch` block is found, or
- the exception reaches `main()`.

If no method handles the exception, the program terminates and the JVM prints a **stack trace**, showing the sequence of method calls that led to the exception.

## Stack Unwinding

```
MethodA()
    ↓
MethodB()
    ↓
MethodC()
    ↓
Exception Thrown
    ↓
MethodC frame removed
    ↓
MethodB checks for catch
    ↓
No catch found
    ↓
MethodB frame removed
    ↓
MethodA checks for catch
    ↓
No catch found
    ↓
MethodA frame removed
    ↓
main() checks
    ↓
No catch found
    ↓
Program Terminates
    ↓
Stack Trace Printed
```

---

# How Do Arrays Work Internally, and Why Are They One of the Fundamental Building Blocks of Programming?

An **array** is an object in Java that stores multiple values of the **same data type** under a single variable name.

When an array is created, Java allocates a **fixed-size contiguous block of memory** on the **Heap** to store all of its elements.

The array variable itself stores a **reference** to the array object.

- If the reference variable is local, it is stored in the **Stack**.
- The actual array object always lives in the **Heap**.

Example:

```java
int[] arr = {10, 20, 30, 40, 50};
```

Memory Representation:

```
Stack

arr
 |
 |
 v

Heap

        Base Address
             ↓

+------+------+------+------+------+
| 10 | 20 | 30 | 40 | 50 |
+------+------+------+------+------+
   0      1      2      3      4
```

Every element occupies the **same amount of memory** because every element has the same data type.

Since every element has a fixed size, Java can directly calculate the location of any element using its index.

Conceptually:

```
Target Address = Base Address + (Index × Size of Each Element)
```

Example (assuming an `int` occupies 4 bytes):

```
arr[0]

Base + (0 × 4)

arr[1]

Base + (1 × 4)

arr[2]

Base + (2 × 4)

arr[3]

Base + (3 × 4)
```

Because Java can compute the address directly, accessing an element does not require searching through the array.

Therefore:

```
Time Complexity

O(1)
```

## Why Are Arrays One of the Fundamental Building Blocks of Programming?

Arrays provide one of the simplest and most efficient ways to store and access collections of data.

Many advanced data structures are built using arrays internally, including:

- ArrayList
- Dynamic Arrays
- Stacks
- Queues
- Heaps
- Hash Tables
- Matrices
- Graph Representations

Understanding arrays is essential because they form the foundation of many algorithms and data structures used in programming.

---

# Why Are Arrays Zero-Indexed?

Arrays start at **index 0** because the index represents the **offset (distance)** from the beginning of the array.

Suppose:

```
Base Address = 1000

Size of int = 4 bytes
```

First element:

```
arr[0]

1000 + (0 × 4)

= 1000
```

Second element:

```
arr[1]

1000 + (1 × 4)

= 1004
```

Third element:

```
arr[2]

1000 + (2 × 4)

= 1008
```

The first element begins exactly at the base address, so its offset is **0**.

If arrays started at index **1**, the calculation would become:

```
arr[1]

1000 + (1 × 4)

= 1004
```

But the first element is actually stored at address **1000**.

The computer would therefore have to subtract **1** from every index before calculating the address.

Zero-based indexing avoids this extra adjustment and makes address calculation simple and efficient.

---

# If Arrays Are So Fast, Why Does Java Provide ArrayList?

Arrays are extremely fast because:

- Elements are stored in contiguous memory.
- Indexed access is O(1).
- Memory layout is simple and efficient.

However, arrays have one major limitation:

**Their size cannot change after creation.**

Example:

```java
int[] arr = new int[5];
```

This array can store exactly five elements.

If you later need more space, Java cannot extend the existing memory block.

Instead, it must:

1. Allocate a larger array.
2. Copy every element into the new array.
3. Update the reference.
4. Allow the old array to be garbage collected.

This process is inconvenient for programmers.

## ArrayList Solves This Problem

`ArrayList` internally uses an array.

When its internal array becomes full, it automatically:

1. Creates a larger array.
2. Copies all existing elements.
3. Continues inserting new elements.

This allows the collection to grow dynamically.

Advantages of `ArrayList`:

- Dynamic size
- Convenient methods (`add()`, `remove()`, `contains()`, etc.)
- Easier to use

Trade-off:

- Slightly slower than raw arrays due to resizing and additional logic.

Arrays prioritize **performance**, while `ArrayList` prioritizes **flexibility**.

---

# If ArrayList Uses an Array Internally, Why Is `add(index, value)` Not Always O(1)?

An `ArrayList` stores its elements inside an internal array.

Because of this:

```
get(index)

O(1)
```

Accessing an element is still constant time.

However, inserting an element at a specific position is different.

Example:

```
Before

Index

0   1   2   3

A   B   C   D
```

Insert `"X"` at index `1`:

```
After

Index

0   1   2   3   4

A   X   B   C   D
```

To make space for `"X"`:

- `D` moves one position.
- `C` moves one position.
- `B` moves one position.

Every element after the insertion point must be shifted.

If there are `n` elements after the index, up to `n` shifts may occur.

Therefore:

```
Time Complexity

O(n)
```

## What Happens if the Internal Array Is Full?

Suppose the internal array has reached its capacity.

Before inserting a new element, the `ArrayList` must:

1. Allocate a larger array.
2. Copy every existing element.
3. Insert the new value.

Example:

```
Old Array

A B C D

↓

Allocate Larger Array

A B C D _
```

Copying every element also takes **O(n)** time.

Therefore:

- `get(index)` → **O(1)**
- `set(index, value)` → **O(1)**
- `add(value)` at the end → **Amortized O(1)**
- `add(index, value)` → **O(n)**
- `remove(index)` → **O(n)**

The shifting of elements—and occasionally copying into a larger array—is why insertion at an arbitrary index is **not** constant time.
