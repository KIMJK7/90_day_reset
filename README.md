90-Day Software Engineering Bootcamp

Week 1 – Java & Programming Fundamentals Theme

Understanding How Programs Work
DAY 1
Mission
From Java Code to Running Program

Understand what actually happens between writing Java code and seeing the output on your screen.
Day - 1 question

How does Java code become a running program?
TWhen a Java program is executed, the source code (.java) is first passed to the Java compiler (javac). The compiler checks the code for syntax and many compile-time semantic errors. If compilation succeeds, it generates a .class file containing Java Bytecode.

The JVM's Class Loader loads the bytecode into memory. Before execution, the Bytecode Verifier validates that the bytecode is safe and follows JVM rules. The JVM then links and initializes the classes.

Initially, the JVM interprets the bytecode. As the program runs, the Just-In-Time (JIT) compiler identifies frequently executed code and compiles it into native machine code. This machine code is then executed directly by the CPU, improving performance while maintaining Java's platform independence
