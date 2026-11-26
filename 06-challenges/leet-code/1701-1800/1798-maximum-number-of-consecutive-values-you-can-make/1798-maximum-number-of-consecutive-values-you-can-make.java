// https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/

// Solution: Greedy Sort — O(n log n) time, O(1) space
class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int reach = 0;
        for (int c : coins) {
            if (c > reach + 1) {
                break;
            }
            reach += c;
        }
        return reach + 1;
    }
}
