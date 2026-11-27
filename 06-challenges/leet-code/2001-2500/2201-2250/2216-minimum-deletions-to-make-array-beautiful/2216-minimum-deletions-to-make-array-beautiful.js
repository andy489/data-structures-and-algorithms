// https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/
var minDeletion = function (nums) {
    let deletions = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        if ((i - deletions) % 2 === 0 && nums[i] === nums[i + 1]) {
            deletions++;
        }
    }
    if ((nums.length - deletions) % 2 !== 0) {
        deletions++;
    }
    return deletions;
};
