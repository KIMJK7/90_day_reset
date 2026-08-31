package Week_4.Day_2;

import java.util.HashMap;

public class codingExercises {

    static int[] prefix(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return prefix;
    }

    static int rangeSum(int[] prefix, int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int comp = currSum - k;
            count += map.getOrDefault(comp, 0);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 5, 1, 6 };
        int[] prefix = prefix(nums);
        System.out.println(rangeSum(prefix, 1, 3));
    }
}
