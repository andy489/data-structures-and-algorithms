// https://leetcode.com/problems/intersection-of-multiple-arrays/

/**
 * @param {number[][]} nums
 * @return {number[]}
 */
var intersection = function (nums) {
    const count = new Array(1001).fill(0);
    for (const arr of nums) {
        for (const v of arr) {
            count[v]++;
        }
    }
    const result = [];
    for (let i = 1; i <= 1000; i++) {
        if (count[i] === nums.length) {
            result.push(i);
        }
    }
    return result;
};
