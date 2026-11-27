// https://leetcode.com/problems/majority-element/

var majorityElement = function(nums) {
    let candidate = nums[0], count = 0;
    for (const num of nums) {
        if (count === 0) candidate = num;
        count += num === candidate ? 1 : -1;
    }
    return candidate;
};

var majorityElement2 = function(nums) {
    const freq = new Map();
    const half = nums.length >> 1;
    for (const num of nums) {
        const c = (freq.get(num) ?? 0) + 1;
        if (c > half) return num;
        freq.set(num, c);
    }
};

var majorityElement3 = function(nums) {
    nums.sort((a, b) => a - b);
    return nums[nums.length >> 1];
};
