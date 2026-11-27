// https://leetcode.com/problems/count-the-number-of-beautiful-subarrays/
/**
 * @param {number[]} nums
 * @return {number}
 */
var beautifulSubarrays = function(nums) {
    const prefixCount = new Map([[0, 1]]);
    let xor = 0, result = 0;
    for (const num of nums) {
        xor ^= num;
        result += (prefixCount.get(xor) || 0);
        prefixCount.set(xor, (prefixCount.get(xor) || 0) + 1);
    }
    return result;
};
