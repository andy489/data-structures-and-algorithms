// https://leetcode.com/problems/nim-game/

// Solution: Math — O(1) time, O(1) space
var canWinNim = function(n) {
    return n % 4 !== 0;
};
