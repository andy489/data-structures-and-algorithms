// https://leetcode.com/problems/smallest-unique-subarray/

// Solution 1: Binary Search + Sliding Window — O(n log n) time, O(n) space
class Solution {
    public int minUniqueSubarrayLength(int[] nums) {
        int n = nums.length, lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (hasUniqueSubarray(nums, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean hasUniqueSubarray(int[] nums, int k) {
        Map<String, Integer> freq = new HashMap<>();
        ArrayDeque<Integer> win = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            win.addLast(nums[i]);
            if (win.size() == k) {
                String key = win.toString();
                freq.merge(key, 1, Integer::sum);
                win.pollFirst();
            }
        }
        for (int cnt : freq.values()) {
            if (cnt == 1) return true;
        }
        return false;
    }
}

// Solution 2: Linear Scan — O(n²) time, O(n) space
class Solution2 {
    public int minUniqueSubarrayLength(int[] nums) {
        int n = nums.length;
        for (int k = 1; k <= n; k++) {
            Map<String, Integer> freq = new HashMap<>();
            ArrayDeque<Integer> win = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                win.addLast(nums[i]);
                if (win.size() == k) {
                    freq.merge(win.toString(), 1, Integer::sum);
                    win.pollFirst();
                }
            }
            for (int cnt : freq.values()) {
                if (cnt == 1) return k;
            }
        }
        return n;
    }
}
