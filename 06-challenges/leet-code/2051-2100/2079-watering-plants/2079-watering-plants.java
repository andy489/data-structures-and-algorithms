// https://leetcode.com/problems/watering-plants/

// Solution: Simulation — O(n) time, O(1) space
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0, water = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (water < plants[i]) { steps += 2 * i; water = capacity; }
            steps++;
            water -= plants[i];
        }
        return steps;
    }
}
