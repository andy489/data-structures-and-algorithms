// https://leetcode.com/problems/good-subsequence-queries/
class Solution {
    public int goodSubsequenceQueries(int[] nums, int p, int[][] queries) {
        int n = nums.length;
        int maxVal = 50001;
        int[] cnt = new int[maxVal];
        for (int v : nums) {
            cnt[v]++;
        }
        int result = 0;
        for (int[] q : queries) {
            cnt[nums[q[0]]]--;
            nums[q[0]] = q[1];
            cnt[q[1]]++;
            if (hasGoodSubsequence(cnt, n, p, maxVal)) {
                result++;
            }
        }
        return result;
    }

    private boolean hasGoodSubsequence(int[] cnt, int n, int p, int maxVal) {
        // Count elements divisible by p
        int countP = 0;
        int g = 0;
        for (int m = p; m < maxVal; m += p) {
            if (cnt[m] > 0) {
                countP += cnt[m];
                g = gcd(g, m / p);
            }
        }
        // Need at least 2 multiples of p, GCD of (multiples/p) = 1,
        // and subset size < n (always possible if countP >= 2 and countP < n,
        // or if countP >= n but we can drop one that is "extra" - actually length < n means we need at most n-1 elements)
        if (countP < 2) {
            return false;
        }
        if (g != 1) {
            return false;
        }
        // We need a subset of length < n with GCD exactly p
        // If countP < n: take all countP elements (gcd = p), length = countP < n. Valid.
        // If countP == n: we need to drop at least one element. Drop a non-p-multiple? There are none.
        //   So drop one p-multiple. Need remaining n-1 elements to still have GCD p.
        //   GCD of n-1 elements: could be p or more.
        //   Since overall GCD is p (g=1), dropping one element might increase GCD.
        //   We need to check if there exist n-1 elements with GCD = p.
        if (countP < n) {
            return true;
        }
        // All n elements are multiples of p. Check if any n-1 elements have GCD = p.
        // Check for each distinct value v divisible by p: remove one occurrence and check GCD of rest.
        int maxVal2 = cnt.length;
        for (int m = p; m < maxVal2; m += p) {
            if (cnt[m] > 0) {
                // Remove one occurrence of m, check GCD of remaining
                int tempG = 0;
                for (int m2 = p; m2 < maxVal2; m2 += p) {
                    int c = cnt[m2];
                    if (m2 == m) {
                        c--;
                    }
                    if (c > 0) {
                        tempG = gcd(tempG, m2 / p);
                    }
                }
                if (tempG == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
