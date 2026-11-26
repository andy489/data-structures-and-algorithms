// https://leetcode.com/problems/minimum-suffix-flips/

var minFlips = function(target) {
    let flips = 0;
    let current = '0';
    for (const c of target) {
        if (c !== current) {
            flips++;
            current = c;
        }
    }
    return flips;
};
