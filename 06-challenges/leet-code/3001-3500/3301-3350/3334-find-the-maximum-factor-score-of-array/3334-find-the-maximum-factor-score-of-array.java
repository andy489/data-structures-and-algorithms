// https://leetcode.com/problems/find-the-maximum-factor-score-of-array/

class Solution {
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public long maxScore(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return (long) nums[0] * nums[0];
        }

        long[] prefGcd = new long[n + 1];
        long[] prefLcm = new long[n + 1];
        long[] sufGcd = new long[n + 1];
        long[] sufLcm = new long[n + 1];

        prefGcd[0] = 0; prefLcm[0] = 1;
        for (int i = 0; i < n; i++) {
            prefGcd[i + 1] = gcd(prefGcd[i], nums[i]);
            prefLcm[i + 1] = (prefLcm[i] == 0) ? nums[i] : lcm(prefLcm[i], nums[i]);
        }
        sufGcd[n] = 0; sufLcm[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            sufGcd[i] = gcd(sufGcd[i + 1], nums[i]);
            sufLcm[i] = (sufLcm[i + 1] == 1 && i == n - 1) ? nums[i] : lcm(sufLcm[i + 1], nums[i]);
        }

        // Fix prefix lcm initialization
        prefLcm[0] = 0;
        for (int i = 0; i < n; i++) {
            prefLcm[i + 1] = (prefLcm[i] == 0) ? nums[i] : lcm(prefLcm[i], nums[i]);
        }
        sufLcm[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            sufLcm[i] = (sufLcm[i + 1] == 0) ? nums[i] : lcm(sufLcm[i + 1], nums[i]);
        }

        long ans = prefGcd[n] * prefLcm[n]; // no removal
        for (int i = 0; i < n; i++) {
            long g = gcd(prefGcd[i], sufGcd[i + 1]);
            long l;
            if (prefLcm[i] == 0) {
                l = sufLcm[i + 1];
            } else if (sufLcm[i + 1] == 0) {
                l = prefLcm[i];
            } else {
                l = lcm(prefLcm[i], sufLcm[i + 1]);
            }
            ans = Math.max(ans, g * l);
        }
        return ans;
    }
}
