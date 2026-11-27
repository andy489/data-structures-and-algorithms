// https://leetcode.com/problems/find-a-value-of-a-mysterious-function-closest-to-target/

// Solution: Bitwise AND Set Compression — O(n log(max_val)) time, O(log(max_val)) space
class Solution {
    public int closestToTarget(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        // cur stores distinct AND values for subarrays ending at current index
        // We use a TreeMap<value, leftIndex> to track unique AND values
        TreeMap<Integer, Integer> cur = new TreeMap<>();
        for (int x : arr) {
            TreeMap<Integer, Integer> next = new TreeMap<>();
            next.put(x, cur.size()); // new subarray of length 1
            for (Map.Entry<Integer, Integer> e : cur.entrySet()) {
                int v = e.getKey() & x;
                // keep the leftmost start (minimum index) for each AND value
                next.merge(v, e.getValue(), Math::min);
            }
            cur = next;
            for (int v : cur.keySet()) {
                ans = Math.min(ans, Math.abs(v - target));
            }
        }
        return ans;
    }
}
