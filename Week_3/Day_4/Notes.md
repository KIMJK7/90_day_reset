A

Determine whether two values in a sorted array sum to K.
because its sorted array and we need to find sum of two values = k we will be using two pointer method

B

Find the maximum sum of exactly K consecutive elements.

we need to find max sum of fixed size k consecutive elements we will be using sliding window of size k.

C

Find the shortest contiguous subarray with sum ≥ K, where all numbers are positive.

all numbers are positive and we need to find sub array with a condition which means the window is not fixed so we will use a variable sliding window

D

Answer 10,000 range-sum queries on an immutable array.

we would simply create an array with size n+1 with all prefix sums which will take O(n) time sp we can query all 10,000 queries in O(1) time

E

Find an element in a sorted array.

to find element in a sorted array we could directly use binary search

F

Reverse an array in-place.

two pointer method so withoutcreating a new array we could just have left and right pointers intialized in 0 and n-1 respectively and we could switch values and come inwards

Don't code them.

Explain why you chose each pattern.

The Trap

Consider:

nums = [2, 3, -2, 4, 1]
target = 5

Someone says:

"Use the variable sliding-window technique from today."

Do you agree?

Don't immediately answer yes/no.

Explain whether the property that made our sliding window work still holds when negative numbers exist.

This is one of the most important questions today.

the reason why we would not using a variableb sliding window for arrays with negative numbers is because the basic mental modal for this technique is that as left or right pointers goes only forward never backward, cause when we increment right pointer we are increasing the window and sum as well once the condition is met then we start to shrink the window by moving left pointer forward potentially reducing the sum this is the basic idea but when we have negative numbers adding a number could reduce the sum where as removing a number could increase the sum .

Thinking Exercises

1.

Why can for + while still be O(n)?

left never moves backward
right++ -> sum increases
left++ -> sum decreases

an element in the array enters and leaves the array just once which makes the time complexity O(n)+O(n) -> O(n)

2.

What property of positive numbers makes the minimum-subarray sliding window work?

right++ -> sum increases
left++ -> sum decreases

3.

Why can't you blindly use the same technique with negative numbers?

wih -ve numbers it is possible when we add an element the sum can decrease and removing an element could increase the sum

4.

What is the tradeoff when using prefix sums?

its that if we dont using prefix sums time complexity - O(n) space complexity=O(1) but to queries 10,000s of question computation woould be more
with prefix sum initial tc-O(n) but queries tc-O(1) but space complexity O(n+1);

5.

If you have only one range-sum query, is building a prefix array necessarily useful?

Why?

no beacuse even tho prefix sum initial tc-O(n) but queries tc-O(1) but space complexity O(n+1); for just one queries its much better to just use a loop so tc- O(n) and SC- O(1)

6.

Why does:

prefix[right + 1] - prefix[left]

give the range sum?

Draw the numbers if necessary.

[2, 3, 1, 2, 4, 3 ] if we want to find sum(1,3) {sum(left,right)}
prefix Sum = [0 ,2 ,5 ,6 ,8 ,12 ,15]

prefix[right + 1] - prefix[left] = prefix[4] - prefix[1] = 8-2 = 6

sum = nums[1]+nums[2]+nums[3] = 3+1+2 = 6

this is equal because prefix[i+1] is simply sum of all previous elements which include nums[0]+..+nums[i]
