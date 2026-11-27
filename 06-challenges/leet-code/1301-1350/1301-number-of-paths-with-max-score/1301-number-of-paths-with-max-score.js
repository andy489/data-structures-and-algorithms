// https://leetcode.com/problems/number-of-paths-with-max-score/

var pathsWithMaxScore = function(board) {
    const MOD = 1_000_000_007n, n = board.length;
    const score = Array.from({length:n}, ()=>new Array(n).fill(0));
    const cnt = Array.from({length:n}, ()=>new Array(n).fill(0n));
    cnt[n-1][n-1] = 1n;
    for (let i = n-1; i >= 0; i--) {
        for (let j = n-1; j >= 0; j--) {
            if (i === n-1 && j === n-1) continue;
            const c = board[i][j];
            if (c === 'X') continue;
            const val = c === 'E' ? 0 : Number(c);
            let bestS = -1, bestC = 0n;
            for (const [ni, nj] of [[i+1,j],[i,j+1],[i+1,j+1]]) {
                if (ni < n && nj < n && cnt[ni][nj] > 0n) {
                    if (score[ni][nj] > bestS) { bestS = score[ni][nj]; bestC = cnt[ni][nj]; }
                    else if (score[ni][nj] === bestS) { bestC = (bestC + cnt[ni][nj]) % MOD; }
                }
            }
            if (bestC > 0n) { score[i][j] = bestS + val; cnt[i][j] = bestC; }
        }
    }
    if (cnt[0][0] === 0n) return [0, 0];
    return [score[0][0], Number(cnt[0][0])];
};
