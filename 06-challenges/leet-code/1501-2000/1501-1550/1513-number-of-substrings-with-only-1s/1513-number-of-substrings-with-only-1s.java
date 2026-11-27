// https://leetcode.com/problems/number-of-substrings-with-only-1s/

// Solution: Running Count — O(n) time, O(1) space
class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int numSub(String s) {
        long result = 0;
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cur++;
                result += cur;
            } else {
                cur = 0;
            }
        }
        return (int) (result % MOD);
    }
}
