package Week_4.Day_4;

import java.util.Arrays;

public class maxNonOverlappingIntervals {
    static int maxNonOverlapping(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;

        int currEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if (nextStart >= currEnd) {
                count++;

                currEnd = nextEnd;
            }
        }
        return count;
    }
}
