# Day 5 Notes – Arrays in Java

# What is an Array?

An **array** is an object in Java that stores multiple values of the **same data type** under a single variable name.

- Every element is stored in **contiguous (continuous) memory locations**.
- Each element is identified by its **index**, which starts from **0**.
- Arrays have a **fixed length** that is decided when the array is created.
- Since arrays are objects in Java, they are stored in the **Heap Memory**, while the reference variable is stored in the **Stack Memory** (if it is a local variable).

Example:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

Memory Representation:

```
Stack                        Heap

numbers  ----------------->  +----+----+----+----+----+
(reference)                 |10  |20  |30  |40  |50  |
                             +----+----+----+----+----+
                               0    1    2    3    4
```

---

# Why do Arrays Exist?

Without arrays, every value would need its own variable.

Example without arrays:

```java
int marks1 = 90;
int marks2 = 85;
int marks3 = 76;
int marks4 = 92;
int marks5 = 88;
```

Problems:

- Difficult to manage large amounts of data.
- Cannot use loops efficiently.
- Searching and sorting become complicated.
- Code becomes repetitive.

Using an array:

```java
int[] marks = {90, 85, 76, 92, 88};
```

Now we can process every value using loops.

Example:

```java
for(int i = 0; i < marks.length; i++){
    System.out.println(marks[i]);
}
```

Arrays make programs:

- Easier to write
- Easier to maintain
- Faster to process collections of data

---

# How are Arrays Stored in Memory?

Arrays are stored as a **continuous block of memory** inside the Heap.

When an array is created:

```java
int[] arr = new int[5];
```

Java allocates one continuous memory block large enough to hold all five integers.

Memory:

```
Stack

arr
 |
 |
 v

Heap

+----+----+----+----+----+
| 0  | 0  | 0  | 0  | 0  |
+----+----+----+----+----+
  0    1    2    3    4
```

The variable `arr` only stores the **reference (address)** of the first element (base address).

Java calculates every other element using that base address.

---

# Why do Arrays Use Zero-Based Indexing?

Arrays start from **0** because the index represents the **offset (distance)** from the first element.

Formula:

```
Address of element

Base Address + (Index × Size of Data Type)
```

Example:

```
Base Address = 1000
int size = 4 bytes

Index 0

1000 + (0 × 4) = 1000

Index 1

1000 + (1 × 4) = 1004

Index 2

1000 + (2 × 4) = 1008
```

The first element is **0 positions away** from the beginning of the array.

That is why indexing naturally starts at **0**.

---

# Why are Arrays Fixed in Size?

When an array is created:

```java
int[] arr = new int[5];
```

Java reserves memory for exactly five integers.

```
+----+----+----+----+----+
```

If later you need six elements:

```
+----+----+----+----+----+----+
```

Java cannot simply extend the existing block because the memory immediately after it may already be occupied by another object.

Instead, Java must:

1. Allocate a larger array.
2. Copy every element.
3. Change the reference.
4. Delete the old array later through Garbage Collection.

Because moving arrays every time would be expensive, Java keeps arrays **fixed in size**.

If dynamic resizing is needed, classes like `ArrayList` handle this internally.

---

# Difference Between Length and Last Index

These two are commonly confused.

Example:

```java
int[] arr = new int[5];
```

The array contains:

```
Index

0 1 2 3 4
```

Length:

```
5
```

Last Index:

```
4
```

Formula:

```
Last Index = Length - 1
```

Example:

```java
arr.length      // 5

arr[4]          // Last element

arr[5]          // Error
```

Attempting to access index 5 results in:

```java
ArrayIndexOutOfBoundsException
```

---

# Why is Array Access O(1)?

Accessing an element by index takes **constant time**, regardless of the array size.

Example:

```java
arr[2];
```

Java does **not** search through the array.

Instead, it directly calculates the memory address.

Formula:

```
Address = Base Address + (Index × Element Size)
```

Example:

```
Base Address = 1000

Index = 3

Size = 4 bytes

Address =

1000 + (3 × 4)

= 1012
```

The computer immediately jumps to address 1012.

Whether the array has:

- 5 elements
- 500 elements
- 5 million elements

the calculation still takes one operation.

Therefore:

```
Time Complexity = O(1)
```

---

# Why do Arrays Start at Index 0?

Arrays start at **0** because indexing represents the number of positions away from the first element.

Think of the first element as the starting point.

Distance from the beginning:

```
First element

0 steps away

Second element

1 step away

Third element

2 steps away
```

This makes address calculation simple:

```
Address = Base Address + (Index × Element Size)
```

If arrays started at 1, every access would require subtracting 1 before calculating the address, adding unnecessary computation. Zero-based indexing keeps the calculation simple and efficient.

---

# Why are Arrays Stored on the Heap?

Arrays are objects in Java, and **all objects are stored on the Heap**.

Reasons:

### 1. Arrays can be large

An array may contain thousands or even millions of elements.

The Stack is small and intended for method calls and local variables.

The Heap is much larger and designed for storing objects.

### 2. Arrays can outlive a method

```java
public static int[] createArray(){
    int[] arr = new int[100];
    return arr;
}
```

When the method finishes:

- The local reference variable is removed from the Stack.
- The array still exists in the Heap because another reference may point to it.

### 3. Garbage Collection

When no references point to the array anymore, Java automatically removes it using the Garbage Collector.

---

# Why Can't an Array Hold Different Primitive Types?

Every primitive type occupies a specific amount of memory.

Examples:

```
byte    -> 1 byte

short   -> 2 bytes

int     -> 4 bytes

long    -> 8 bytes

double  -> 8 bytes

char    -> 2 bytes

boolean -> JVM dependent
```

Array address calculation assumes that **every element has the same size**.

Example:

```
Address = Base Address + (Index × Element Size)
```

If an array contained:

```
10
'A'
3.14
true
```

each element would have different memory requirements, making direct address calculation impossible and slowing access.

By allowing only one data type:

- Every element has the same size.
- Memory remains contiguous.
- Address calculation is simple.
- Random access remains O(1).

Example:

```java
int[] numbers = {10, 20, 30, 40};
```

Valid because every element is an `int`.

This is **not valid**:

```java
int[] arr = {10, 'A', 5.5};
```

because `'A'` is a `char` and `5.5` is a `double`.

---

# Key Takeaways

- An array stores multiple values of the **same data type**.
- Arrays are objects stored in the **Heap**.
- The reference variable stores the array's base address.
- Elements are stored in **contiguous memory**.
- Arrays use **zero-based indexing** because the index represents the offset from the first element.
- Arrays have a **fixed size** because Java allocates one continuous memory block during creation.
- **Length** is the total number of elements; **last index** is `length - 1`.
- Array access is **O(1)** because Java calculates the element's address directly instead of searching.
- Arrays can store only **one primitive type** so that every element has the same size, enabling fast address calculation and efficient memory usage.
