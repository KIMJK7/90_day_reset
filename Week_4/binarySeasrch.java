package Week_4;

public class binarySeasrch {
    // nums[mid] < target
    // ↓
    // everything left of mid is useless

    // or

    // nums[mid] > target
    // ↓
    // everything right of mid is useless

    public static int iterativeSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int recursiveSearch(int[] nums, int target, int left, int right) {
        int mid = left + (right - left) / 2;

        if (target == nums[mid]) {

            return mid;
        } else if (target < nums[mid]) {
            return recursiveSearch(nums, target, left, mid - 1);
        } else {
            return recursiveSearch(nums, target, mid + 1, right);
        }
    }

    static int firstOccurrence(int[] nums, int target) {
        // we will have duplicates when we find the target we need to not stop but still
        // check if we can find it in left
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                index = mid;
                right = mid - 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    static int lastOccurrence(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                index = mid;
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstOccurrence(nums, target);
        ans[1] = lastOccurrence(nums, target);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 4, 5 };
        int indexFirst = firstOccurrence(nums, 2);
        System.out.println("index : " + indexFirst);
        int indexLast = lastOccurrence(nums, 2);
        System.out.println("index : " + indexLast);
    }
}
