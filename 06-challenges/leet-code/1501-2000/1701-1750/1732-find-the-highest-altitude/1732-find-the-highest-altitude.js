// https://leetcode.com/problems/find-the-highest-altitude/

var largestAltitude = function(gain) {
    let altitude = 0, maxAlt = 0;
    for (const g of gain) {
        altitude += g;
        maxAlt = Math.max(maxAlt, altitude);
    }
    return maxAlt;
};
