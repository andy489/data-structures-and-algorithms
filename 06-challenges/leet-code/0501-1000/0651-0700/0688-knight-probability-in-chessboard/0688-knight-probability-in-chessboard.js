// https://leetcode.com/problems/knight-probability-in-chessboard/

var knightProbability = function(n, k, row, column) {
    const moves = [[-2,-1],[-2,1],[-1,-2],[-1,2],[1,-2],[1,2],[2,-1],[2,1]];
    let dp = Array.from({length: n}, () => new Array(n).fill(0));
    dp[row][column] = 1;
    for (let step = 0; step < k; step++) {
        const next = Array.from({length: n}, () => new Array(n).fill(0));
        for (let r = 0; r < n; r++) {
            for (let c = 0; c < n; c++) {
                if (!dp[r][c]) continue;
                for (const [dr, dc] of moves) {
                    const nr = r + dr, nc = c + dc;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        next[nr][nc] += dp[r][c] / 8;
                    }
                }
            }
        }
        dp = next;
    }
    return dp.reduce((s, row) => s + row.reduce((a, b) => a + b, 0), 0);
};
