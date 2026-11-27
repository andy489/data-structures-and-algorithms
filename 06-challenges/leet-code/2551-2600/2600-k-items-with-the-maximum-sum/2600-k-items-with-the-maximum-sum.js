// https://leetcode.com/problems/k-items-with-the-maximum-sum/
/**
 * @param {number} numOnes
 * @param {number} numZeros
 * @param {number} numNegOnes
 * @param {number} k
 * @return {number}
 */
var kItemsWithMaximumSum = function(numOnes, numZeros, numNegOnes, k) {
    const ones = Math.min(k, numOnes);
    k -= ones;
    const zeros = Math.min(k, numZeros);
    k -= zeros;
    return ones - k;
};
