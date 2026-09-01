Absolutely. These are the concepts you should be able to explain **without looking at code**.

### 1. What question does a HashSet answer particularly well?

> **“Have I seen this value before?”**

It is mainly about **existence/membership**.

```text
Does 7 exist?
Have I already seen "abc"?
Is num - 1 present?
```

Typical operation:

```java
set.contains(x)
```

Average: **O(1)**.

---

### 2. What question does a HashMap answer particularly well?

> **“What information is associated with this key?”**

For example:

```text
value → index
value → frequency
key → list of values
prefixSum → frequency
```

You use:

```java
map.get(key)
```

when you need **information associated with something**.

---

### 3. Why does HashMap turn Two Sum into O(n) average time?

Without a HashMap, for every number you'd potentially search the rest of the array:

```text
1 → check everything after it
2 → check everything after it
3 → check everything after it
...
```

That's O(n²).

With a HashMap, as you scan:

```text
current = nums[i]
needed = target - current
```

you ask:

```java
map.containsKey(needed)
```

Average O(1).

So:

```text
n elements × O(1) lookup = O(n)
```

The key idea is:

> **Store what I've already seen so I can look up the complement instantly.**

---

### 4. Why does Subarray Sum Equals K require frequency, rather than just existence?

This is a **very important distinction**.

We use:

```text
prefixSum → frequency
```

because the **same prefix sum can occur multiple times**.

Remember:

```text
prefix[j] - prefix[i] = k
```

So when we're at `prefix[j]`, we need to know:

> **How many previous times have I seen `prefix[j] - k`?**

Each occurrence represents a different valid subarray.

If you only stored:

```text
prefixSum → true
```

you'd know that a valid prefix existed, but you'd lose **how many subarrays** it creates.

So:

> **Existence tells you whether there is a match. Frequency tells you how many matches there are.**

---

### 5. Why does `prefixSum → frequency` work even when the array contains negative numbers?

Because prefix sums don't require the array to be positive.

For example:

```text
nums = [2, -2, 2]
```

Prefix sums:

```text
0
2
0
2
```

They can go **up and down**.

The fundamental relationship:

```text
prefix[j] - prefix[i] = k
```

still works regardless of whether elements are positive, negative, or zero.

This is actually why prefix sum + HashMap is so useful: **sliding window generally relies on positivity, while prefix sums don't.**

---

### 6. What is a canonical key?

A **canonical key** is a standardized representation where things that should be considered equivalent produce the **same key**.

For example, anagrams:

```text
eat → aet
tea → aet
ate → aet
```

`"aet"` is their canonical representation.

So you can turn:

```text
different representation
        ↓
same canonical key
        ↓
same HashMap group
```

---

### 7. Why can Group Anagrams use sorted strings as keys?

Because anagrams contain exactly the same characters with the same frequencies.

Sorting puts those characters into the same order.

```text
eat → aet
tea → aet
ate → aet

tan → ant
nat → ant

bat → abt
```

Therefore:

```text
aet → [eat, tea, ate]
ant → [tan, nat]
abt → [bat]
```

The sorted string acts as the **canonical key**.

---

### 8. Why do we only start Longest Consecutive Sequence from a number where `num - 1` doesn't exist?

Because that tells us:

> **This number is the beginning of the sequence.**

For:

```text
1 2 3 4 5
```

Only `1` satisfies:

```java
!set.contains(1 - 1)
```

So we start from `1` and expand:

```text
1 → 2 → 3 → 4 → 5
```

If we also started from `2`, we'd unnecessarily traverse:

```text
2 → 3 → 4 → 5
```

And again from `3`:

```text
3 → 4 → 5
```

So the condition:

```java
!set.contains(num - 1)
```

prevents us from repeatedly processing the same sequence.

---

### 9. What's the difference between `value → index` and `value → frequency`?

They're answering **different questions**.

#### `value → index`

Answers:

> **“Where did I see this value?”**

Example:

```text
2 → 0
7 → 1
11 → 2
```

Useful for **Two Sum**.

---

#### `value → frequency`

Answers:

> **“How many times have I seen this value?”**

Example:

```text
2 → 3
7 → 1
11 → 2
```

Useful for:

- counting occurrences
- Subarray Sum Equals K
- frequency-based problems
- duplicate/anagram-related problems

The key distinction:

```text
index      = WHERE
frequency  = HOW MANY
```

That's worth memorizing.

---

### 10. Complete this sentence

> **I should reach for a HashMap when...**

I'd make your answer:

> **“I need to associate some value/key with information about it so I can retrieve that information quickly.”**

And then immediately ask yourself:

```text
What is my KEY?
What INFORMATION do I need to store?
```

For example:

| Problem         | Key                     | Value           |
| --------------- | ----------------------- | --------------- |
| Two Sum         | number                  | index           |
| Frequency Count | number/character        | frequency       |
| Subarray Sum K  | prefix sum              | frequency       |
| Group Anagrams  | canonical sorted string | list of strings |

### The bigger pattern

Don't memorize **“HashMap = use HashMap.”**

Instead recognize the question:

> **“I have something I've seen, and I need to quickly retrieve some information associated with it.”**

Then decide what you're storing:

```text
Need to know IF it exists?       → HashSet
Need to know WHERE it was?       → HashMap<value, index>
Need to know HOW MANY?            → HashMap<value, frequency>
Need to GROUP equivalent things? → HashMap<canonical key, List>
```

That's the actual pattern you're learning.
