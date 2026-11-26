// https://leetcode.com/problems/jump-game-ii/

var jump = function(nums) {
    let jumps = 0, curEnd = 0, farthest = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if (i === curEnd) {         // exhausted current jump's range: must jump
            jumps++;
            curEnd = farthest;
            if (curEnd >= nums.length - 1) {
                break;
            }
        }
    }
    return jumps;
};
