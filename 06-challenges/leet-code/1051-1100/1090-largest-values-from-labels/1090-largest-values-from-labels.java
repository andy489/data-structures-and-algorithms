// https://leetcode.com/problems/largest-values-from-labels/

// Solution: Greedy + Frequency Map — O(n log n) time, O(n) space
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> values[b] - values[a]);
        Map<Integer, Integer> labelCount = new HashMap<>();
        int sum = 0, chosen = 0;
        for (int i : idx) {
            if (chosen >= numWanted) break;
            int lbl = labels[i];
            if (labelCount.getOrDefault(lbl, 0) < useLimit) {
                sum += values[i];
                labelCount.merge(lbl, 1, Integer::sum);
                chosen++;
            }
        }
        return sum;
    }
}
