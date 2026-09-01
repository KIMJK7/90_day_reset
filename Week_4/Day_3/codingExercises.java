package Week_4.Day_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class codingExercises {
    static HashMap<Integer, Integer> frequencyMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    static int firstUniqChar(String s) {

        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    static int firstDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        // optimized 26-frequency-array key later
        HashMap<String, List<String>> map = new HashMap<>();

        for (String input : strs) {
            char[] charArray = input.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(input);
        }

        return new ArrayList<>(map.values());
    }

    // Subarray Sum Equals K
    static int subArraySum(int[] nums, int k) {
        // hashMap(prefix sum, frequency)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int comp = sum - k;
            count += map.getOrDefault(comp, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    static int longestConsecutive(int[] nums) {

        int maxLen = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {

            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 3, 3, 4 };
        HashMap<Integer, Integer> frequency = frequencyMap(nums);
        frequency.forEach((key, value) -> System.out.println(key + " : " + value));

        String str = "aahiwb";
        int freq = firstUniqChar(str);
        System.out.println(str.charAt(freq));
        int firstDup = firstDuplicate(nums);
        System.out.println("the first dupliacte is: " + firstDup);
    }
}
