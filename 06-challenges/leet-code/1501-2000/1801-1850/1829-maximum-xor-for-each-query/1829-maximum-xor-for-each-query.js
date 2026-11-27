// https://leetcode.com/problems/maximum-xor-for-each-query/

var getMaximumXor = function(nums, maximumBit) {
    const mask = (1 << maximumBit) - 1;
    let xorAll = nums.reduce((a, b) => a ^ b, 0);
    const ans = [];
    for (let i = nums.length - 1; i >= 0; i--) {
        ans.push(xorAll ^ mask);
        xorAll ^= nums[i];
    }
    return ans;
};
