# Task 5 — Complexity Comparison

Create this table in your notes:

| Algorithm     |    Best | Average |   Worst | Space |
| ------------- | ------: | ------: | ------: | ----: |
| Linear Search |    O(1) |    O(n) |    O(n) |  O(1) |
| Binary Search | O(logn) | O(logn) | O(logn) |  O(1) |

Then answer:

> Why isn't binary search always better than linear search?

Think carefully.

There are situations where linear search is the appropriate choice.

In an unsorted array it is better to use linear search than a binary search cause binary search is useful only in case were the search space is sorted and no duplicate values exixst, as we eliminate and halve the search space in every iteration based on mid value comparison

---

# 🔥 Task 6 — The Critical Question

Suppose someone says:

> "I'll use binary search on every array because O(log n) is better than O(n)."

Do you agree?

Explain **why or why not**.

Hint:

What does binary search require from the data?

And what happens if the array is:

```text
[40, 10, 80, 20, 5, 90]
```

?

binary search is only useful in case of a sorted array without any duplicate values, if in an array like:

```text
[40, 10, 80, 20, 5, 90]
```

if we need to search for 5,
left = 0
right = 5
mid = left + (right-left)/2
mid = 2
80 > 5
so,
left = 0 right = mid-1 = 1
[40,10]
it just just give not foound but we have 5 which is inncorect

---

# Task 7 — Duplicate Values

Now consider:

```text
[2, 4, 4, 4, 7, 9]
```

Search for:

```text
4
```

Your normal binary search can return **any one of the indices containing `4`**.

That's fine for today's basic search.

But now think:

> How could we modify binary search so that it always returns the **first occurrence** of the target?

Don't implement this yet.

Just write down your reasoning.

This is your first introduction to the idea that:

> **Binary search isn't just one algorithm. It's a pattern for shrinking a search space.**

We'll build on this later.

---

# 🧠 Complexity Challenge

Determine the complexity of:

```java
int i = 1;

while (i < n) {
    i *= 2;
}
```

You already answered this yesterday.

O(log n)
as i values multiplies by two 1,2,4,8,16,....
so for k iterations it will be
stoping criteria
2^k <= n
log both sides:
n = (log n)

Now answer:

```java
int i = n;

while (i > 1) {
    i /= 2;
}
```

n, n/2,n/4,n/8,n/16,....
for k iterations
n/2^k
stopping criteria:
n/2^k = 1
n = 2^k

log both sides:

k = log(n)

And:

```java
int i = n;

while (i > 0) {
    i--;
}
```

Explain **why**, not just the answer.

n,(n-1),(n-2),(n-3),...,(1)
simply be O(n)

---
