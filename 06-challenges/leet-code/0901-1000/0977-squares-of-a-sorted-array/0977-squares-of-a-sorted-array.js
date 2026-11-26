// https://leetcode.com/problems/squares-of-a-sorted-array/

var sortedSquares = function(nums) {
    const n = nums.length, res = new Array(n);
    let lo = 0, hi = n - 1, pos = n - 1;
    while (lo <= hi) {
        const l = nums[lo]**2, r = nums[hi]**2;
        if (l >= r) { res[pos--] = l; lo++; }
        else { res[pos--] = r; hi--; }
    }
    return res;
};
