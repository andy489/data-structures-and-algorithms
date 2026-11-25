// https://leetcode.com/problems/smallest-unique-subarray/

// Solution 1: Binary Search + Sliding Window (prev/next + deques) — O(n log n) time, O(n) space
class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n], next = new int[n];
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            prev[i] = last.getOrDefault(nums[i], -1);
            last.put(nums[i], i);
        }
        last.clear();
        for (int i = n - 1; i >= 0; i--) {
            next[i] = last.getOrDefault(nums[i], n);
            last.put(nums[i], i);
        }
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (check(prev, next, mid, n)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean check(int[] prev, int[] next, int k, int n) {
        ArrayDeque<Integer> maxDq = new ArrayDeque<>();
        ArrayDeque<Integer> minDq = new ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            while (!maxDq.isEmpty() && prev[maxDq.peekLast()] <= prev[r]) maxDq.pollLast();
            maxDq.addLast(r);
            while (!minDq.isEmpty() && next[minDq.peekLast()] >= next[r]) minDq.pollLast();
            minDq.addLast(r);
            if (r >= k - 1) {
                int l = r - k + 1;
                if (maxDq.peekFirst() < l) maxDq.pollFirst();
                if (minDq.peekFirst() < l) minDq.pollFirst();
                if (prev[maxDq.peekFirst()] < l && next[minDq.peekFirst()] > r) return true;
            }
        }
        return false;
    }
}

// Solution 2: Binary Search + Rolling Hash — O(n log n) time, O(n) space
class Solution2 {
    private static final long MOD = (1L << 61) - 1;
    private static final long BASE = 131;

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
        long[] pw = new long[k + 1];
        pw[0] = 1;
        for (int i = 1; i <= k; i++) pw[i] = mul(pw[i - 1], BASE);
        long[] h = new long[n + 1];
        for (int i = 0; i < n; i++) h[i + 1] = mul(h[i], BASE) ^ nums[i];
        Map<Long, Integer> freq = new HashMap<>();
        for (int i = 0; i + k <= n; i++) {
            long key = h[i + k] ^ mul(h[i], pw[k]);
            freq.merge(key, 1, Integer::sum);
        }
        for (int cnt : freq.values()) {
            if (cnt == 1) return true;
        }
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
}
