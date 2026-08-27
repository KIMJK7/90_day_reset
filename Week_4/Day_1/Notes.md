# Week 4 — Day 1

## Binary Search: Beyond "Find Target"

Week 3 was about learning the **core patterns**.

Week 4 changes the game.

You are no longer going to get:

> "Use binary search."

Instead, you'll get a problem and need to recognize **what exactly is searchable**.

Today we're going deeper into binary search.

---

# 🎯 Question of the Day

> **What exactly are we binary-searching?**

Most beginners think:

> "Binary search means searching for a number in a sorted array."

That's too narrow.

The deeper idea is:

> **Binary search works whenever the search space has a monotonic property that lets you eliminate half of the possibilities.**

The search space doesn't even have to be an array.

It can be:

```text
indices
values
answers
time
capacity
speed
minimum possible value
maximum possible value
```

Today we'll build toward **Binary Search on Answer**, which is one of the most important interview patterns.

# 🔥 Task 6 — Pattern Recognition

Don't code.

Identify whether each problem uses:

```text
Normal Binary Search
First/Last Occurrence Binary Search
Binary Search on Answer
Two Pointers
Sliding Window
HashMap
Stack
```

### A

Find `42` in:

```text
[1,5,8,12,20,42,50]
```

### B

Find the first occurrence of `7` in:

```text
[1,3,7,7,7,9]
```

### C

Find the minimum eating speed needed to finish piles within `h` hours.

### D

Find the minimum capacity required to ship packages within `D` days.

### E

Find two values in a sorted array that sum to target.

### F

Find the next greater element for every element.

Explain **why** for each.

---

# 🔥 Task 7 — Find the Mistake

What's wrong with this binary search?

```java
while (left <= right) {

    int mid = left + (right - left) / 2;

    if (nums[mid] == target) {
        answer = mid;
    }

    if (nums[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```

Suppose we're trying to find the **first occurrence**.

The problem is subtle.

Ask:

> After finding the target, what are we supposed to do?

if (nums[mid] == target) {
answer = mid;
right = mid-1;
}

---

# 🧠 Thinking Exercises

### 1.

Why can first occurrence require continuing binary search after finding the target?

### 2.

What's the difference between:

```text
"find target"
```

and:

```text
"find first position where condition becomes true"
```

?

### 3.

Why must the shipping capacity be at least:

```text
max(weights)
```

?

### 4.

Why is:

```text
sum(weights)
```

a valid upper bound?

### 5.

Why is the feasibility function monotonic?

### 6.

Why does binary search on answer still give O(log n)-style search even though we're not searching an array?

### 7.

For Koko, why is the search space:

```text
1 → max(piles)
```

?

### 8.

Why does increasing Koko's speed never make the problem harder?

That's the monotonic property.

---

## The main lesson today

Don't think:

> **Binary search = sorted array.**

Think:

> **Binary search = monotonic search space + ability to determine which side of the boundary contains the answer.**

Your mental model should become:

```text
                    Binary Search
                         │
             ┌───────────┴───────────┐
             ↓                       ↓
      Search positions         Search answers
             │                       │
       sorted array          capacity / speed
             │                       │
      first / last            feasibility
      occurrence              function
             │                       │
             └───────────┬───────────┘
                         ↓
                 Find the boundary
```
