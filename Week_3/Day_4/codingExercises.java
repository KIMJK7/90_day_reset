package Week_3.Day_4;

public class codingExercises {
    static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        int left = 0;
        int length = Integer.MAX_VALUE;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (target <= sum) {
                length = right - left;
                if (length < minLen) {
                    minLen = length;
                }
                sum -= nums[left];
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }

        return minLen;
    }

    static int[] buildPrefixSum(int[] nums) {
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

    public static void main(String[] args) {
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println("minlength subarray is: " + minSubArrayLen(target, nums));
        int[] prefix = buildPrefixSum(nums);
        System.out.println("prefix sum array for {2, 3, 1, 2, 4, 3 }");
        for (int i = 0; i < prefix.length; i++) {
            System.out.print(prefix[i] + " ");
        }
        System.out.println("\nSum of range 1-3 is:  " + rangeSum(prefix, 1, 3));
    }
}
