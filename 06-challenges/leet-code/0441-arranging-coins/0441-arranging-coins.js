// https://leetcode.com/problems/arranging-coins/

var arrangeCoins = function(n) {
    return Math.floor((-1 + Math.sqrt(1 + 8 * n)) / 2);
};
