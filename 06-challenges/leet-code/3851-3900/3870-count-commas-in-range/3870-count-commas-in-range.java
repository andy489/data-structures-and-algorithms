// https://leetcode.com/problems/count-commas-in-range/

class Solution {
    public int countCommas(int n) {
        // Numbers >= 1000 have 1 comma (since n <= 10^5 means at most 6 digits -> 1 comma)
        return Math.max(0, n - 999);
    }
}
