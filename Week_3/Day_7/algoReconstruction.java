package Week_3.Day_7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class algoReconstruction {
    // # PART 4 — Algorithm Reconstruction

    // This is important.

    // I'm deliberately **not giving you the algorithm names**.

    // ## Problem A

    // Given:

    // ```text
    // [2, 7, 11, 15]
    // ```

    // find two numbers that sum to:

    // ```text
    // 9
    // ```

    // The array is **not sorted**.

    // You need to return their indices.

    // ### Requirements

    // ```text
    // O(n) average time
    // O(n) space
    // ```

    // Write the algorithm from scratch.

    // ---

    public static int[] twoSumHashMap(int[] num, int target) {
        int[] ans = new int[num.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int comp = target - num[i];
            if (map.containsKey(comp)) {
                ans[0] = map.get(comp);
                ans[1] = i;
                return ans;
            }
            map.put(num[i], i);
        }

        return new int[] { -1, -1 };
    }

    // # Problem B

    // Given:

    // ```text
    // [2, 1, 5, 2, 3, 2]
    // ```

    // find the minimum-length contiguous subarray with sum ≥ `7`.

    // All numbers are positive.

    // Requirements:

    // ```text
    // O(n)
    // O(1) extra space
    // ```

    // Write it from scratch.

    // ---
    // variable sliding window

    public static int minLengthSubarray(int[] nums, int target) {
        int minlen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (target <= sum) {
                minlen = Math.min(minlen, (right - left));
                sum -= nums[left];
                left++;
            }
        }
        if (minlen == Integer.MAX_VALUE) {
            minlen = 0;
        }

        return minlen;
    }
    // # Problem C

    // Given:

    // ```text
    // [2, 1, 2, 4, 3]
    // ```

    // return:

    // ```text
    // [4, 2, 4, -1, -1]
    // ```

    // Write the algorithm from scratch.

    // Don't look at your Day 6 implementation.

    // ---

    public static int[] nextGreatestInt(int[] nums) {
        int[] ans = new int[nums.length];

        Deque<Integer> StackIndex = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!StackIndex.isEmpty()) {
                while (nums[StackIndex.peek()] < nums[i]) {
                    ans[StackIndex.pop()] = nums[i];
                }
            }
            StackIndex.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
