// https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
var earliestFullBloom = function(plantTime, growTime) {
    const n = plantTime.length;
    const indices = Array.from({length: n}, (_, i) => i);
    indices.sort((a, b) => growTime[b] - growTime[a]);
    let currentDay = 0, maxBloom = 0;
    for (const i of indices) {
        currentDay += plantTime[i];
        maxBloom = Math.max(maxBloom, currentDay + growTime[i]);
    }
    return maxBloom;
};
