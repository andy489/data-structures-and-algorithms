// https://leetcode.com/problems/distance-between-bus-stops/

// Solution: Prefix Sum (Two-Direction Scan) — O(n) time, O(1) space
var distanceBetweenBusStops = function(distance, start, destination) {
    if (start > destination) {
        [start, destination] = [destination, start];
    }
    const total = distance.reduce((a, b) => a + b, 0);
    let clockwise = 0;
    for (let i = start; i < destination; i++) {
        clockwise += distance[i];
    }
    return Math.min(clockwise, total - clockwise);
};
