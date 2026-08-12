package Week_3.Day_1;

public class arrayBasics {
    // Print all elements
    // time complexity - O(n)
    // Space Complexity - O(1)

    static void printElements(int[] nums) {
        if (nums.length == 0) {
            System.out.println("No element found!");
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    // Print elements in reverse
    // time complexity - O(n)
    // Space Complexity - O(1)

    static void printReverseElements(int[] nums) {
        if (nums.length == 0) {
            System.out.println("No element found!");
            return;
        }
        for (int i = (nums.length - 1); i >= 0; i--) {
            System.out.println(nums[i]);
        }
    }

    // Find the sum
    // time complexity - O(n)
    // Space Complexity - O(1)

    static int sumElements(int[] nums) {
        if (nums.length == 0) {
            System.out.println("No element found!");
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    // Find the maximum
    // time complexity - O(n)
    // Space Complexity - O(1)

    static int maxElement(int[] nums) {
        if (nums.length == 0) {
            System.out.println("No element found!");
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        return max;
    }

    // Find the minimum
    // time complexity - O(n)
    // Space Complexity - O(1)

    static int minElement(int[] nums) {
        if (nums.length == 0) {
            System.out.println("No element found!");
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }

        return min;
    }

    // Linear Search
    // What is the:
    // Best-case time complexity? - O(1) we found the element on nums[0] first
    // element itself
    // Worst-case time complexity? - O(n) the element to be searched was last
    // element so we needed to traverse and comapare every element
    // Average-case complexity? - O(n) if we find the element anywhere in middle we
    // still needed to traver elements like if the lement was found in the middle
    // O(n/2) -> O(n)
    // Space complexity? - O(1) we didnt require any additional array we just had
    // extra variables like i and index
    static int linearSearch(int[] nums, int findNum) {
        if (nums.length == 0) {
            System.out.println("No element found!");
            return -1;
        }
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (findNum == nums[i]) {
                index = i;
                break;
            }
        }

        return index;
    }

    // Reverse Array with space complexity O(1) no additional array
    static void reverseArray(int[] nums) {
        if (nums.length == 0) {
            System.out.println("No element found!");
            return;
        }
        int n = nums.length;
        int i = 0;

        for (i = 0; i <= n / 2; i++) {
            if (i != (n - 1) || i > (n - 1)) {
                int temp = nums[i];
                nums[i] = nums[n - 1];
                nums[n - 1] = temp;
                n--;
            }

        }
    }

    // Find Second largest element in O(n) time complexit
    static int secondLargestElement(int[] nums) {
        if (nums.length == 0) {
            System.out.println("No element found!");
            return -1;
        }
        int n = nums.length;
        int largest;
        int secondLargest;
        if (nums[0] >= nums[1]) {
            largest = nums[0];
            secondLargest = nums[1];
        } else {
            largest = nums[1];
            secondLargest = nums[0];
        }

        for (int i = 2; i < n; i++) {
            if (largest < nums[i]) {
                secondLargest = largest;
                largest = nums[i];
            } else if (secondLargest < nums[i] && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 5, 20, 8, 20, 15 };

        int slEle = secondLargestElement(nums);
        System.out.println("Second largest element is: " + slEle);
    }
}
