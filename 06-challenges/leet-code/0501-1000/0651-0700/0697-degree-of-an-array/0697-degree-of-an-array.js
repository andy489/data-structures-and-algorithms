// https://leetcode.com/problems/degree-of-an-array/

var findShortestSubArray = function(nums) {
    const count = {}, first = {}, last = {};
    for (let i = 0; i < nums.length; i++) {
        const v = nums[i];
        count[v] = (count[v] || 0) + 1;
        if (!(v in first)) first[v] = i;
        last[v] = i;
    }
    const degree = Math.max(...Object.values(count));
    let minLen = nums.length;
    for (const v of Object.keys(count)) {
        if (count[v] === degree) minLen = Math.min(minLen, last[v] - first[v] + 1);
    }
    return minLen;
};
