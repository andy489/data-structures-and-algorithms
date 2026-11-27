// https://leetcode.com/problems/find-unique-binary-string/

// Solution: Cantor's Diagonal — O(n) time, O(n) space
var findDifferentBinaryString = function(nums) {
    return nums.map((s, i) => s[i] === '0' ? '1' : '0').join('');
};
