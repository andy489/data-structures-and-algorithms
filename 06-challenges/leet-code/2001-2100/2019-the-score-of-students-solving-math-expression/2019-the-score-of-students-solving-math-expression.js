// https://leetcode.com/problems/the-score-of-students-solving-math-expression/

// Solution: Interval DP — O(n^3*S^2) time, O(n^2*S) space
var scoreOfStudents = function(s, answers) {
    const nums = s.split('').filter(c => /\d/.test(c)).map(Number);
    const ops = s.split('').filter(c => c === '+' || c === '*');
    const n = nums.length;
    const dp = Array.from({length: n}, () => Array.from({length: n}, () => new Set()));
    for (let i = 0; i < n; i++) dp[i][i].add(nums[i]);
    for (let len = 2; len <= n; len++) {
        for (let i = 0; i <= n - len; i++) {
            const j = i + len - 1;
            for (let k = i; k < j; k++) {
                for (const a of dp[i][k]) {
                    for (const b of dp[k+1][j]) {
                        const v = ops[k] === '+' ? a + b : a * b;
                        if (v <= 1000) dp[i][j].add(v);
                    }
                }
            }
        }
    }
    const correct = eval(s);
    let total = 0;
    for (const ans of answers) {
        if (ans === correct) total += 5;
        else if (dp[0][n-1].has(ans)) total += 2;
    }
    return total;
};
