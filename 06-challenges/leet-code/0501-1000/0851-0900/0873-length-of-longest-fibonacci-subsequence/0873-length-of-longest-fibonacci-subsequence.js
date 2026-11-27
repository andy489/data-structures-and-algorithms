// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/

var lenLongestFibSubseq = function(arr) {
    const n = arr.length;
    const idx = new Map(arr.map((v, i) => [v, i]));
    const dp = Array.from({length: n}, () => new Array(n).fill(0));
    let ans = 0;
    for (let j = 0; j < n; j++) {
        for (let i = j + 1; i < n; i++) {
            const diff = arr[i] - arr[j];
            if (diff < arr[j] && idx.has(diff)) {
                const k = idx.get(diff);
                dp[j][i] = dp[k][j] + 1;
                ans = Math.max(ans, dp[j][i] + 2);
            }
        }
    }
    return ans;
};
