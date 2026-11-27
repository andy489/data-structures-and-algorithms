// https://leetcode.com/problems/count-fancy-numbers-in-a-range/

class Solution {
    private boolean isGood(int n) {
        if (n < 10) return true;
        String s = Integer.toString(n);
        boolean inc = true, dec = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) >= s.charAt(i - 1)) inc = false;
            if (s.charAt(i) <= s.charAt(i - 1)) dec = false;
        }
        return inc || dec;
    }

    private int[] digits;
    // memo[pos][tight][dsum][prev][inc][dec][started]
    private Long[][][][][][][] memo;

    private long dp(int pos, boolean tight, int dsum, int prev, boolean inc, boolean dec, boolean started) {
        if (pos == digits.length) {
            if (!started) return 0;
            // Check if number is fancy
            boolean goodSelf = inc || dec;
            boolean goodSum = isGood(dsum);
            return (goodSelf || goodSum) ? 1 : 0;
        }
        int ti = tight ? 1 : 0;
        int ii = inc ? 1 : 0;
        int di = dec ? 1 : 0;
        int si = started ? 1 : 0;
        if (memo[pos][ti][dsum][prev][ii][di][si] != null) {
            return memo[pos][ti][dsum][prev][ii][di][si];
        }
        int limit = tight ? digits[pos] : 9;
        long res = 0;
        for (int d = 0; d <= limit; d++) {
            boolean newTight = tight && (d == limit);
            if (!started && d == 0) {
                res += dp(pos + 1, newTight, 0, -1, true, true, false);
            } else {
                boolean newInc = started ? (inc && d > prev) : true;
                boolean newDec = started ? (dec && d < prev) : true;
                res += dp(pos + 1, newTight, dsum + d, d, newInc, newDec, true);
            }
        }
        memo[pos][ti][dsum][prev][ii][di][si] = res;
        return res;
    }

    private long count(long n) {
        if (n <= 0) return 0;
        String s = Long.toString(n);
        digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) digits[i] = s.charAt(i) - '0';
        // dimensions: pos, tight(2), dsum(136), prev(11, -1 mapped to 10), inc(2), dec(2), started(2)
        memo = new Long[digits.length][2][136][11][2][2][2];
        return dp(0, true, 0, 10, true, true, false);
    }

    public long countFancyNumbers(long l, long r) {
        return count(r) - count(l - 1);
    }
}
