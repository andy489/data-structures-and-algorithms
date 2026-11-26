// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

// Solution: Greedy with Sorted Map — O(n log n) time, O(n) space
// Solution: Greedy with Sorted Map — O(n log n) time, O(n) space
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int x : nums) count.merge(x, 1, Integer::sum);
        while (!count.isEmpty()) {
            int start = count.firstKey();
            for (int i = start; i < start + k; i++) {
                if (!count.containsKey(i)) return false;
                if (count.get(i) == 1) count.remove(i);
                else count.merge(i, -1, Integer::sum);
            }
        }
        return true;
    }
}
