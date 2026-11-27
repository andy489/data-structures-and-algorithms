// https://leetcode.com/problems/count-special-subsequences/
class Solution {
    public long countSpecialSubsequences(int[] nums) {
        int n = nums.length;
        int maxVal = 1001;
        // prefixCount[j][v] = count of indices i <= j-2 with nums[i] == v
        // We'll build on the fly
        long[] prefixCount = new long[maxVal];
        // For each q, we need prefix up to q-2
        // For each r >= q+2, s >= r+2
        // cnt[q][r] = sum over a: prefixCount_before_q-1[a] * suffixCount_after_r+1[a*nums[r]/nums[q]]

        // Build suffix counts for all s positions
        long[][] suffixCount = new long[n + 1][maxVal];
        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(suffixCount[i + 1], 0, suffixCount[i], 0, maxVal);
            suffixCount[i][nums[i]]++;
        }

        long ans = 0;
        // prefix count of p values, p can be used when p <= q-2
        long[] pCount = new long[maxVal]; // count of nums[p] for valid p's

        for (int q = 1; q < n - 2; q++) {
            // Update pCount: add index q-2 as valid p (since p <= q-2)
            if (q >= 2) {
                pCount[nums[q - 2]]++;
            }
            // Now iterate r from q+2 to n-3
            int nq = nums[q];
            for (int r = q + 2; r < n - 1; r++) {
                int nr = nums[r];
                // Need a * nr == b * nq, i.e. a/nq == b/nr
                // a = p value, b = s value
                // s counts: suffixCount[r+2][b]
                int g = gcd(nq, nr);
                int aq = nq / g, ar = nr / g;
                // a must be multiple of aq, b = a/aq * ar
                for (int t = 1; t * aq < maxVal; t++) {
                    int a = t * aq;
                    int b = t * ar;
                    if (b < maxVal) {
                        ans += pCount[a] * suffixCount[r + 2][b];
                    }
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
