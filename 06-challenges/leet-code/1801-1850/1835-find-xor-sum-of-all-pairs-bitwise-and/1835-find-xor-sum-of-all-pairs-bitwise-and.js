// https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/

var getXORSum = function(arr1, arr2) {
    const xor1 = arr1.reduce((a, b) => a ^ b, 0);
    const xor2 = arr2.reduce((a, b) => a ^ b, 0);
    return xor1 & xor2;
};
