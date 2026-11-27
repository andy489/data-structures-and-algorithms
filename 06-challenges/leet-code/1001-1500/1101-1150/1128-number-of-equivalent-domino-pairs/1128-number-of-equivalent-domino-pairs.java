// https://leetcode.com/problems/number-of-equivalent-domino-pairs/

// Solution: Canonical Key Count — O(n) time, O(1) space
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int ans = 0;
        for (int[] d : dominoes) {
            int key = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            ans += count[key];
            count[key]++;
        }
        return ans;
    }
}
