## Linked List Notes

### 1. Why is array index access `O(1)` but linked-list index access `O(n)`?

An array stores elements in **contiguous memory**.

For example:

```text
Array:
[10][20][30][40][50]
```

If you want index `3`, the computer can calculate exactly where that element is located using the starting address and the element size.

So:

```text
array[3] → direct access
```

No matter whether the array has 10 elements or 10 million elements, finding index `3` takes constant time.

**Therefore: `O(1)`**

A linked list does not store nodes contiguously:

```text
10 → 20 → 30 → 40 → 50
```

To find the 4th node, you have to start at `head` and follow:

```text
head → 10 → 20 → 30 → 40
```

You cannot jump directly to node 40 because node 10 only knows where node 20 is, and node 20 only knows where node 30 is.

**Therefore: `O(n)`**

---

### 2. Why can inserting at the beginning of a linked list be `O(1)`?

Because you don't have to move any existing nodes.

Suppose:

```text
head
 ↓
10 → 20 → 30
```

To insert `5`:

```java
newNode.next = head;
head = newNode;
```

Result:

```text
head
 ↓
5 → 10 → 20 → 30
```

Only **two references** need to be set.

The size of the list doesn't matter.

Whether the list contains 3 nodes or 3 million nodes, the operation still does the same amount of work.

**Therefore: `O(1)`**

---

### 3. Why is saying "linked-list insertion is always O(1)" inaccurate?

Because it depends on **where you're inserting and whether you already have the necessary reference**.

For example, inserting at the beginning:

```text
head → A → B → C
```

is `O(1)` because you already have `head`.

But inserting at the **end** when you only have `head` requires traversal:

```text
head → A → B → C → D
                   ↑
              find this first
```

You have to walk through the list to find `D`.

That's **O(n)**.

Similarly, if you want to insert after a particular value, such as:

```text
A → B → C → D
```

insert `X` after `C`, you first need to **find C**, which can take `O(n)`.

Once you already have a reference to C, the actual insertion is `O(1)`.

So the more accurate statement is:

> **Linked-list insertion can be O(1) when you already have the node/reference at the insertion position. Finding that position may cost O(n).**

---

### 4. If you have `A → B → C → D` and want to remove C, which reference actually needs to change?

The reference inside **B**.

Initially:

```text
A → B → C → D
```

B has:

```text
B.next → C
```

To remove C, change it to:

```text
B.next → D
```

Conceptually:

```java
B.next = C.next;
```

Result:

```text
A → B → D
```

You don't need to modify A or D.

---

### 5. After removing C, does the C node immediately disappear from memory?

**Not necessarily.**

Removing C from the linked-list structure means that nothing in the list points to C anymore:

```text
A → B → D
```

But the `C` object may still exist in memory temporarily if something else still references it.

For example:

```java
Node c = ...;
```

If `c` still points to C, C is still reachable.

If **no references anywhere** point to C anymore, then C becomes **eligible for garbage collection**.

Java's garbage collector can eventually reclaim that memory.

So:

> **Removing a node from the list and freeing its memory are two separate things.**

---

### 6. What's the difference between these?

#### `current = current.next;`

This changes the **local variable `current`**.

Example:

```text
A → B → C
↑
current
```

After:

```java
current = current.next;
```

you have:

```text
A → B → C
     ↑
   current
```

The list itself has **not changed**.

You simply moved your pointer/reference from A to B.

---

#### `current.next = current.next.next;`

This changes the **structure of the list**.

Suppose:

```text
A → B → C → D
↑
current
```

Then:

```java
current.next = current.next.next;
```

means:

```text
A.next = B.next
```

which means:

```text
A.next = C
```

Result:

```text
A → C → D
```

B has been bypassed.

So remember:

> `current = current.next` → **move yourself**
>
> `current.next = current.next.next` → **change the list**

That distinction is fundamental to linked lists.

---

# 🎤 Question of the Day

> **Why does a linked list trade fast random access for cheap structural modification?**

The underlying reason is **how the data is represented in memory**.

An array stores its elements in a contiguous block:

```text
Memory:

[ A ][ B ][ C ][ D ][ E ]
```

Because the locations follow a predictable pattern, the computer can calculate where element `i` lives directly.

That gives arrays **fast random access: `O(1)`**.

But inserting into the middle can require shifting elements:

```text
Before:

A B C D
```

Insert X at position 2:

```text
A B X C D
    ↑
```

C and D may need to move to make room.

---

A linked list instead stores each element in a separate **node**, and each node contains both its data and a reference to another node:

```text
A       B       C       D
↓       ↓       ↓       ↓
[data] [data] [data] [data]
  |      |       |       |
 next → next →  next → next
```

The nodes don't need to be next to each other in memory. The references connect them logically.

That makes random access expensive because you can't calculate:

> "Give me node #500."

You have to follow the chain:

```text
head → 1 → 2 → 3 → ... → 500
```

But it makes certain structural modifications cheap.

If you already have the relevant node:

```text
A → B → C → D
```

you can remove C simply by changing B's reference:

```text
A → B ─────→ D
      C
```

No shifting of every element after C is necessary.

### The tradeoff in one sentence:

> **Arrays optimize for locating elements; linked lists optimize for changing the connections between elements.**

And there's an important caveat: **linked lists are not universally better for insertion/deletion**. If you first have to traverse the list to find where the modification should happen, that traversal can still cost `O(n)`. The famous `O(1)` insertion/deletion advantage assumes you already have the relevant node/reference.
