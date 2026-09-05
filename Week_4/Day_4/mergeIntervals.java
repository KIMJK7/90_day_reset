package Week_4.Day_4;

import java.util.Arrays;

public class mergeIntervals {

    static int[][] bubbleSortInterval(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = 0; j < intervals.length - 1 - i; j++) {
                if (intervals[j][0] >= intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }

            }
        }

        return intervals;
    }
    // Complexity:
    // Sorting: O(n log n)
    // Merge scan: O(n)
    // Total: O(n log n)
    // Auxiliary scan state: O(1)
    // Output: O(n) worst case

    static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        // bubbleSortInterval(intervals);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] ans = new int[intervals.length][2];
        int count = 0;
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];
        for (int i = 1; i < intervals.length - 1; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if (currEnd >= nextStart) {
                currEnd = Math.max(currEnd, nextEnd);
            } else {
                ans[count][0] = currStart;
                ans[count][1] = currEnd;
                count++;

                currStart = nextStart;
                currEnd = nextEnd;
            }
        }
        ans[count][0] = currStart;
        ans[count][1] = currEnd;
        return Arrays.copyOf(ans, count);
    }
}
