// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] indexed = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexed[i][0] = nums[i];
            indexed[i][1] = i;
        }
        Arrays.sort(indexed, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        boolean[] marked = new boolean[n];
        long score = 0;
        for (int[] pair : indexed) {
            int idx = pair[1];
            if (!marked[idx]) {
                score += pair[0];
                marked[idx] = true;
                if (idx > 0) {
                    marked[idx - 1] = true;
                }
                if (idx < n - 1) {
                    marked[idx + 1] = true;
                }
            }
        }
        return score;
    }
}
