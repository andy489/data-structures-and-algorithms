// https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;
        int n = cost.length;
        for (int i = n - 1; i >= 0; i--) {
            if ((n - 1 - i) % 3 == 2) {
                continue;
            }
            total += cost[i];
        }
        return total;
    }
}
