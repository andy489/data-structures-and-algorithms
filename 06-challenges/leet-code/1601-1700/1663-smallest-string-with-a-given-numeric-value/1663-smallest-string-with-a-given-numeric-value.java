// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

// Solution: Greedy (Fill from Right) — O(n) time, O(n) space
class Solution {
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            int remaining = k - i; // positions 0..i-1 need at least i*1
            int val = Math.min(26, remaining);
            result[i] = (char) ('a' + val - 1);
            k -= val;
        }
        return new String(result);
    }
}
