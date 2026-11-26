// https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/

var minOperations = function(k) {
    if (k === 1) return 0;
    let ans = k - 1;
    for (let i = 0; i < k; i++) {
        const val = i + 1;
        let j = 0;
        while (val * Math.pow(2, j) < k) j++;
        ans = Math.min(ans, i + j);
    }
    return ans;
};
