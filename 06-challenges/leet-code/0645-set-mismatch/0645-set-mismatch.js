// https://leetcode.com/problems/set-mismatch/

var findErrorNums = function(nums) {
    const freq = new Array(nums.length + 1).fill(0);
    for (const num of nums) freq[num]++;
    let duplicate = 0, missing = 0;
    for (let i = 1; i <= nums.length; i++) {
        if (freq[i] === 2) duplicate = i;
        else if (freq[i] === 0) missing = i;
    }
    return [duplicate, missing];
};
