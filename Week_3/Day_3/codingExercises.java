package Week_3.Day_3;

public class codingExercises {

    // Given a sorted array [1, 2, 3, 4, 6, 8], determine whether there are two
    // numbers whose difference is 5.
    static int[] diffFive(int[] nums, int target) {
        int[] ans = new int[2];
        int left = 0;

        // right = n - 1 → when you have a left side vs right side search
        // int right = nums.length - 1;

        // while (left < right) {
        // int diff = nums[right] - nums[left];
        // if (diff == target) {
        // ans[0] = left;
        // ans[1] = right;
        // break;
        // } else if (diff > target) {
        // right--;
        // } else {
        // left++;
        // }

        // }
        // adjacent terms are checked like sliding window
        // when you're comparing pairs/ranges moving in the same direction
        int right = 1;
        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            if (target == diff) {
                ans[0] = left;
                ans[1] = right;
                return ans;
            } else if (target > diff) {
                right++;
            } else {
                left++;
                if (left == right) {
                    right++;
                }
            }
        }

        return new int[] { -1, -1 };
    }

    // Given [2, 1, 5, 1, 3, 2], find the minimum sum of any 3 consecutive elements.
    static int[] minSum3ele(int[] nums) {
        int n = nums.length;
        int k = 3;
        int[] ans = new int[3];
        int minsum = Integer.MAX_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            int currSum = 0;
            for (int j = 0; j < k; j++) {
                currSum += nums[i + j];
            }
            if (currSum < minsum) {
                minsum = currSum;
                ans[0] = i;
                ans[1] = i + k - 1;
                ans[2] = minsum;
            }
        }
        return ans;
    }

    // Given "madam", determine whether it is a palindrome.
    static boolean isPalindrome(String str) {
        boolean ispal = true;
        int left = 0;
        int right = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(left) != str.charAt(right)) {
                ispal = false;
                return ispal;
            }
        }
        return ispal;
    }

    // Given [3, -2, 7, 1, 4], determine whether any two numbers sum to 5
    static int[] twosum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (target == (nums[i] + nums[j])) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // Given [1, 2, 2, 3, 3, 3, 4], remove duplicates in-place so each value appears
    // only once
    // this was my solution:
    // static void removeDuplicates(int[] nums) {
    // int n = nums.length;
    // int left = 0;
    // int right = 1;
    // while (right < n) {
    // if (nums[left] == nums[right]) {
    // deleteElement(nums, left);
    // } else {
    // if (right == left + 1) {
    // left++;
    // right++;
    // }

    // }
    // }
    // }

    // static void deleteElement(int nums[], int left) {
    // for (int i = left + 1; i < nums.length-1; i++) {
    // nums[i] = nums[i + 1];
    // }

    // }

    static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 1;
        for (right = 1; right < n; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        // int[] sortedArray = { 1, 2, 3, 4, 6, 8 };
        // int[] diffIsFive = diffFive(sortedArray, 5);
        // System.out.println("in an sorted array {1,2,3,4,6,8} find position of
        // elements whose diff is 5: ");
        // for (int i = 0; i < 2; i++) {
        // System.out.println("Position: " + diffIsFive[i] + " element: " +
        // sortedArray[diffIsFive[i]]);
        // }
        // int[] arr = { 2, 1, 5, 1, 3, 2 };
        // int[] minSum = minSum3ele(arr);
        // System.out.println("Min Sum : " + minSum[2] + " between positions: " +
        // minSum[0] + " and " + minSum[1]);
        // boolean palindrome = isPalindrome("madam");
        // System.out.println("is madam a palindrome? " + palindrome);
        int[] arr = { 1, 2, 2, 3, 3, 3, 4 };
        int k = removeDuplicates(arr);
        System.err.println("After Removing dulplicates from [1, 2, 2, 3, 3, 3, 4]: ");
        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }
    }
}
