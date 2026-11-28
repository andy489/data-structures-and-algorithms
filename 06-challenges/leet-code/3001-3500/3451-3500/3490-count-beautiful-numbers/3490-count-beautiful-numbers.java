// https://leetcode.com/problems/count-beautiful-numbers/

// Solution: Digit DP — O(digits * sum * product states) time, O(same) space
class Solution {
    // LCM(1..9) = 2520 — product of digits 1-9 tracked mod 2520 suffices
    // since sum of digits is at most 9*9=81, and we check product % sum == 0
    // We only need product mod LCM(1..81); but LCM(1..9)=2520 is key since
    // digits are 0-9, so product only has prime factors 2,3,5,7.
    // LCM of all possible digit sums (1..81) containing these factors:
    // sufficient to track product mod 2520 (LCM of 1..9).
    private static final int MOD = 2520;
    private int[][][][] memo;
    private int[] digits;

    private int dp(int pos, int sum, int prod, boolean tight) {
        if (pos == digits.length) {
            if (sum == 0) {
                return 0; // leading zeros only, not a valid number
            }
            return (prod % sum == 0) ? 1 : 0;
        }
        if (!tight && memo[pos][sum][prod] != -1) {
            return memo[pos][sum][prod];
        }
        int limit = tight ? digits[pos] : 9;
        int result = 0;
        for (int d = 0; d <= limit; d++) {
            int newSum = sum + d;
            int newProd = (d == 0) ? 0 : (prod == 0 && sum == 0) ? d : (prod * d) % MOD;
            // Handle leading zeros: if sum==0 and d==0, it's still leading zero
            if (sum == 0 && d == 0) {
                result += dp(pos + 1, 0, 0, tight && d == limit);
            } else {
                result += dp(pos + 1, newSum, (sum == 0) ? d % MOD : (prod * d) % MOD, tight && d == limit);
            }
        }
        if (!tight) {
            memo[pos][sum][prod] = result;
        }
        return result;
    }

    private int count(int n) {
        if (n <= 0) {
            return 0;
        }
        String s = Integer.toString(n);
        digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        int maxSum = 9 * digits.length;
        memo = new int[digits.length][maxSum + 1][MOD][];
        // Initialize memo as 3D (pos, sum, prod) -> int
        // Using flat 3D array
        int[][][] dp3 = new int[digits.length][maxSum + 1][MOD];
        for (int[][] a : dp3) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        // Reimplement with 3D array
        return countHelper(n);
    }

    private int[][][] cache;
    private int[] digs;
    private int maxS;

    private int f(int pos, int sum, int prod, boolean tight) {
        if (pos == digs.length) {
            if (sum == 0) return 0;
            return (prod % sum == 0) ? 1 : 0;
        }
        if (!tight && cache[pos][sum][prod] != -1) {
            return cache[pos][sum][prod];
        }
        int limit = tight ? digs[pos] : 9;
        int result = 0;
        for (int d = 0; d <= limit; d++) {
            if (sum == 0 && d == 0) {
                result += f(pos + 1, 0, 0, tight && d == limit);
            } else {
                int ns = sum + d;
                int np = (sum == 0) ? d % MOD : (prod == 0 ? 0 : (prod * d) % MOD);
                if (sum == 0) {
                    np = d;
                } else {
                    np = (prod * d) % MOD;
                }
                result += f(pos + 1, ns, np, tight && d == limit);
            }
        }
        if (!tight) {
            cache[pos][sum][prod] = result;
        }
        return result;
    }

    private int countHelper(int n) {
        String s = Integer.toString(n);
        digs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digs[i] = s.charAt(i) - '0';
        }
        maxS = 9 * digs.length;
        cache = new int[digs.length][maxS + 1][MOD];
        for (int[][] a : cache) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return f(0, 0, 0, true);
    }

    public int beautifulNumbers(int l, int r) {
        return countHelper(r) - countHelper(l - 1);
    }
}
