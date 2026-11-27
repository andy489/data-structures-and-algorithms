// https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        int[] duration = new int[n];
        for (int i = 0; i < n; i++) {
            duration[i] = endTime[i] - startTime[i];
        }

        // prefixMax[i] = max(gaps[0..i-1])
        int[] prefixMax = new int[n + 2];
        for (int i = 1; i <= n + 1; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], gaps[i - 1]);
        }
        // suffixMax[i] = max(gaps[i..n])
        int[] suffixMax = new int[n + 2];
        for (int i = n; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], gaps[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int merged = gaps[i] + duration[i] + gaps[i + 1];
            // Can meeting i fit somewhere else? Check all gaps except gaps[i] and gaps[i+1]
            int bestOtherGap = Math.max(prefixMax[i], suffixMax[i + 2]);
            if (bestOtherGap >= duration[i]) {
                ans = Math.max(ans, merged);
            } else {
                ans = Math.max(ans, gaps[i] + gaps[i + 1]);
            }
        }
        return ans;
    }
}
