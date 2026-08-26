# PART 1 — No Notes Warm-Up

Before opening your notes, answer these from memory.

### 1. Arrays

Why is:

```java
arr[i]
```

O(1)?

arr[i] is O(1) because array elemnets are stored in a contineous block of memory in heap and we dont need to travese the enntire array to determine value at i , internally they perform a simple operation to determine memory location

> target addr = base addr +(i\*size of element)

---

### 2. Binary Search

What property of the input allows binary search to eliminate half the search space?

input array is a sorted array which allows binary search to eleminate half the search space, what it does is
calculate mid = left + (right - left)/2 and matches the target value with the mid to elimitate half of the search space

---

### 3. Two Pointers

Why does this work on a sorted array?

```java
while (left < right) {
    int sum = nums[left] + nums[right];

    if (sum == target) ...
    else if (sum < target) left++;
    else right--;
}
```

this works for a sorted array cause we know that elements in input array are in acending order , if sum of right and left is less than target we can move left pointer cause left-- would only result in sum even smaller than the one we have and similarly in case that target is smaller than sum we right--

---

### 4. Sliding Window

Why can this:

```java
for (...) {
    while (...) {
        ...
    }
}
```

still be O(n)?

this is because each element enters and leaves the loop just once, left donesnot move backwards, right also does not move backwards so we travese the loop just once.

---

### 5. Prefix Sum

Why can:

```text
prefix[right + 1] - prefix[left]
```

answer a range-sum query in O(1)?

---

when we create prefix sum array we create an array with size n+1 which contains all the previous element sum,so when we query any sum(left,right) we could simply perform: prefix[right + 1] - prefix[left] to get the value required we dont have to travese the array. which makes it O(1).

### 6. HashMap

Why is:

```java
map.get(key)
```

average O(1)?

And why did we say **average**, not guaranteed?

Conceptually:

> key
> ↓
> hashCode()
> ↓
> hash
> ↓
> bucket index
> ↓
> go directly to that bucket
> ↓
> find matching key within bucket

That's why lookup can be O(1) average.

It's average rather than guaranteed because collisions can put multiple keys into the same bucket, requiring additional work.

---

### 7. Stack

Why is a stack the natural structure for:

```text
{ [ ( ) ] }
```

?

for valid parathesis stack is teh natural data structure cause, stack focus on most recent unresolved item, so when we see a closing bracket and check top of the stack if its the opening bracket we can simply pop cause we resolved the item.

---

### 8. Monotonic Stack

What exactly does the stack represent in the Next Greater Element problem?

Don't say:

> "It stores previous elements."

That's incomplete.

in next greatest element problem stack store the unresolved indices of the element in array which havent found elemnt greater to them yet.

---

# PART 2 — Pattern Recognition Test

**Do not code these yet.**

For each problem, identify the best starting technique.

Possible answers:

```text
Array traversal
Binary Search
Two Pointers
Fixed Sliding Window
Variable Sliding Window
Prefix Sum
HashSet
HashMap
Stack
Monotonic Stack
```

---

### Problem 1

Given an array, determine whether any value occurs twice.

**Your choice:** ?

**Why:** ?

i would use a HashSet for this as we just need to keep track of elements present in array and if this element was previously present in set.

---

### Problem 2

Given a sorted array, determine whether two values sum to `target`.

**Your choice:** ?

**Why:** ?

we can use two pointer method,because array is sorted we can say if sum of nums[left] + nums[right], sum>target ->right--; sum< target ->left++

---

### Problem 3

Given an array and `k`, find the maximum sum of exactly `k` consecutive elements.

**Your choice:** ?

**Why:** ?

sliding window fixed size of k we can simply have sum of k elements and move window forward remove old element add new element

---

### Problem 4

Given positive integers, find the minimum-length contiguous subarray whose sum is at least `target`.

**Your choice:** ?

**Why:** ?

variable sized window, we dont know the size of the window but we know that input array is all positive elements so we know that when we subtract any element sum will reduce and if we add any element sum will increase.

---

### Problem 5

Given an immutable array and 50,000 range-sum queries.

**Your choice:** ?

**Why:** ?

prefix sum , as we have 50,00 range-sum queries we could do them in O(1) if we use prefix sum array whose initial implemnetation is O(n) but when we querie sum(left,right) it will be in time compolexity O(1)

---

### Problem 6

Given an unsorted array, find two values whose sum equals `target`.

**Your choice:** ?

**Why:** ?

HashMap, because array is unsorted we cannot simply use two pointer, what we can do is target-num[i] = x, have we seen thisx before search in hashmap yes and the value of key x is its index, return[map.get(x),i];

---

### Problem 7

Given a sorted array, find a target value.

**Your choice:** ?

**Why:** ?

Binary search, because array is sorted we would use binary search to elimitate and reduce search space and find the target

---

### Problem 8

Determine whether brackets are balanced.

```text
"[{()}]"
```

**Your choice:** ?

**Why:** ?

Stack because its LIFO, it resolves the latest unresolved item

---

### Problem 9

For every element, find the next greater element to its right.

**Your choice:** ?

**Why:** ?

Queue data structure cause its FIFO, it resolves the oldest unresolved item first

