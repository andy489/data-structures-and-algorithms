// https://leetcode.com/problems/student-attendance-record-ii/
// Solution: DP with 6 states (absences 0/1 × trailing lates 0/1/2) — O(n) time, O(1) space
class Solution {
    private static final int MOD = 1_000_000_007;

    public int checkRecord(int n) {
        // dp[a][l]: count of valid strings with 'a' total A's and 'l' trailing L's
        long a0l0 = 1, a0l1 = 0, a0l2 = 0;
        long a1l0 = 0, a1l1 = 0, a1l2 = 0;
        for (int i = 0; i < n; i++) {
            long na0l0 = (a0l0 + a0l1 + a0l2) % MOD;
            long na0l1 = a0l0;
            long na0l2 = a0l1;
            long na1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % MOD;
            long na1l1 = a1l0;
            long na1l2 = a1l1;
            a0l0 = na0l0; a0l1 = na0l1; a0l2 = na0l2;
            a1l0 = na1l0; a1l1 = na1l1; a1l2 = na1l2;
        }
        return (int) ((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % MOD);
    }
}
