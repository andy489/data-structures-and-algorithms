// https://leetcode.com/problems/minimum-moves-to-make-array-complementary/

var minMoves = function(nums, limit) {
    const n = nums.length;
    const diff = new Array(2 * limit + 2).fill(0);
    for (let i = 0; i < n / 2; i++) {
        const a = Math.min(nums[i], nums[n - 1 - i]);
        const b = Math.max(nums[i], nums[n - 1 - i]);
        const s = nums[i] + nums[n - 1 - i];
        diff[2]            += 2;
        diff[2 * limit + 1] -= 2;
        diff[a + 1]         -= 1;
        diff[2 * limit + 1] += 1;
        diff[s]             -= 1;
        diff[s + 1]         += 1;
        diff[b + limit + 1] += 1;
        diff[2 * limit + 1] -= 1;
    }
    let minMoves = Infinity, cur = 0;
    for (let t = 2; t <= 2 * limit; t++) {
        cur += diff[t];
        minMoves = Math.min(minMoves, cur);
    }
    return minMoves;
};
