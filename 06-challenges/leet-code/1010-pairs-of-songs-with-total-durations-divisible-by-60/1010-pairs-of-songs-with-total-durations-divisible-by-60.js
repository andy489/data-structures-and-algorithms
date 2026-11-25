// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

var numPairsDivisibleBy60 = function(time) {
    const count = new Array(60).fill(0);
    let ans = 0;
    for (const t of time) {
        const r = t % 60;
        ans += count[(60 - r) % 60];
        count[r]++;
    }
    return ans;
};
