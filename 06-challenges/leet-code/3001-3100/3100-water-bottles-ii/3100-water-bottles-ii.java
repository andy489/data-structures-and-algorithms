// https://leetcode.com/problems/water-bottles-ii/

// Solution: Simulation — O(sqrt(numBottles)) time, O(1) space
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = numBottles, empties = numBottles;
        while (empties >= numExchange) {
            empties -= numExchange;
            empties++;
            total++;
            numExchange++;
        }
        return total;
    }
}