---

### Problem 10

Reverse an array in-place.

**Your choice:** ?

**Why:** ?

Two pointer, we can simply have two pointer left and right and interchange their values and move the pointer inwards

---

# PART 3 — Complexity Test

Determine the complexity **without running the code**.

### A

```java
for (int i = 0; i < n; i++) {
    System.out.println(nums[i]);
}
```

Time:O(n)
Space:O(1)

---

### B

```java
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        System.out.println(nums[i] + nums[j]);
    }
}
```

i j
0 1-(n-1)
1 2-(n-1)
3 4-(n-1)
... ...
n-1 0

Time:O(n^2)
Space:O(1)

---

### C

```java
int i = 1;

while (i < n) {
    i *= 2;
}
```

i = n ,n/2,n/4,n/8,n/16....
1 = n/2^k
log both side
n = 2^k
log n = k

O(log(n))

Time:O(log(n))
Space:O(1)

---

### D

```java
int i = n;

while (i > 1) {
    i /= 2;
}
```

Time:O(log(n))
Space:O(1)

---

### E

```java
HashSet<Integer> set = new HashSet<>();

for (int x : nums) {
    if (set.contains(x)) {
        return true;
    }

    set.add(x);
}
```

Time:O(n)
Space:O(n)

Give:

```text
Time:
Space:
```

---

### F

```java
int left = 0;
int right = nums.length - 1;

while (left < right) {

    if (nums[left] + nums[right] == target) {
        return true;
    }

    if (nums[left] + nums[right] < target) {
        left++;
    } else {
        right--;
    }
}
```

Give:

```text
Time: O(n)
Space:O(1)
```

---

# PART 4 — Algorithm Reconstruction

This is important.

I'm deliberately **not giving you the algorithm names**.

## Problem A

Given:

```text
[2, 7, 11, 15]
```

find two numbers that sum to:

```text
9
```

The array is **not sorted**.

You need to return their indices.

### Requirements

```text
O(n) average time
O(n) space
```

Write the algorithm from scratch.

---

# Problem B

Given:

```text
[2, 1, 5, 2, 3, 2]
```

find the minimum-length contiguous subarray with sum ≥ `7`.

All numbers are positive.

Requirements:

```text
O(n)
O(1) extra space
```

Write it from scratch.

---

# Problem C

Given:

```text
[2, 1, 2, 4, 3]
```

return:

```text
[4, 2, 4, -1, -1]
```

Write the algorithm from scratch.

Don't look at your Day 6 implementation.

---

# PART 5 — Debugging Assessment

Find the logical error.

```java
static boolean pairSum(int[] nums, int target) {

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {

        int sum = nums[left] + nums[right];

        if (sum == target) {
            return true;
        }

        if (sum < target) {
            right--;
        } else {
            left++;
        }
    }

    return false;
}
```

Assume:

```text
nums = [1, 2, 4, 6, 8, 9]
target = 10
```

The code is wrong.

**Don't just fix it. Explain the reasoning error.**

The important question is:

> When the sum is too small, which pointer movement gives us the possibility of increasing the sum?

```java
if (sum < target) {
            right--;
        } else {
            left++;
        }
```

this condition is not true because in a sorted array to find sum of two numbers if we have sum < target and we do right--;
this reduces the sum even further cause array is alreay in acending order so if we do right--; if the sum was x we just subtracted y from it making x-y < x whixh is not ideal simplary in case sum > target

---

# PART 6 — Design Questions

These are more important than the coding exercises.

### Question 1

You have:

```text
[1, 2, 3, 4, 5, 6]
```

and need to answer:

> "What is the sum from index `1` to `4`?"

Once.

Would you necessarily build a prefix array?

Why?

if its just one query it is much prefered to not create a prefix array cause it would be ideal to trade off memory for faster computation if we have 1000+ queries but just for one query with tc - O(n) sc - O(1) would be ideal.

---

### Question 2

You have the same array but now:

> 1,000,000 range-sum queries.

Does your answer change?

Why?

now we can create a prefix sum array initial tc - O(n) ans sc- O(n) but computation queries tc -O(1) which is munch fater

---

### Question 3

You need to find duplicates.

You can either:

```text
sort + scan
```

or:

```text
HashSet
```

Which one would you choose if you need to preserve the original array order?

Why?

to preserve the original order i would prefer hashset, cause even tho we would have sc-O(n) but we would be able to see if there are duplicates in array much faster in O(n) time rather than sorting with O(nlog n) then traversing the array(O(n)) and not preserving the order of original array

---

### Question 4

Why doesn't variable-size sliding window automatically work for:

```text
[2, -1, 4, -2, 5]
```

?

Be precise.

due to negative values sliding window works only for positive values because when we add a positive number to existing sum the sum increase and if we remove positive numver from a sum the sum decreases but in case of negative numbers there are chances that adding an element might decrese the sum and removing an element might increase the sum

---

### Question 5

You need to repeatedly ask:

> "Have I seen this exact value before?"

Would you choose:

```text
HashMap
```

or:

```text
HashSet
```

Why?

if its just have i seen this value before i would use HashSet and if we require to see the frequency of an element i would use HashMap

---

---
