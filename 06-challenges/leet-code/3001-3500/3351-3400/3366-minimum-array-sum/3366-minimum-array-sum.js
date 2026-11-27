// https://leetcode.com/problems/minimum-array-sum/

var minArraySum = function(nums, k, op1, op2) {
    const INF = Infinity;
    let dp = Array.from({length: op1 + 1}, () => new Array(op2 + 1).fill(INF));
    dp[0][0] = 0;

    for (const x of nums) {
        const nxt = Array.from({length: op1 + 1}, () => new Array(op2 + 1).fill(INF));
        for (let i = 0; i <= op1; i++) {
            for (let j = 0; j <= op2; j++) {
                const cur = dp[i][j];
                if (cur === INF) {
                    continue;
                }
                // No op
                nxt[i][j] = Math.min(nxt[i][j], cur + x);
                // Op1 only
                if (i < op1) {
                    nxt[i + 1][j] = Math.min(nxt[i + 1][j], cur + Math.ceil(x / 2));
                }
                // Op2 only
                if (j < op2 && x >= k) {
                    nxt[i][j + 1] = Math.min(nxt[i][j + 1], cur + x - k);
                }
                if (i < op1 && j < op2) {
                    // Op1 then Op2
                    const afterOp1 = Math.ceil(x / 2);
                    if (afterOp1 >= k) {
                        nxt[i + 1][j + 1] = Math.min(nxt[i + 1][j + 1], cur + afterOp1 - k);
                    }
                    // Op2 then Op1
                    if (x >= k) {
                        nxt[i + 1][j + 1] = Math.min(nxt[i + 1][j + 1], cur + Math.ceil((x - k) / 2));
                    }
                }
            }
        }
        dp = nxt;
    }

    let ans = INF;
    for (let i = 0; i <= op1; i++) {
        for (let j = 0; j <= op2; j++) {
            ans = Math.min(ans, dp[i][j]);
        }
    }
    return ans;
};
