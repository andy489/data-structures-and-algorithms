// https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        int[] tails = new int[n];
        int len = 0;

        for (int i = 0; i < n; i++) {
            int h = obstacles[i];
            int lo = 0, hi = len;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (tails[mid] <= h) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            tails[lo] = h;
            if (lo == len) {
                len++;
            }
            ans[i] = lo + 1;
        }
        return ans;
    }
}
