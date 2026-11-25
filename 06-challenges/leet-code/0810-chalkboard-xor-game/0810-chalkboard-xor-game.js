// https://leetcode.com/problems/chalkboard-xor-game/

var xorGame = function(nums) {
    const xor = nums.reduce((a, b) => a ^ b, 0);
    return xor === 0 || nums.length % 2 === 0;
};
