## 1. Why not simply reverse the values?

Suppose:

```text
A(10) → B(20) → C(30)
```

You could swap the values:

```text
A(30) → B(20) → C(10)
```

Visually, yes, you'd get the same sequence:

```text
30 → 20 → 10
```

But the **nodes themselves haven't moved**. Their links haven't changed.

That's a problem when the nodes carry meaning beyond just `data`.

For example, if some other part of your program has:

```java
Node x = nodeA;
```

and you reverse by values, `x` still refers to the same node A—it just contains different data.

With actual link reversal:

```text
Before:

A → B → C

After:

C → B → A
```

the **structure and node identities are reversed**.

So:

> Reversing values changes the contents of nodes. Reversing links changes the actual structure of the linked list.

For a simple integer-only exercise, value swapping may _look_ equivalent, but it is not a true linked-list reversal.

---

## 2. Why does iterative reversal require `O(1)` extra space?

Because we only create a fixed number of references:

```java
Node prev;
Node current;
Node next;
```

Whether the list has 5 nodes or 5 million nodes, we still need only these three references.

We aren't creating another list or storing all the nodes somewhere.

Therefore:

**Space = O(1)**

The list itself is not counted as extra space because it's the input we're modifying.

---

## 3. Why does recursive reversal require `O(n)` stack space?

Recursion creates a **stack frame for every recursive call**.

For:

```text
A → B → C → D
```

you might have:

```text
reverse(A)
    ↓
reverse(B)
    ↓
reverse(C)
    ↓
reverse(D)
```

Before the deepest call finishes, all the previous calls are still sitting on the call stack.

For `n` nodes, there can be approximately `n` active calls.

Therefore:

**Space = O(n)**

This is the important difference:

```text
Iterative → O(1) auxiliary space
Recursive → O(n) call-stack space
```

---

## 4. During iterative reversal, what exactly does `prev` represent?

Precise definition:

> **`prev` points to the first node of the portion of the list that has already been reversed.**

For example:

```text
null ← 10 ← 20       30 → 40 → 50
        ↑             ↑
       prev         current
```

The portion:

```text
10 ← 20
```

has already been reversed.

`prev` points to its new head:

```text
prev → 20 → 10 → null
```

So `prev` represents the **boundary/head of the reversed portion**.

---

## 5. What exactly does `current` represent?

> **`current` points to the first node of the portion of the list that has not yet been reversed.**

For example:

```text
null ← 10 ← 20       30 → 40 → 50
        ↑             ↑
       prev         current
```

Everything before `current` has been processed.

Everything starting at `current` is still unprocessed.

So you can think of the list as being divided into two regions:

```text
     REVERSED             UNPROCESSED
         ↓                    ↓
null ← 10 ← 20       30 → 40 → 50
                     ↑
                   current
```

That's a very useful mental model.

---

## 6. Why save `next` before changing `current.next`?

This is **the most important pointer-safety rule** in reversal.

Suppose:

```text
current
   ↓
   A → B → C → D
```

You want A to point backward:

```java
current.next = prev;
```

After doing that, A no longer points to B.

You've just changed:

```text
A → B
```

into:

```text
A → prev
```

So if you hadn't saved B beforehand, you've **lost your path to the remaining list**.

That's why:

```java
next = current.next;
```

must happen first.

Then:

```java
current.next = prev;
```

Now you have:

```text
next → B → C → D

prev ← A
```

You can safely move forward:

```java
prev = current;
current = next;
```

So the sequence is:

```text
1. Save the future
2. Reverse the current link
3. Move prev
4. Move current
```

---

## 7. Why does recursive reversal do the rewiring while calls are unwinding?

Consider:

```text
A → B → C → D → null
```

The recursive function keeps going forward:

```text
reverse(A)
    ↓
reverse(B)
    ↓
reverse(C)
    ↓
reverse(D)
```

At D, there's nothing left to reverse.

So D becomes the new head.

Then the recursion starts **returning backward**.

At the C level, you now know that D is the end of the reversed portion.

You can make:

```text
D.next = C
```

giving:

```text
D → C
```

Then when returning to B:

```text
C.next = B
```

giving:

```text
D → C → B
```

Then A:

```text
B.next = A
```

giving:

```text
D → C → B → A
```

So the recursion goes:

```text
GO DOWN:
A → B → C → D

COME BACK:
D → C → B → A
```

The pointer rewiring happens during the **unwinding phase** because that's when the recursive call has returned the reversed remainder to the current node.

---

# 🎤 Question of the Day

> **Why do we need three references instead of just two?**

Because each reference has a different job.

Suppose:

```text
prev ← A       B → C → D
               ↑
             current
```

We need to accomplish three things:

### 1. Preserve the unprocessed list

Before changing:

```text
B → C
```

we need to remember C:

```java
next = current.next;
```

Otherwise, changing `current.next` could disconnect us from C → D.

### 2. Reverse the current link

```java
current.next = prev;
```

Now:

```text
A ← B
```

instead of:

```text
A → B
```

### 3. Move forward

After reversing B, we need:

```java
prev = current;
current = next;
```

So the three references have distinct responsibilities:

```text
prev    → already reversed portion
current → node currently being reversed
next    → saved remainder of the list
```

The whole algorithm can therefore be understood as:

```text
             next
              ↓
prev ← current → remaining
  ↑       ↑
  │       │
already   │
reversed  │
       reverse this
       connection
```

Then:

```text
next = current.next
current.next = prev
prev = current
current = next
```

### The deepest idea

You're essentially **moving the boundary between two regions**:

```text
BEFORE:

[ already reversed ] [ not yet reversed ]
        prev                current
```

After one iteration:

```text
[ already reversed + current ] [ remainder ]
              prev                current
```

And you repeat until:

```text
[ entire list reversed ] [ empty ]
                            current = null
```

At that point:

```text
prev
 ↓
D → C → B → A → null
```

So `prev` becomes the new head.

**That's the heart of iterative linked-list reversal: preserve the future, reverse the present, then advance the boundary.**
