// https://leetcode.com/problems/binary-prefix-divisible-by-5/

var prefixesDivBy5 = function(nums) {
    let cur = 0;
    return nums.map(b => { cur = (cur * 2 + b) % 5; return cur === 0; });
};
