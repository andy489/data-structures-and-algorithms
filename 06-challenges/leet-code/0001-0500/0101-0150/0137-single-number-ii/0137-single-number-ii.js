// https://leetcode.com/problems/single-number-ii/

// Solution 1: Bit count per position — O(n) time, O(1) space
var singleNumber = function(nums) {
    let ans = 0;
    for (let b = 0; b < 32; b++) {
        let count = 0;
        for (const n of nums) count += (n >> b) & 1;
        if (count % 3 !== 0) ans |= (1 << b);
    }
    return ans;
};

// Solution 2: ones/twos bit trick — O(n) time, O(1) space
var singleNumber2 = function(nums) {
    let ones = 0, twos = 0;
    for (const x of nums) {
        ones = (ones ^ x) & ~twos;
        twos = (twos ^ x) & ~ones;
    }
    return ones;
};
