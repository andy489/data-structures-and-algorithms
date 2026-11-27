// https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/

// Solution: HashMap of Row Patterns — O(m*n) time, O(m*n) space
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> freq = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            int flip = row[0];
            for (int v : row) {
                sb.append(v ^ flip);
            }
            String key = sb.toString();
            freq.merge(key, 1, Integer::sum);
        }
        int max = 0;
        for (int cnt : freq.values()) {
            max = Math.max(max, cnt);
        }
        return max;
    }
}
