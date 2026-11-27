// https://leetcode.com/problems/second-largest-digit-in-a-string/

// Solution: Track Top Two Distinct Digits — O(n) time, O(1) space
class Solution {
    public int secondHighest(String s) {
        int first = -1, second = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int d = c - '0';
                if (d > first) {
                    second = first;
                    first = d;
                } else if (d < first && d > second) {
                    second = d;
                }
            }
        }
        return second;
    }
}
