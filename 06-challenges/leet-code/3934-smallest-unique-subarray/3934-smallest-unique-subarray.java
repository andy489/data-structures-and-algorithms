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

// Solution 2: Linear Scan + Sliding Window (prev/next + deques) — O(n²) worst case, O(n) space
class Solution2 {
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
        for (int k = 1; k <= n; k++) {
            if (check(prev, next, k, n)) return k;
        }
        return n;
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
