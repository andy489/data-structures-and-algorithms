// https://leetcode.com/problems/xor-operation-in-an-array/

var xorOperation = function(n, start) {
    let res = 0;
    for (let i = 0; i < n; i++) res ^= start + 2 * i;
    return res;
};
