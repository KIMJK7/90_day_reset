# 🔥 Task 6 — Identify the Data Structure

Choose:

```text
Stack
Queue
Deque
HashSet
HashMap
Two Pointers
Sliding Window
Binary Search
```

### A

> Check whether brackets are correctly nested.

Stack

### B

> Process people in the order they arrived.

Queue

### C

> Find the next greater element to the right.

Deque

### D

> Check whether a value has appeared before.

HashSet

### E

> Store a student's roll number and marks.

HashMap

### F

> Search a sorted array.

Binary Search

### G

> Maintain a contiguous range whose boundaries move.

Sliding Window

---

# 🔥 Task 7 — Why Not Just Use an Array?

Suppose you need a stack.

You could implement:

```text
int[] stack
```

yourself.

Why might that actually be useful to understand?

And why would you normally use:

```java
Deque<Integer>
```

in real Java code?

Think in terms of:

```text
abstraction
implementation
reusability
error-proneness
```

---

# 🧠 Thinking Exercises

Answer without coding.

### 1.

Why is a stack naturally suited for balanced parentheses?

### 2.

Why is a queue naturally suited for BFS?

### 3.

What does `peek()` do?

### 4.

What's the difference between `poll()` and `peek()`?

### 5.

Why can a monotonic stack solve some O(n²) problems in O(n)?

### 6.

What does "monotonic" mean in monotonic stack?

### 7.

Why does every element being pushed and popped at most once imply O(n)?

---

# ⚠️ Important Distinction

Don't confuse:

```text
Stack
```

with:

```text
Monotonic Stack
```

A normal stack only guarantees:

```text
LIFO
```

A monotonic stack adds an **ordering property**.

For example, the stack may maintain:

```text
increasing order
```

or:

```text
decreasing order
```

depending on the problem.

So:

```text
Stack = access rule
Monotonic stack = access rule + maintained ordering
```

That's the conceptual upgrade.
