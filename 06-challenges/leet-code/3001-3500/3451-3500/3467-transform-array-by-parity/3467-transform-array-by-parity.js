// https://leetcode.com/problems/transform-array-by-parity/

var transformArray = function(nums) {
    const oddCount = nums.filter(x => x % 2 !== 0).length;
    const n = nums.length;
    const result = new Array(n).fill(0);
    for (let i = n - oddCount; i < n; i++) {
        result[i] = 1;
    }
    return result;
};
