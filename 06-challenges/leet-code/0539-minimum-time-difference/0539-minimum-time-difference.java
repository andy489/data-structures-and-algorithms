// https://leetcode.com/problems/minimum-time-difference/

// Solution: Sort + circular diff — O(n log n) time, O(n) space
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
            String[] parts = timePoints.get(i).split(":");
            minutes[i] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }
        Arrays.sort(minutes);
        int minDiff = 1440 - minutes[n - 1] + minutes[0];
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
        }
        return minDiff;
    }
}

// Solution 2: Bucket sort — O(n) time, O(1) space
class Solution2 {
    public int findMinDifference(List<String> timePoints) {
        boolean[] seen = new boolean[1440];
        for (String tp : timePoints) {
            String[] parts = tp.split(":");
            int minutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            if (seen[minutes]) {
                return 0;
            }
            seen[minutes] = true;
        }
        int minDiff = 1440;
        int first = -1, prev = -1;
        for (int i = 0; i < 1440; i++) {
            if (seen[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }
        minDiff = Math.min(minDiff, 1440 - prev + first);
        return minDiff;
    }
}
