// https://leetcode.com/problems/split-a-string-in-balanced-strings/

// Solution: Greedy Counter — O(n) time, O(1) space
// Solution: Greedy Counter — O(n) time, O(1) space
class Solution {
    public int balancedStringSplit(String s) {
        int balance = 0, res = 0;
        for (char c : s.toCharArray()) {
            balance += c == 'R' ? 1 : -1;
            if (balance == 0) res++;
        }
        return res;
    }
}
