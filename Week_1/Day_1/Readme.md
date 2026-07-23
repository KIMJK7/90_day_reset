# Day 1 – Java Basics

## What is Java?

Java is a **high-level, object-oriented, class-based programming language**. Unlike languages like C or C++, Java does not compile source code directly into machine code. Instead, it compiles the source code into **Bytecode**, an intermediate, platform-independent code that can run on any operating system with a compatible JVM.

---

## JVM (Java Virtual Machine)

- Executes Java Bytecode.
- Converts Bytecode into machine code using the **Interpreter** and **JIT (Just-In-Time) Compiler**.
- Makes Java **platform independent**.

---

## JRE (Java Runtime Environment)

The JRE provides everything needed to **run** Java applications. It includes:

- JVM
- Core Java libraries

> **Note:** JRE does **not** include development tools like the Java compiler (`javac`).

---

## JDK (Java Development Kit)

The JDK is used to **develop** Java applications. It includes:

- JRE
- `javac` (Java Compiler)
- `jar`
- `javadoc`
- `jdb` (Debugger)
- Other development tools

---

## Bytecode

Bytecode (`.class`) is the intermediate code generated from Java source code (`.java`). It is platform-independent and can be executed by any JVM.

---

## Java Execution Flow

```text
Source Code (.java)
        │
        ▼
javac Compiler
        │
        ▼
Bytecode (.class)
        │
        ▼
Class Loader
        │
        ▼
Bytecode Verifier
        │
        ▼
JVM (Interpreter + JIT Compiler)
        │
        ▼
Machine Code
        │
        ▼
Program Execution
```

---

## Key Takeaways

- Java is **Write Once, Run Anywhere (WORA)**.
- Source code is compiled into **Bytecode**, not machine code.
- The **JVM** executes Bytecode and provides platform independence.
- The **JRE** is for running Java applications.
- The **JDK** is for developing Java applications.
- **JIT Compiler** improves performance by compiling frequently used Bytecode into native machine code.

---

**Day 1 Complete ✅**
