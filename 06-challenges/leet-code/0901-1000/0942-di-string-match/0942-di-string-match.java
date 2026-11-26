// https://leetcode.com/problems/di-string-match/

// Solution: Greedy — O(n) time, O(1) space
class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int lo = 0, hi = n;
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++) {
            result[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        }
        result[n] = lo;
        return result;
    }
}
