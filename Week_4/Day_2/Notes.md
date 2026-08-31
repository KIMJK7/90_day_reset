You’re mostly right, but **#8 is wrong**, and there are a couple of places where your classification needs more precision.

### Check each one

1. **Maximum sum of exactly 5 consecutive elements**
   ✅ **Fixed-size sliding window**
   Window size is fixed at `5`.

2. **Longest substring without repeating characters**
   ✅ **Variable-size sliding window / two pointers**
   Your “two pointer in same direction” is the implementation style, but the **pattern** is better identified as **variable-size sliding window**.

3. **Minimum-length subarray with sum ≥ target, all numbers positive**
   ✅ **Variable-size sliding window**
   Because all numbers are positive, expanding/shrinking the window works.

4. **Two numbers in a sorted array sum to target**
   ✅ **Two pointers**
   Usually `left++` / `right--`.

5. **Two numbers in an unsorted array sum to target**
   ✅ **HashSet/HashMap**
   If you only need to know whether a pair exists, a **HashSet** is usually enough. HashMap is useful if you need indices/counts/mappings.

6. **100,000 range-sum queries**
   ✅ **Prefix sum**
   Build prefix sums once: `O(n)`, then each query is `O(1)`.

7. **First position where `nums[i] >= target`**
   ⚠️ Correct idea, but be more specific:
   - Sorted → **Binary search / lower bound**
   - Unsorted → **Linear search**

   This is specifically the **lower-bound binary search pattern** for the sorted case.

8. **Next greater element for each element**

   This is a **monotonic stack** problem.

   Example:
   `[2, 1, 2, 4, 3]`

   You maintain a stack whose elements/indices are arranged monotonically. When you encounter something larger, you can resolve the next-greater answer for elements on the stack.
