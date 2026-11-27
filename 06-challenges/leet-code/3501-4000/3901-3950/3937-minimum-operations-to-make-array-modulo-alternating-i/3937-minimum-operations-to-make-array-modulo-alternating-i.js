// https://leetcode.com/problems/minimum-operations-to-make-array-modulo-alternating-i/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minimumOperations = function(nums, k) {
    const evenFreq = new Array(k).fill(0);
    const oddFreq = new Array(k).fill(0);
    for (let i = 0; i < nums.length; i++) {
        if (i % 2 === 0) {
            evenFreq[nums[i] % k]++;
        } else {
            oddFreq[nums[i] % k]++;
        }
    }
    const evenTotal = Math.ceil(nums.length / 2);
    const oddTotal = Math.floor(nums.length / 2);
    let minOps = Infinity;
    for (let x = 0; x < k; x++) {
        for (let y = 0; y < k; y++) {
            if (x === y) {
                continue;
            }
            const cost = (evenTotal - evenFreq[x]) + (oddTotal - oddFreq[y]);
            minOps = Math.min(minOps, cost);
        }
    }
    return minOps;
};
