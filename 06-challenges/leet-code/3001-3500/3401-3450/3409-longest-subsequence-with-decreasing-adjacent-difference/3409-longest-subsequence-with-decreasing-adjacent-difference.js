// https://leetcode.com/problems/longest-subsequence-with-decreasing-adjacent-difference/
var longestSubsequence = function(nums) {
    const MAX_VAL = 301;
    const suffMax = Array.from({length: MAX_VAL}, () => new Array(MAX_VAL).fill(0));
    let ans = 1;

    for (const num of nums) {
        const curBest = new Array(MAX_VAL).fill(0);
        for (let v = 0; v < MAX_VAL; v++) {
            const diff = Math.abs(num - v);
            if (diff < MAX_VAL && suffMax[v][diff] > 0) {
                const candidate = suffMax[v][diff] + 1;
                if (candidate > curBest[diff]) {
                    curBest[diff] = candidate;
                }
            }
        }

        for (let d = 0; d < MAX_VAL; d++) {
            const val = curBest[d] > 0 ? curBest[d] : 1;
            if (val > suffMax[num][d]) {
                suffMax[num][d] = val;
            }
        }

        for (let d = MAX_VAL - 2; d >= 0; d--) {
            if (suffMax[num][d + 1] > suffMax[num][d]) {
                suffMax[num][d] = suffMax[num][d + 1];
            }
            if (suffMax[num][d] > ans) {
                ans = suffMax[num][d];
            }
        }
        if (suffMax[num][MAX_VAL - 1] > ans) {
            ans = suffMax[num][MAX_VAL - 1];
        }
    }
    return ans;
};
