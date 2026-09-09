## 1. Why does an unsorted Two Sum naturally suggest a HashMap?

Suppose:

```text
nums = [2, 7, 11, 15]
target = 9
```

For every number `x`, you need:

```text
target - x
```

For `2`, you need `7`.

The problem is: **how do I quickly know whether 7 exists?**

If the array is unsorted, you don't have any useful ordering information.

You could search for `7`:

```text
2 → 7 → 11 → 15
```

But doing that for every element gives `O(n²)`.

A HashMap gives you approximately:

```text
"Have I seen the number I need?"
```

in `O(1)` average time.

So you iterate:

```text
x = 2
need = 9 - 2 = 7
7 not seen
store 2

x = 7
need = 9 - 7 = 2
2 seen!
```

### The deeper pattern

**Unsorted + need fast existence/complement lookup → HashMap/HashSet**

You're using the HashMap to create information that the array itself doesn't provide.

---

# 2. Why does a sorted Two Sum naturally suggest two pointers?

Now imagine:

```text
[1, 2, 3, 4, 6, 8]
target = 10
```

Because the array is sorted, you have a powerful property:

```text
left → smaller numbers
right → larger numbers
```

Start:

```text
1 + 8 = 9
```

Too small.

Because the array is sorted, you **know**:

```text
1 + anything <= 1 + 8
```

So keeping `1` cannot produce 10.

Therefore:

```text
left++
```

Now:

```text
2 + 8 = 10
```

Done.

If instead:

```text
4 + 8 = 12
```

it's too large.

Because `8` is already the largest remaining number, keeping `8` cannot make the sum smaller except by moving `right` left.

So:

```text
right--
```

### The deeper pattern

Sorting gives you **directional information**.

You don't need a HashMap because the ordering lets you eliminate an entire class of possibilities at every step.

That's why:

> **Sorted + monotonic relationship → two pointers**

---

# 3. Why is ordinary sliding window unsafe for Subarray Sum Equals K when negative numbers are allowed?

This is extremely important.

Sliding window generally depends on this assumption:

> If my current sum is too large, removing elements from the left will make it smaller.

That is true when numbers are **non-negative**.

Example:

```text
[1, 2, 3, 4]
```

Current window:

```text
1 + 2 + 3 = 6
```

If `K = 5`, sum is too large.

Remove `1`:

```text
2 + 3 = 5
```

Great.

But now allow negatives:

```text
[1, 4, -3, 2]
K = 3
```

Suppose your window sum is too large.

Removing something from the left doesn't necessarily behave in the way you expect.

More importantly, **expanding the window can decrease the sum**:

```text
1 + 4 = 5

add -3

1 + 4 - 3 = 2
```

So the sum isn't monotonic.

You lose the fundamental sliding-window property:

```text
expand → sum increases
shrink → sum decreases
```

With negative numbers:

```text
expand → could increase OR decrease
shrink → could increase OR decrease
```

Therefore you can't reliably decide which pointer to move based solely on whether the sum is `< K` or `> K`.

### The deeper pattern

Sliding window works when there is some **monotonic behavior** that lets you safely discard possibilities.

Negative numbers destroy that monotonicity.

---

# 4. Why does Prefix Sum + HashMap work even with negative numbers?

This is the beautiful part.

Suppose:

```text
nums = [1, 2, 3, -2, 4]
K = 3
```

Define:

```text
prefix[i] = sum of everything up to i
```

Suppose your current prefix sum is:

```text
currentSum
```

You want some previous prefix sum:

```text
previousSum
```

such that:

```text
currentSum - previousSum = K
```

Rearrange:

```text
previousSum = currentSum - K
```

That's the entire trick.

You don't care whether the numbers are positive, negative, or zero.

You simply ask:

> **Have I previously seen a prefix sum equal to `currentSum - K`?**

HashMap makes that lookup fast.

For example:

```text
K = 3

currentSum = 6
need previousSum = 6 - 3
                    = 3
```

If prefix sum `3` occurred earlier, then everything between that earlier point and now sums to `3`.

### Why negatives don't matter

Prefix sums don't require monotonicity.

They can do:

```text
1
3
6
4
8
```

That's completely fine.

We're not saying:

> "The sum must increase."

We're simply using an **equation**:

```text
currentPrefix - oldPrefix = K
```

### The deeper pattern

When sliding window fails because there is no monotonicity, ask:

> **Can I express the condition as a relationship between two prefix states?**

If yes:

```text
prefix sum + HashMap
```

is often the answer.

---

# 5. Why can Search in Rotated Sorted Array still be `O(log n)`?

At first glance, rotation seems to destroy binary search.

For example:

```text
[4, 5, 6, 7, 0, 1, 2]
```

The entire array isn't sorted.

But here's the crucial observation:

> **At least one half of the array is always sorted.**

Take:

```text
        mid
         ↓
[4, 5, 6, 7, 0, 1, 2]
 ↑        ↑           ↑
left                  right
```

Left half:

```text
[4, 5, 6, 7]
```

