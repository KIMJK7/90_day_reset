Here are the notes I’d want you to understand, not just memorize.

## 1. Why does `current = current.next` not modify the linked list?

Because it changes **what the variable `current` points to**, not what the node itself points to.

Suppose:

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

The relationship between A, B, and C hasn't changed.

You simply moved your reference variable.

**Think:**

> `current = ...` → move the pointer.

---

## 2. Why does `current.next = current.next.next` modify the linked list?

Because this changes a field **inside an actual node**.

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

```java
A.next = B.next;
```

and `B.next` is C.

So A now points directly to C:

```text
A → C → D
```

B has been disconnected from the chain.

**Think:**

> `current.next = ...` → change the connection stored inside the node.

---

## 3. Why must insertion preserve `current.next` before overwriting it?

Because `current.next` is the only reference to the rest of the list from `current`.

Suppose:

```text
A → B → C
```

You want to insert X between A and B.

Correct:

```java
newNode.next = current.next;
current.next = newNode;
```

First:

```text
A → B → C
    ↑
current.next
```

You save B by making:

```text
X → B → C
```

Then connect A:

```text
A → X → B → C
```

### What if you do it in the wrong order?

```java
current.next = newNode;
newNode.next = current.next;
```

After the first line:

```text
A → X
```

Now `current.next` is already X.

So the second line becomes:

```java
newNode.next = newNode;
```

You've created:

```text
A → X
    ↖
     └── X
```

and lost the connection to B → C.

So the rule is:

> **Save the old connection before replacing it.**

---

## 4. Why does fast/slow find the middle?

Because of **relative movement**.

Slow moves:

```text
+1 node per iteration
```

Fast moves:

```text
+2 nodes per iteration
```

Therefore, fast covers **twice the distance** of slow.

Suppose the list has 10 nodes.

By the time fast has traveled roughly 10 nodes and reaches the end, slow has traveled roughly:

```text
10 / 2 = 5
```

nodes.

So slow is around the middle.

You don't need to know that the list has 10 nodes beforehand. You're letting **fast's position tell you when you've reached the halfway point**.

That's the clever part.

---

## 5. Why `slow == fast` instead of `slow.data == fast.data`?

Because we're interested in whether they are the **same node**, not whether two different nodes happen to contain the same value.

Consider:

```text
A(10) → B(20) → C(10) → D
```

A and C have the same data:

```text
A.data == C.data
```

but they are completely different nodes.

If cycle detection used:

```java
slow.data == fast.data
```

it could incorrectly report a cycle simply because two nodes contain `10`.

With:

```java
slow == fast
```

we're asking:

> "Are both references pointing to the exact same Node object?"

That's what cycle detection needs.

---

## 6. Why does Floyd's algorithm use `O(1)` extra space?

Because it only creates two references:

```java
Node slow = head;
Node fast = head;
```

It doesn't create:

- an array
- a HashSet
- a second linked list
- a list of visited nodes

Regardless of whether the linked list has:

```text
10 nodes
```

or:

```text
10,000,000 nodes
```

you still only have:

```text
slow
fast
```

Therefore:

**Extra space = O(1)**.

The nodes themselves don't count as extra space created by the algorithm—they already belong to the input list.

---

## 7. Can fast/slow work with only one node?

Yes.

Suppose:

```text
A → null
```

Initially:

```text
slow → A
fast → A
```

The loop condition is:

```java
fast != null && fast.next != null
```

Here:

```text
fast != null       → true
fast.next != null  → false
```

So the loop doesn't execute.

### For `middleNode()`

You immediately return:

```java
return slow;
```

which is A.

Correct—the only node is the middle.

### For `hasCycle()`

The loop doesn't execute, so:

```java
return false;
```

Correct, because:

```text
A → null
```

has no cycle.

If the single node pointed back to itself:

```text
A
↖
└───
```

then:

```text
A.next = A
```

and the loop would execute.

Both `slow` and `fast` remain at A:

```text
slow == fast
```

so the algorithm correctly detects the cycle.

---

# 🎤 Question of the Day

> **Why does moving one pointer twice as fast as another allow us to discover properties of a linked list without knowing its length?**

The important idea is **relative speed**.

Imagine you're walking along a road:

```text
You:     1 step/second
Friend:  2 steps/second
```

If you both start together, your friend will cover twice the distance you do.

So when your friend reaches the end, you must have traveled approximately **half the distance**.

That's exactly what happens with a linked list:

```text
slow:  → → → → →
fast:  → → → → → → → → → →
```

You don't need to know:

```text
"the list contains 20 nodes"
```

Instead, you use a **relationship between the pointers**.

### For the middle

Fast reaches the end after covering the whole distance.

Slow has covered half that distance.

Therefore:

```text
fast reaches end
        ↓
slow is near middle
```

### For a cycle

There's no real "end."

Instead, the structure loops:

```text
A → B → C → D
        ↑     ↓
        ← ← ←
```

Now fast keeps gaining on slow.

Because they're moving at different speeds **inside the same finite loop**, fast eventually catches slow.

```text
slow → C
fast → C

slow == fast
```

So the broader principle is:

> **You can learn something about an unknown structure by comparing the relative positions of things moving through it at different speeds.**

That's why you don't need the list's length first. **The structure itself causes the pointers' positions to reveal the information you want.**
