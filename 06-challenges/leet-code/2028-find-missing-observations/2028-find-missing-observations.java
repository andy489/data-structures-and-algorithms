// https://leetcode.com/problems/find-missing-observations/

// Solution: Math Distribution — O(m+n) time, O(n) space
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, sumR = 0;
        for (int r : rolls) { sumR += r; }
        int needed = (m + n) * mean - sumR;
        if (needed < n || needed > 6 * n) { return new int[0]; }
        int base = needed / n, rem = needed % n;
        int[] res = new int[n];
        Arrays.fill(res, base);
        for (int i = 0; i < rem; i++) { res[i]++; }
        return res;
    }
}