is sorted.

Or in another configuration:

```text
[6, 7, 0, 1, 2, 4, 5]
         ↑
        mid
```

Right half:

```text
[1, 2, 4, 5]
```

is sorted.

Once you identify the sorted half, you can ask:

> **Can the target exist inside this sorted range?**

If yes, eliminate the other half.

If no, eliminate the sorted half.

Therefore each iteration still eliminates roughly half of the remaining search space.

```text
n
↓
n/2
↓
n/4
↓
n/8
↓
...
```

Therefore:

```text
O(log n)
```

### The deeper pattern

Binary search doesn't fundamentally require:

> "The entire array is sorted."

What it really requires is:

> **Enough structure to safely eliminate a large portion of the search space.**

That's why rotated binary search still works.

---

# 6. Why does interval scheduling sort by END time, while Merge Intervals sorts by START time?

This is the most important one.

They look similar because both involve intervals:

```text
[start, end]
```

But they are solving **different problems**.

And therefore they need **different information exposed by sorting**.

---

## Interval Scheduling / Erase Overlap Intervals

The problem is essentially:

> Pick as many non-overlapping intervals as possible.

Example:

```text
[1,3]
[2,4]
[3,5]
[5,7]
```

Suppose you've already selected an interval.

The question becomes:

> **Which interval should I choose next?**

You want to leave yourself the **maximum amount of room for future intervals**.

Consider:

```text
A = [1, 10]
B = [2, 3]
C = [3, 4]
D = [4, 5]
```

If you choose A:

```text
[1-----------10]
```

you're basically screwed. You can't choose B, C, or D.

But if you choose B:

```text
   [2-3]
```

you leave lots of room afterward.

So the greedy rule is:

> **Choose the interval that finishes earliest.**

That's why:

```java
Arrays.sort(intervals,
    (a, b) -> Integer.compare(a[1], b[1]));
```

Sorting by **end time** exposes the information you need:

```text
"Which interval gets out of the way earliest?"
```

And that is exactly what the greedy decision needs.

---

# Merge Intervals

Completely different question.

Now you're not trying to maximize how many intervals you keep.

You're trying to:

> **Combine overlapping intervals.**

Example:

```text
[1,3]
[2,6]
[8,10]
[9,12]
```

The natural question is:

> **What interval comes next from left to right?**

If intervals are sorted by start:

```text
[1,3]
[2,6]
[8,10]
[9,12]
```

you know that when you're processing:

```text
[1,3]
```

the next interval begins at:

```text
2
```

Since:

```text
2 <= currentEnd(3)
```

they overlap.

So merge:

```text
[1,6]
```

Then look at:

```text
[8,10]
```

Since:

```text
8 > 6
```

there's a gap.

Start a new interval.

### What does start-time sorting expose?

It gives you:

> **A left-to-right ordering of intervals.**

Therefore, when processing interval `i`, you know that no interval with a later start has been skipped.

That's exactly the information needed to merge overlapping ranges.

---

# The key distinction

This is the part I want you to internalize:

| Problem             | What decision are we making?  | What information do we need? | Sort by       |
| ------------------- | ----------------------------- | ---------------------------- | ------------- |
| Two Sum unsorted    | Find complement               | Fast lookup                  | HashMap       |
| Two Sum sorted      | Move toward target            | Ordering                     | Two pointers  |
| Subarray Sum K      | Find previous compatible sum  | Prefix relationship          | HashMap       |
| Rotated Search      | Eliminate half                | One sorted half              | Binary search |
| Interval Scheduling | Which interval should I keep? | Earliest finishing interval  | **End**       |
| Merge Intervals     | Which interval comes next?    | Left-to-right ordering       | **Start**     |

### And here's the general rule:

**Don't ask:**

> "What is the standard sorting order for this problem?"

Ask:

> **"What decision am I trying to make, and what ordering exposes the information needed to make that decision?"**

For **interval scheduling**, the critical question is:

> _Which candidate frees my timeline earliest?_

→ **sort by END**

For **merge intervals**, the critical question is:

> _What interval starts next as I sweep from left to right?_

→ **sort by START**

That's the difference between **memorizing an algorithm** and actually understanding why the algorithm exists.

>                     What does the problem ask?
>                               |
>               +---------------+----------------+
>               |                                |
>           contiguous?                       pair?
>               |                                |
>              YES                              YES
>               |                                |
>        fixed-size window?              Is it sorted?
>           /          \                  /          \
>         YES          NO               YES          NO
>          |            |                |             |
>
> fixed window sliding window two pointers HashMap
> |
> Is condition monotonic?
> / \
>  YES NO
> | |
> sliding window prefix sum /
> HashMap

> sorted / monotonic search space
> ↓
> Binary Search

> ranges / start-end
> ↓
> Intervals
> ↓
> Sort

> maximize / minimize
> ↓
> Can I safely commit to a local choice?
> ↓
> Greedy

> "have I seen this?"
> ↓
> HashSet

> key → information
> ↓
> HashMap
