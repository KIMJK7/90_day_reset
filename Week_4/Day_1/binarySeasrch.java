package Week_4.Day_1;

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

    // Problem

    // You have:

    // weights = [1,2,3,4,5,6,7,8,9,10]

    // A ship must transport all packages in 5 days.

    // Packages must be loaded in order.

    // What is the minimum ship capacity required?
    static boolean isPossible(int[] nums, int days, int value) {

        int sum = 0;
        int daysUsed = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > value) {
                sum = nums[i];
                daysUsed++;
            }
        }
        if (daysUsed <= days) {
            return true;
        }

        return false;
    }

    static int minShipCapacity(int[] nums, int days) {
        int minCap = Integer.MAX_VALUE;
        // we are assuming that array is sorted:
        // left and right are not index but values;
        // int left = nums[nums.length - 1];
        // if array is not sorted:
        int left = 0;
        for (int num : nums) {
            left = Math.max(left, num);
        }
        int right = 0;
        for (int num : nums) {
            right += num;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(nums, days, mid)) {
                minCap = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return minCap;
    }

    static boolean isPossiblehours(int[] piles, int h, int speed) {

        long hoursUsed = 0;

        for (int pile : piles) {
            hoursUsed += ((long) pile + speed - 1) / speed;
        }

        return hoursUsed <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int ans = 0;
        int left = 1;

        int right = 0;
        for (int num : piles) {
            right = Math.max(right, num);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossiblehours(piles, h, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 2, 2, 2, 4, 5 };
        // int indexFirst = firstOccurrence(nums, 2);
        // System.out.println("index : " + indexFirst);
        // int indexLast = lastOccurrence(nums, 2);
        // System.out.println("index : " + indexLast);
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        int minCapacity = minShipCapacity(weights, days);
        System.out.println("Minimun capacity required: " + minCapacity);
    }
}
