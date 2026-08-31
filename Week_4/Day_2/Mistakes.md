# Your mistakes compiled into one table

| Problem              | Your mistake                          | What you should have asked                                  |
| -------------------- | ------------------------------------- | ----------------------------------------------------------- |
| Longest Substring    | Compared `s[left]` with `s[right]`    | Does `s[right]` exist **anywhere in the window**?           |
| Longest Substring    | `left = right`                        | How far do I actually need to shrink?                       |
| Longest Substring    | Didn't track window contents          | What state defines a valid window?                          |
| Max Consecutive Ones | Used `nums.length - left + 1`         | What are my actual window boundaries?                       |
| Max Consecutive Ones | Initially counted individual elements | How many valid windows/subarrays does this state represent? |
| Product < K          | Counted `1` for each valid window     | How many valid subarrays **end at right**?                  |
| Product < K          | Used `if` to shrink                   | Do I need to shrink once or until valid?                    |
| Anagrams             | Checked only `containsKey`            | Do the **frequencies** match?                               |
| Anagrams             | Used `i < right`                      | Is `right` included in my window?                           |
| Anagrams             | `right += k-1`                        | Am I moving the window by exactly one?                      |
| Anagrams             | Rebuilt map every time                | What leaves and what enters when I slide?                   |
| Divisible by K       | Didn't use frequency to count         | How many previous prefixes have this remainder?             |
| Divisible by K       | Overwrote map frequency               | Am I incrementing or resetting the frequency?               |

---

# The sliding-window framework you should now use

When you see a problem that looks like sliding window, **don't immediately write `left` and `right`.**

Stop and answer these five questions.

### 1. What does my window represent?

For example:

```text
Longest Substring:
[left...right] has no duplicate characters

Max Ones:
[left...right] has <= k zeros

Product:
[left...right] has product < k

Anagrams:
[left...right] has exactly p.length() characters
```

---

### 2. What makes the window invalid?

```text
Longest substring:
duplicate character

Max Ones:
zero > k

Product:
product >= k

Anagrams:
frequency != p's frequency
```

This is probably the **single most important question** for you.

---

### 3. What state do I need to track?

Don't automatically use a HashMap.

Ask what information is actually necessary.

```text
Longest substring → HashSet of characters

Max Ones → count of zeros

Product → product

Anagrams → character frequencies

Divisible by K → prefix remainder frequencies
```

This is a major improvement you've already started making.

---

### 4. How do I repair an invalid window?

Usually:

```text
while(window is invalid) {
    remove nums[left]
    left++;
}
```

Notice:

### `while`, not automatically `if`.

You're asking:

> "Do I need to keep shrinking until the invariant is restored?"

If yes → `while`.

---

### 5. What exactly am I counting?

This is where your Product problem exposed an important distinction.

Sometimes you're looking for:

```text
maximum window length
```

Then:

```java
maxLen = Math.max(maxLen, right - left + 1);
```

Sometimes you're counting **all valid subarrays**.

Then you might get:

```java
count += right - left + 1;
```

Sometimes you're looking for **matching windows**:

```java
if(windowMap.equals(targetMap))
    ans.add(left);
```

Don't use `count++` automatically.

Ask:

> **"How many things does this current window represent?"**

---

# The most important distinction: 3 types you've encountered

You've now touched three related but different patterns.

## Type A — Longest valid window

Example:

```text
Longest Substring
Longest Ones
```

Pattern:

```text
expand
↓
invalid?
↓
shrink
↓
measure window
↓
keep maximum
```

Usually:

```java
maxLen = Math.max(maxLen, right - left + 1);
```

---

## Type B — Count all valid subarrays

Example:

```text
Product < K
```

Pattern:

```text
expand
↓
shrink until valid
↓
count ALL valid endings at right
```

Usually:

```java
count += right - left + 1;
```

This is a very important pattern for you.

---

## Type C — Fixed-size matching window

Example:

```text
Find Anagrams
```

Pattern:

```text
window size = k
↓
add right
↓
remove left
↓
compare state
↓
slide by 1
```

The window **always has exactly `k` elements**.

---

## Type D — Prefix Sum + Frequency

Example:

```text
Subarrays Divisible by K
```

No traditional sliding window.

Instead:

```text
prefix sum
↓
remainder
↓
previous same remainder?
↓
frequency tells number of valid subarrays
```

---

# Your biggest improvement so far

I want you to notice something.

Your first Longest Substring attempt was essentially:

```text
right vs left
```

Then Max Ones became:

```text
right → modify state
left → repair state
```

Then Product became:

```text
right → modify state
left → repair state
       ↓
count ALL possibilities
```

Then Anagrams became:

```text
fixed-size window
       ↓
frequency state
       ↓
remove outgoing + add incoming
```

And Divisible by K became:

```text
prefix state
       ↓
frequency of equivalent states
       ↓
count previous occurrences
```

So you're not randomly making mistakes.

You're actually **building the pattern layer by layer**.

Your main weakness is that you sometimes start coding **before defining the invariant**.

---

# Your new pre-code checklist

Before writing a single line of Java, write this on paper:

```text
WINDOW:
What does [left...right] represent?

INVALID:
What makes it invalid?

STATE:
What do I need to remember?

SHRINK:
When do I move left?
Do I need while or if?

ANSWER:
What exactly am I counting/measuring?

MOVEMENT:
Does right move 1 at a time?
Is this fixed-size?
```

For example, for Anagrams:

```text
WINDOW:
exactly k characters

INVALID:
frequency doesn't match p

STATE:
frequency map

SHRINK:
when window > k, remove left

ANSWER:
if frequencies match → add left

MOVEMENT:
right + 1, left + 1
```

For Product:

```text
WINDOW:
subarray [left...right]

INVALID:
product >= k

STATE:
product

SHRINK:
while product >= k

ANSWER:
right - left + 1

MOVEMENT:
right + 1
```

For Longest Substring:

```text
WINDOW:
substring with unique characters

INVALID:
duplicate

STATE:
HashSet

SHRINK:
while duplicate exists

ANSWER:
max(right - left + 1)

MOVEMENT:
right + 1
```
