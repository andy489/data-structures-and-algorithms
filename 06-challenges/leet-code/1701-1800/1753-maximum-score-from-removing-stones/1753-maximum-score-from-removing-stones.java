// https://leetcode.com/problems/maximum-score-from-removing-stones/

// Solution: Math — O(1) time, O(1) space
class Solution {
    public int maximumScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int total = a + b + c;
        int rest = total - max;
        return max >= rest ? rest : total / 2;
    }
}
