# Task 5 — Complexity Analysis

For each piece of code, determine the time complexity.

### A

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

O(n)
i -> 0, 1, 2,3, 4, 5,....,(n-1)
if it runs n times from 0 to (n-1)
i grows with n
O(n)

### B

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

outter loop runs n times;
inner loop runs n times for every i

for every i you perform n operations and for there are n values of i
n\*n = n^2
O(n^2);

### C

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}

for (int j = 0; j < n; j++) {
    System.out.println(j);
}
```

i runs n times and j iindipendent of i runs m times
n+n = 2n
O(2n) = O(n)

### D

```java
int i = 1;

while (i < n) {
    i *= 2;
}
```

i - 1,2,4,6,8,...,(n-1);

i = 2^k
stoping criteria is
2^k >= n
log both sides
k >= logn
therefore, time complexity O(logn);

### E

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < 10; j++) {

        System.out.println(i + j);

    }
}
```

for every i , j runs 1o times
and there are n values of i
so, n\*10 = 10n
time complexity O(10n) = O(n)

### F

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < i; j++) {

        System.out.println(i + j);

    }
}
```

iteration of loop j depends on i
i=0 j iterates 0
i=1 j iterates 1 time
i=2 j iterates 2 time
...

i=(n-1) j iterates (n-1) time

this makes arithemetic series
0+1+2+3+...+(n-1) = n(n-1)/2;
simplify we get ((n^2)/2 - n/2 )
time complexity - O(n^2);

---

# 🧠 Thinking Exercises

Answer these **without coding**.

### 1.

Why is:

```java
arr[500]
```

O(1), even if the array contains one million elements?

this is because we dont have to traverse the entire array to reach arr[500], it just internally calculates the taget addr of the array element using the base addr and index + size of one element
eg. if base addr (arr[0]) = 100 and its and int array meaning byte size of one element in array is 4 bytes
it internally, target addr = base addr + (size of one element \* index of target element);
this could be done because in memory array id stored as a continues memory block

### 2.

Why is searching an unsorted array O(n)?

searching an unsorted array is O(n) bacausewe would need to traverse all th eelements to search for match of the target element in best case the first element could be the element in question but in worst case the last elemnt might be the one to be found or the element might not be presnt at all.

### 3.

Why is inserting at index `0` O(n)?

lets say we have an array {10,15,20,25}
now we need to insert elemnt 5 at arr[0];
so that now array should look like {5,10,15,20,25};
to do so we woul dneed to shift all existing elemnts to right i+1 position which woul drequire us to traverse the entire array

### 4.

Can an algorithm have:

```text
O(n) time
O(1) space
```

?

Give an example.

yes they can inserting at begining, insertion in middle, deletion at begining,deletion in middle, traversing an array etc

### 5.

Can an algorithm have:

```text
O(n²) time
O(1) space
```

?

Give an example.

searching elemnets in a 2d array,printing a 2d array

### 6.

Why is this:

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < 10; j++) {
    }
}
```

O(n), not O(n²)?

that is because for every i j runs 10 times which is constant and we have n vales of i
so , n\*10 = 10n
which makes time complexity O(10n) = O(n)

---

# 🔥 Important Challenge

Don't memorize this:

> "Two nested loops means O(n²)."

Consider:

```java
int j = 0;

for (int i = 0; i < n; i++) {

    while (j < n) {
        j++;
    }
}
```

What is the complexity?

It **looks** like nested loops.

But is it actually O(n²)?

**Figure it out.**

i = 0 ,j = 0 (j < n) yes j++;
j = 1(j < n) yes j++;
j = 2(j < n) yes j++;
.....
j = n-1 (j < n) yes j++;
j = n (j< n) no

i = 1, j = n (j< n) no
i = 2, j = n (j< n) no
...
i(n-1), j = n (j< n) no

loop for j only runs once for n iteration ,for every other i loop iteration it doesmot not iterate
time complexity O(n+n) -> O(2n) -> O(n)

---
