package Week_4.Miscellaneous;

import java.util.HashMap;

public class fourSum2 {
    // 454. 4Sum II

    // Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
    // return the number of tuples (i, j, k, l) such that:

    // 0 <= i, j, k, l < n
    // nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

    // Example 1:

    // Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
    // Output: 2
    // Explanation:
    // The two tuples are:
    // 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) +
    // (-1) + 2 = 0
    // 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) +
    // (-1) + 0 = 0
    // Example 2:

    // Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
    // Output: 1
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // hashmap Sum,freq for sum pair of nums1 and nums2
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // nums3 and nums4 sum check in Hashmap
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                if (map.containsKey(-sum)) {
                    count += map.get(-sum);
                }
            }
        }

        return count;
    }
}
