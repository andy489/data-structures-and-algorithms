// https://leetcode.com/problems/minimum-increase-to-maximize-special-indices/
/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumIncreaseToMaximizeSpecialIndices = function(nums) {
    const n = nums.length;
    const arr = [...nums];
    let ops = 0;
    let i = 1;

    while (i < n - 1) {
        const needed = Math.max(arr[i - 1], arr[i + 1]) + 1 - arr[i];
        if (needed > 0) {
            ops += needed;
            arr[i] += needed;
        }
        // If i is now special, skip i+1
        if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
            i += 2;
        } else {
            i++;
        }
    }
    return ops;
};
