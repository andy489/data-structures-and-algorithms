// https://leetcode.com/problems/numbers-with-repeated-digits/

// Solution: Digit DP (Complement Counting) — O(log n) time, O(log n) space
class Solution {
    public int numDupDigitsAtMostN(int n) {
        return n - countNoRepeat(n);
    }

    private int countNoRepeat(int n) {
        int[] digits = Integer.toString(n + 1).chars().map(c -> c - '0').toArray();
        int len = digits.length;
        int result = 0;
        // Count all numbers with fewer digits
        int perm = 9;
        for (int i = 1; i < len; i++) {
            result += perm;
            perm *= (10 - i);
        }
        // Count numbers with same length as n+1
        boolean[] used = new boolean[10];
        for (int i = 0; i < len; i++) {
            int start = (i == 0) ? 1 : 0;
            int d = digits[i];
            for (int x = start; x < d; x++) {
                if (!used[x]) {
                    result += permutations(10 - i - 1, len - i - 1);
                }
            }
            if (used[d]) {
                break;
            }
            used[d] = true;
            if (i == len - 1) {
                result++;
            }
        }
        return result;
    }

    private int permutations(int m, int k) {
        int p = 1;
        for (int i = 0; i < k; i++) {
            p *= (m - i);
        }
        return p;
    }
}
