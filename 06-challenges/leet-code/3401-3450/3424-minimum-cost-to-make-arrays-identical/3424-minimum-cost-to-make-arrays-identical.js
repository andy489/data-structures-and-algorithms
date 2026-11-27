// https://leetcode.com/problems/minimum-cost-to-make-arrays-identical/

/**
 * @param {number[]} arr
 * @param {number[]} brr
 * @param {number} k
 * @return {number}
 */
var minCost = function(arr, brr, k) {
    const n = arr.length;
    let costNoSort = 0;
    for (let i = 0; i < n; i++) {
        costNoSort += Math.abs(arr[i] - brr[i]);
    }
    const sortedArr = [...arr].sort((a, b) => a - b);
    const sortedBrr = [...brr].sort((a, b) => a - b);
    let costWithSort = k;
    for (let i = 0; i < n; i++) {
        costWithSort += Math.abs(sortedArr[i] - sortedBrr[i]);
    }
    return Math.min(costNoSort, costWithSort);
};
