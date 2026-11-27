// https://leetcode.com/problems/water-bottles/

// Solution: Simulation — O(log(numBottles)/log(numExchange)) time, O(1) space
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk = 0, empty = 0;
        while (numBottles > 0) {
            drunk += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty = empty % numExchange;
        }
        return drunk;
    }
}
