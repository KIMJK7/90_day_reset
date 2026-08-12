package Week_3.Day_2;

public class binarySearch {

    // binary search for sorted array
    static int binarySearchElement(int[] nums, int x, int first, int last) {
        if (first > last) {
            return -1;
        }
        int middle = first + (last - first) / 2;
        if (x == nums[first]) {
            return first;
        } else if (x == nums[last]) {
            return last;
        }
        if (x == nums[middle]) {
            return middle;

        } else if (nums[middle] > x) {
            // x is in 0 to middle
            return binarySearchElement(nums, x, first, middle - 1);

        } else if (nums[middle] < x) {
            // x is in middle+1 to last
            return binarySearchElement(nums, x, middle + 1, last);
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = { 3, 6, 9, 12, 15, 18 };
        int x = 7;
        int index = binarySearchElement(nums, x, 0, nums.length - 1);
        boolean isfound = false;
        if (index != -1) {
            isfound = true;
        }
        System.out.println("is 7 in the array {3,6,9,12,15,18} return -1 if not present" + isfound);
    }
}
