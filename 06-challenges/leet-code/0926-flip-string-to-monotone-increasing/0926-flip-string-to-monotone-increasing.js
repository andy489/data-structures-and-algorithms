// https://leetcode.com/problems/flip-string-to-monotone-increasing/

var minFlipsMonoIncr = function(s) {
    let ones = 0, flips = 0;
    for (const c of s) {
        if (c === '1') ones++;
        else flips = Math.min(flips + 1, ones);
    }
    return flips;
};
