// https://leetcode.com/problems/smallest-unique-subarray/

// Solution 1: Binary Search + Rolling Hash — O(n log n) time, O(n) space
class Solution {
    private static final long MOD = (1L << 61) - 1;
    private static final long BASE = 100003;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length, lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (hasUniqueSubarray(nums, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean hasUniqueSubarray(int[] nums, int k) {
        int n = nums.length;
        long pw = 1;
        for (int i = 0; i < k; i++) pw = mul(pw, BASE);
        long h = 0;
        for (int i = 0; i < k; i++) h = add(mul(h, BASE), nums[i] + 1);
        Map<Long, Integer> freq = new HashMap<>();
        freq.merge(h, 1, Integer::sum);
        for (int i = k; i < n; i++) {
            h = add(mul(h, BASE), nums[i] + 1);
            h = sub(h, mul(pw, nums[i - k] + 1));
            freq.merge(h, 1, Integer::sum);
        }
        for (int cnt : freq.values()) if (cnt == 1) return true;
        return false;
    }

    private long mul(long a, long b) {
        long hi = Math.multiplyHigh(a, b);
        long lo = a * b;
        long res = (hi << 3) | (lo >>> 61);
        res += lo & MOD;
        if (res >= MOD) res -= MOD;
        return res;
    }

    private long add(long a, long b) {
        a += b;
        if (a >= MOD) a -= MOD;
        return a;
    }

    private long sub(long a, long b) {
        a -= b;
        if (a < 0) a += MOD;
        return a;
    }
}

// Solution 2: Linear Scan + HashMap — O(n²) time, O(n) space
class Solution2 {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        for (int k = 1; k <= n; k++) {
            Map<String, Integer> freq = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) sb.append(nums[i]).append(',');
            freq.merge(sb.toString(), 1, Integer::sum);
            for (int i = k; i < n; i++) {
                sb.delete(0, sb.indexOf(",") + 1);
                sb.append(nums[i]).append(',');
                freq.merge(sb.toString(), 1, Integer::sum);
            }
            for (int cnt : freq.values()) if (cnt == 1) return k;
        }
        return n;
    }
}
