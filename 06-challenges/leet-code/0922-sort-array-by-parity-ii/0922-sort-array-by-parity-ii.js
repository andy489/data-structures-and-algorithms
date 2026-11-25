// https://leetcode.com/problems/sort-array-by-parity-ii/

var sortArrayByParityII = function(nums) {
    let odd = 1;
    for (let even = 0; even < nums.length; even += 2) {
        if (nums[even] % 2 === 1) {
            while (nums[odd] % 2 === 1) odd += 2;
            [nums[even], nums[odd]] = [nums[odd], nums[even]];
        }
    }
    return nums;
};
