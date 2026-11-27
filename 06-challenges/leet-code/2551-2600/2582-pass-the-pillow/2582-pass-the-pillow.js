// https://leetcode.com/problems/pass-the-pillow/

/**
 * @param {number} n
 * @param {number} time
 * @return {number}
 */
var passThePillow = function(n, time) {
    const cycle = 2 * (n - 1);
    time = time % cycle;
    if (time < n) {
        return time + 1;
    } else {
        return cycle - time + 1;
    }
};
