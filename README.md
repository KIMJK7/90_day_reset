# 90-Day Software Engineering Bootcamp

# Week 1 – Java & Programming Fundamentals

## Day 1 – Understanding How Programs Work

### 🎯 Mission

**From Java Code to a Running Program**

Understand what happens between writing Java code and seeing the output on your screen.

---

# Question

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

How does Java represent data internally, how is that data stored in memory, and how do variables, data types, type casting, and operators work together to manipulate it? 
All data inside a computer is ultimately stored as binary (bits: 0s and 1s). Java data types tell the JVM how to interpret those bits—for example, as an integer, floating-point number, character, or boolean.
primitive data types are in built data types int, double, char, short etc variables stored in stack
reference/objects : complex data chunks like strings who are allocated in heap and have a reference variable in stack

Data is stored as such:
JVM divides the RAM into distinct meamory segements Heap and stack
Stack (Fast and temporary) - it stores local variables, method perimeters, primitive values, the memory is allocated when the method starts and the meomry is freed up when the method finishes
Heap (dynamic and shared storage) - it stored the values of objects created with the new keyword, whose values are kept in heap and he reference pointers to memory location are in stack, memory in the heap is removed using a Garbage collector when there is no more reference pointer to it in the stack.

Variables - are the containers which store literals or memory addresses
Data types - primitive or objects give meaning to the varibles tells us what type of data can be stored in this and what will be the operations which can e performed on it
type casting - it gives us a safe way to convert literals from one data type to another (implicit widening - converting a small data type literal in larger one it is done automatically as there is no data loss which might take place and explicit narrowing- storing a larger literal into a smaller on it is done manually as there is a good chance of data loss taking place.)
operators are like physical tools they read the data, modify the data and combine the contents of those containers

LifeCycle: 
double OriginalPrice = 200;
int discount = 15;
int FinalPrice = (int) (OriginalPrice - discount);

1. Storage Initialization - OriginalPrice (double) and discount (int) stored in stack (they are alloated memory).
2. operators: (-) subtract operator executes (OP-d) result is a double (as OP is double and d is int first d is converted to double, subtraction takes place and the and is double).
3. type casting: the result is converted to a int.
4. result : int Final price contains the result of subtraction in integer form 
