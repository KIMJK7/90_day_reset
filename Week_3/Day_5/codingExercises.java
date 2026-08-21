package Week_3.Day_5;

import java.util.HashMap;
import java.util.HashSet;

public class codingExercises {

    static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }

        return false;
    }

    static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (!map.containsKey(comp)) {
                map.put(nums[i], i);
            } else {
                ans[0] = map.get(comp);
                ans[1] = i;
                break;
            }
        }

        return ans;
    }

    // my code
    static HashMap<Integer, Integer> frequencyMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        return map;
    }

    static HashMap<Integer, Integer> frequencyMapinBuilt(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    static char firstNonRepeating(String s) {
        char ans = '\u0000';
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (value == 1) {
                ans = s.charAt(i);
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 1 };
        // int[] arr2 = { 1, 2, 3, 4 };
        // int[] emptyArray = {};
        // System.out.println("does arr ={1,2,3,1} conatin any duplicates? " +
        // containsDuplicate(arr));
        // System.out.println("does arr ={1,2,3,4} conatin any duplicates? " +
        // containsDuplicate(arr2));
        // System.out.println("does arr ={} conatin any duplicates? " +
        // containsDuplicate(emptyArray));

        // int[] nums = { 2, 11, 7, 15 };
        // int target = 9;
        // int[] ans = twoSum(nums, target);
        // System.out.println("nums = [2,11,7,15]\t" + "target = 9\t" + ans[0] + "\t" +
        // ans[1]);

        String s = "PROGRAMPINC";
        char firstcharnonrep = firstNonRepeating(s);
        System.out.println(firstcharnonrep);
    }
}
