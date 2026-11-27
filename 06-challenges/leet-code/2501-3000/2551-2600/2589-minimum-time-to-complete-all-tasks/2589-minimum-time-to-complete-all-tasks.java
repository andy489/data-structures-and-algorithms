// https://leetcode.com/problems/minimum-time-to-complete-all-tasks/
class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        boolean[] running = new boolean[2001];
        int total = 0;
        for (int[] task : tasks) {
            int start = task[0], end = task[1], dur = task[2];
            for (int t = start; t <= end; t++) {
                if (running[t]) {
                    dur--;
                }
            }
            for (int t = end; t >= start && dur > 0; t--) {
                if (!running[t]) {
                    running[t] = true;
                    dur--;
                    total++;
                }
            }
        }
        return total;
    }
}
