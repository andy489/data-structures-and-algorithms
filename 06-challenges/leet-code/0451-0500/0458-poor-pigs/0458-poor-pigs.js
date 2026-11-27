// https://leetcode.com/problems/poor-pigs/

// Solution: Math (Base Encoding) — O(log(buckets) / log(rounds+1)) time, O(1) space
var poorPigs = function(buckets, minutesToDie, minutesToTest) {
    const rounds = Math.floor(minutesToTest / minutesToDie);
    let pigs = 0;
    while (Math.pow(rounds + 1, pigs) < buckets) {
        pigs++;
    }
    return pigs;
};
