// https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxGoodNumber = function (nums) {
    const perms = [];
    function permute(arr, cur) {
        if (cur.length === arr.length) {
            perms.push([...cur]);
            return;
        }
        for (let i = 0; i < arr.length; i++) {
            if (cur.includes(i)) {
                continue;
            }
            cur.push(i);
            permute(arr, cur);
            cur.pop();
        }
    }
    permute(nums, []);

    let best = 0;
    for (const perm of perms) {
        let val = 0;
        for (const idx of perm) {
            const bits = Math.floor(Math.log2(nums[idx])) + 1;
            val = (val << bits) | nums[idx];
        }
        best = Math.max(best, val);
    }
    return best;
};
