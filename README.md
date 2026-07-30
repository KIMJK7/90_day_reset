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

What happens if Method A calls Method B, Method B calls Method C, and Method C throws an exception before returning?
When MethodC throws an exception, it does not return normally. Instead, the JVM begins stack unwinding. It checks whether MethodC can handle the exception with a matching catch block. If not, MethodC's stack frame is removed, and the exception is propagated to MethodB. This process continues up the call stack until a matching catch block is found. If no method handles the exception, it reaches main(), the program terminates, and the JVM prints a stack trace.

> MethodC() throws
> ↓
> MethodC frame removed
> ↓
> MethodB checks for catch
> ↓
> No catch
> ↓
> MethodB frame removed
> ↓
> MethodA checks
> ↓
> No catch
> ↓
> MethodA frame removed
> ↓
> main() checks

How do arrays work internally, and why are they one of the fundamental building blocks of programming?

An array is an object in Java that stores multiple values of the same data type under a single variable name.

When an array is created, Java allocates a fixed-size contiguous block of memory on the heap to store all of its elements. The array variable itself stores a reference to that array object. If the reference is a local variable, it is stored in the stack frame of the current method; the actual array object always lives on the heap.

Each element in the array occupies the same amount of memory because all elements have the same data type. Since every element has a fixed size, Java can directly calculate the memory location of any element using its index, allowing constant-time (O(1)) random access.

Internally, the address of an element can be thought of conceptually as:

Target Address = Base Address + (Index × Size of Each Element)

For example:

                 Base Address
                      ↓

+------+------+------+------+------+
| 10 | 20 | 30 | 40 | 50 |
+------+------+------+------+------+
0 1 2 3 4
Index

If the base address points to the first element and each int occupies 4 bytes, then:

arr[0] = Base + (0 × 4)
arr[1] = Base + (1 × 4)
arr[2] = Base + (2 × 4)
arr[3] = Base + (3 × 4)

This direct address calculation is why accessing an element by its index is very fast.

Arrays are one of the fundamental building blocks of programming because they provide an efficient way to store and access collections of data. Many other data structures—such as ArrayLists, stacks, queues, heaps, hash tables, matrices, and dynamic arrays—are built on top of arrays or use arrays internally. Understanding arrays is essential because they form the foundation for many algorithms and more advanced data structures.

Why are arrays zero-indexed?

This question comes up surprisingly often.

The conceptual answer is:

Suppose:

Base Address = 1000

Each int

4 bytes

Then

arr[0]

1000 + (0 × 4)

=

1000

The first element begins exactly at the base address.

If arrays started at 1:

arr[1]

1000 + (1 × 4)

=

1004

You'd have to subtract one from every index during address calculation.

Zero-based indexing makes the offset from the beginning of the array equal to the index itself, simplifying the calculation.

If arrays are so fast, why does Java provide ArrayList?

Arrays are extremely fast because they store elements in a fixed-size contiguous block of memory, allowing constant-time indexed access. However, their size cannot change after creation. If more space is needed, a new array must be created and the existing elements copied into it. ArrayList solves this limitation by internally using an array that automatically resizes when it becomes full. This provides dynamic sizing and convenient operations such as add() and remove(), at the cost of occasional resizing and element copying. Therefore, arrays prioritize performance and simplicity, while ArrayList prioritizes flexibility and ease of use.

If ArrayList uses an array internally, why is add(index, value) not always O(1)?
ArrayList internally stores elements in an array. Accessing an element by index is O(1), just like an array. However, inserting an element at a specific index is O(n) because all subsequent elements must be shifted one position to the right to make space. Additionally, if the internal array becomes full, the ArrayList allocates a larger array and copies all elements into it before inserting the new value. Therefore, insertion at an index is O(n), while appending to the end is amortized O(1).
