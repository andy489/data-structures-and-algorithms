// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/

var minStartValue = function(nums) {
    let prefix = 0, minPre = 0;
    for (const n of nums) { prefix += n; minPre = Math.min(minPre, prefix); }
    return Math.max(1, 1 - minPre);
};
