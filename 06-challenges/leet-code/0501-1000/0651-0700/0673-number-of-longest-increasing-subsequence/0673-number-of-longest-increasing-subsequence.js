// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

var findNumberOfLIS = function(nums) {
    const n = nums.length;
    const len = new Array(n).fill(1);
    const cnt = new Array(n).fill(1);
    let maxLen = 1;
    for (let i = 1; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                if (len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    cnt[i] = cnt[j];
                } else if (len[j] + 1 === len[i]) {
                    cnt[i] += cnt[j];
                }
            }
        }
        maxLen = Math.max(maxLen, len[i]);
    }
    let result = 0;
    for (let i = 0; i < n; i++) {
        if (len[i] === maxLen) result += cnt[i];
    }
    return result;
};
