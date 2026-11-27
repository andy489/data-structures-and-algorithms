// https://leetcode.com/problems/delete-and-earn/

var deleteAndEarn = function(nums) {
    const maxVal = Math.max(...nums);
    const earn = new Array(maxVal + 1).fill(0);
    for (const n of nums) earn[n] += n;
    let prev2 = 0, prev1 = 0;
    for (let i = 1; i <= maxVal; i++) {
        const cur = Math.max(prev1, prev2 + earn[i]);
        prev2 = prev1;
        prev1 = cur;
    }
    return prev1;
};
