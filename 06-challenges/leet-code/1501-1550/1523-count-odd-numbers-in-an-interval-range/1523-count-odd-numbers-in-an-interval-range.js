// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

var countOdds = function(low, high) {
    return Math.floor((high + 1) / 2) - Math.floor(low / 2);
};
