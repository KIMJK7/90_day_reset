package Week_3.Day_6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

// 496. Next Greater Element I
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

// Example 1:

// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// Example 2:

// Input: nums1 = [2,4], nums2 = [1,2,3,4]
// Output: [3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
// - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

// Constraints:

// 1 <= nums1.length <= nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 104
// All integers in nums1 and nums2 are unique.
// All the integers of nums1 also appear in nums2.

// Follow up: Could you find an O(nums1.length + nums2.length) solution?

public class NextGreatestElement {
    // My solution
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> Index = new ArrayDeque<>();

        int[] index = new int[nums1.length];
        int p1 = 0;
        int p2 = 0;
        int ix = 0;
        while (p1 != nums1.length && p2 != nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                index[ix] = p2;
                p2 = 0;
                p1++;
                ix++;
            } else {
                p2++;
            }
        }
        int gSum[] = new int[nums2.length];

        for (int i = 0; i < nums2.length; i++) {
            while (!Index.isEmpty() && nums2[i] > nums2[Index.peek()]) {
                gSum[Index.peek()] = nums2[i];
                Index.pop();
            }
            Index.push(i);
        }

        while (!Index.isEmpty()) {
            gSum[Index.pop()] = -1;
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = gSum[index[i]];
        }

        return ans;

    }

    // better one using hashmap
    public int[] nextGreaterElementbetter(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> valueIndexInNum2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            valueIndexInNum2.put(nums2[i], i);
        }
        Deque<Integer> nums2WaitingIndex = new ArrayDeque<>();
        int[] nums2nextGreatestElement = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!nums2WaitingIndex.isEmpty() && nums2[i] > nums2[nums2WaitingIndex.peek()]) {
                nums2nextGreatestElement[nums2WaitingIndex.peek()] = nums2[i];
                nums2WaitingIndex.pop();
            }
            nums2WaitingIndex.push(i);
        }
        while (!nums2WaitingIndex.isEmpty()) {
            nums2nextGreatestElement[nums2WaitingIndex.pop()] = -1;
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {

            int val = valueIndexInNum2.get(nums1[i]);
            ans[i] = nums2nextGreatestElement[val];

        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
