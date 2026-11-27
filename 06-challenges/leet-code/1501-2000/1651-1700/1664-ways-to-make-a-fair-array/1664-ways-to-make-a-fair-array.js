// https://leetcode.com/problems/ways-to-make-a-fair-array/

var waysToMakeFair = function(nums) {
    let totalEven = 0, totalOdd = 0;
    for (let i = 0; i < nums.length; i++) {
        if (i % 2 === 0) {
            totalEven += nums[i];
        } else {
            totalOdd += nums[i];
        }
    }
    let prefixEven = 0, prefixOdd = 0, count = 0;
    for (let i = 0; i < nums.length; i++) {
        const remEven = totalEven - prefixEven - (i % 2 === 0 ? nums[i] : 0);
        const remOdd  = totalOdd  - prefixOdd  - (i % 2 === 1 ? nums[i] : 0);
        if (prefixEven + remOdd === prefixOdd + remEven) {
            count++;
        }
        if (i % 2 === 0) {
            prefixEven += nums[i];
        } else {
            prefixOdd += nums[i];
        }
    }
    return count;
};
