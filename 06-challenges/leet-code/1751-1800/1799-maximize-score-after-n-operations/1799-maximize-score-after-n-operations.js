// https://leetcode.com/problems/maximize-score-after-n-operations/

var maxScore = function(nums) {
    const m = nums.length;
    const gcds = Array.from({length: m}, () => new Array(m).fill(0));

    function gcd(a, b) {
        while (b) { [a, b] = [b, a % b]; }
        return a;
    }

    for (let i = 0; i < m; i++) {
        for (let j = i + 1; j < m; j++) {
            gcds[i][j] = gcd(nums[i], nums[j]);
        }
    }

    const dp = new Array(1 << m).fill(0);
    for (let mask = 0; mask < (1 << m); mask++) {
        const cnt = mask.toString(2).split('0').join('').length;
        if (cnt % 2 !== 0) continue;
        const op = cnt / 2 + 1;
        for (let i = 0; i < m; i++) {
            if (!(mask >> i & 1)) continue;
            for (let j = i + 1; j < m; j++) {
                if (!(mask >> j & 1)) continue;
                const prev = mask ^ (1 << i) ^ (1 << j);
                dp[mask] = Math.max(dp[mask], dp[prev] + op * gcds[i][j]);
            }
        }
    }
    return dp[(1 << m) - 1];
};
