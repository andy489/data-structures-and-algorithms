// https://leetcode.com/problems/two-city-scheduling/

// Solution: Greedy Sort — O(n log n) time, O(1) space
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int total = 0, n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            total += costs[i][1];
        }
        for (int i = n; i < 2 * n; i++) {
            total += costs[i][0];
        }
        return total;
    }
}
