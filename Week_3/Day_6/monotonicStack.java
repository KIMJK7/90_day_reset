package Week_3.Day_6;

import java.util.ArrayDeque;
import java.util.Deque;

public class monotonicStack {
    static int[] nextGreaterElement(int[] nums) {
        Deque<Integer> stackIndex = new ArrayDeque<>();
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!stackIndex.isEmpty() && nums[stackIndex.peek()] < nums[i]) {
                ans[stackIndex.peek()] = nums[i];
                stackIndex.pop();
            }

            stackIndex.push(i);

        }

        while (!stackIndex.isEmpty()) {
            ans[stackIndex.pop()] = -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 2, 4, 3 };
        int[] ans = nextGreaterElement(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
