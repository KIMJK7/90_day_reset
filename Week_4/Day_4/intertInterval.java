package Week_4.Day_4;

import java.util.Arrays;

public class intertInterval {
    static int[][] insert(int[][] intervals, int[] newInterval) {
        int ans[][] = new int[intervals.length + 1][2];
        int count = 0;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currEnd < newStart) {
                ans[count][0] = currStart;
                ans[count][1] = currEnd;
                count++;
            } else if (currStart > newEnd) {
                ans[count][0] = newStart;
                ans[count][1] = newEnd;
                count++;
                for (int j = i; j < intervals.length; j++) {
                    ans[count][0] = intervals[j][0];
                    ans[count][1] = intervals[j][1];
                    count++;
                }
                return Arrays.copyOf(ans, count);

            } else {
                newStart = Math.min(currStart, newStart);
                newEnd = Math.max(currEnd, newEnd);

            }
        }
        ans[count][0] = newStart;
        ans[count][1] = newEnd;
        count++;
        return Arrays.copyOf(ans, count);
    }
}
