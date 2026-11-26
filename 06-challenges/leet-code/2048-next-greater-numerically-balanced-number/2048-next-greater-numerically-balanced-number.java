// https://leetcode.com/problems/next-greater-numerically-balanced-number/

// Solution: Brute Force Check — O(range * L) time, O(1) space
class Solution {
    public int nextBeautifulNumber(int n) {
        for (int cand = n + 1; ; cand++) {
            if (isBalanced(cand)) { return cand; }
        }
    }
    private boolean isBalanced(int n) {
        int[] freq = new int[10];
        int tmp = n;
        while (tmp > 0) { freq[tmp % 10]++; tmp /= 10; }
        for (int d = 0; d <= 9; d++) { if (freq[d] != 0 && freq[d] != d) { return false; } }
        return true;
    }
}
