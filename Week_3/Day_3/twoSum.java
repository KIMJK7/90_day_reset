package Week_3.Day_3;

public class twoSum {
    static int[] twoSumSortedArray(int[] nums, int target) {
        if (nums.length < 2) {
            System.out.println("cannot determine!");
            int[] ans = { -1, -1 };
            return ans;
        }
        int left = 0;
        int right = nums.length - 1;

        int[] ans = new int[2];
        while (left < right) {
            int sum = (nums[left] + nums[right]);
            if (target == sum) {
                ans[0] = left;
                ans[1] = right;
                return ans;
            } else if (target < sum) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }

    // Palindrome checking

    static boolean Palindrome(String str) {
        boolean pal = true;
        int left = 0;
        int right = str.length();

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                pal = false;
                break;
            } else {
                left++;
                right--;
            }
        }

        return pal;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 6, 8, 9 };
        int target = 12;
        int[] ans = new int[2];
        ans = twoSumSortedArray(nums, target);
        System.out.println("Sum 12 found at indexes" + ans[0] + " " + ans[1]);

    }
}
