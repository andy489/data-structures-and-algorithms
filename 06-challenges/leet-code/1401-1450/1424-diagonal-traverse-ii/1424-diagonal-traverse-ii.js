// https://leetcode.com/problems/diagonal-traverse-ii/

var findDiagonalOrder = function(nums) {
    const diag = new Map();
    for (let i = nums.length-1; i >= 0; i--)
        for (let j = 0; j < nums[i].length; j++) {
            const k = i+j;
            if (!diag.has(k)) diag.set(k, []);
            diag.get(k).push(nums[i][j]);
        }
    const res = [];
    for (let d = 0; ; d++) {
        if (!diag.has(d)) break;
        res.push(...diag.get(d));
    }
    return res;
};
