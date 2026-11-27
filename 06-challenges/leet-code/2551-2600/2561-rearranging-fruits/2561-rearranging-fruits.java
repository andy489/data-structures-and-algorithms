// https://leetcode.com/problems/rearranging-fruits/

// Solution: Frequency Counting + Greedy — O(n log n) time, O(n) space
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : basket1) {
            count.merge(x, 1, Integer::sum);
        }
        for (int x : basket2) {
            count.merge(x, -1, Integer::sum);
        }
        int globalMin = Integer.MAX_VALUE;
        for (int x : basket1) {
            globalMin = Math.min(globalMin, x);
        }
        for (int x : basket2) {
            globalMin = Math.min(globalMin, x);
        }
        List<Integer> extra = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int diff = entry.getValue();
            if (diff % 2 != 0) {
                return -1;
            }
            for (int i = 0; i < Math.abs(diff) / 2; i++) {
                extra.add(entry.getKey());
            }
        }
        Collections.sort(extra);
        long cost = 0;
        int m = extra.size();
        for (int i = 0; i < m / 2; i++) {
            cost += Math.min(extra.get(i), 2L * globalMin);
        }
        return cost;
    }
}
