// https://leetcode.com/problems/make-array-strictly-increasing/

// Solution: DP with Binary Search — O(n·m·log m) time, O(n·m) space
class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        // Deduplicate arr2
        int[] sorted = Arrays.stream(arr2).distinct().toArray();

        // cloned: ops used -> minimum last value
        Map<Integer, Integer> cloned = new HashMap<>();
        cloned.put(0, -1);

        for (int val : arr1) {
            Map<Integer, Integer> next = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : cloned.entrySet()) {
                int ops = entry.getKey();
                int last = entry.getValue();
                // Option 1: keep val
                if (val > last) {
                    int cur = next.getOrDefault(ops, Integer.MAX_VALUE);
                    next.put(ops, Math.min(cur, val));
                }
                // Option 2: replace val with smallest sorted[j] > last
                int idx = upperBound(sorted, last);
                if (idx < sorted.length) {
                    int cur = next.getOrDefault(ops + 1, Integer.MAX_VALUE);
                    next.put(ops + 1, Math.min(cur, sorted[idx]));
                }
            }
            cloned = next;
            if (cloned.isEmpty()) {
                return -1;
            }
        }
        return Collections.min(cloned.keySet());
    }

    private int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
