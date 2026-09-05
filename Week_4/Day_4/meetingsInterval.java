package Week_4.Day_4;

import java.util.Arrays;

public class meetingsInterval {

    // Complexity:

    // Sorting → O(n log n)
    // Scan → O(n)
    // Total → O(n log n)
    // Extra scan space → O(1) (ignoring sorting implementation)
    static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            int currEnd = intervals[i][1];
            int nextStart = intervals[i + 1][0];
            if (nextStart <= currEnd) {
                return false;
            }
        }
        return true;
    }
}
