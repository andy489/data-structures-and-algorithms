// https://leetcode.com/problems/watering-plants/

// Solution: Simulation — O(n) time, O(1) space
var wateringPlants = function(plants, capacity) {
    let steps = 0, water = capacity;
    for (let i = 0; i < plants.length; i++) {
        if (water < plants[i]) { steps += 2 * i; water = capacity; }
        steps++;
        water -= plants[i];
    }
    return steps;
};
