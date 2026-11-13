// https://www.spoj.com/problems/ABCPATH/

const lines = require('fs').readFileSync('/dev/stdin', 'utf8').trim().split('\n');

const dx = [-1,-1,-1,0,0,1,1,1];
const dy = [-1,0,1,-1,1,-1,0,1];

class Solution {
    constructor() {
        this.H = 0;
        this.W = 0;
        this.grid = [];
        this.dp = [];
        this.idx = 0;
    }

    read(idx) {
        this.idx = idx;
        const parts = lines[this.idx++].trim().split(/\s+/);
        this.H = parseInt(parts[0]);
        this.W = parseInt(parts[1]);
        if (this.H === 0 && this.W === 0) return false;
        this.grid = [];
        this.dp = [];
        for (let i = 0; i < this.H; i++) {
            this.grid.push(lines[this.idx++].trim());
            this.dp.push(new Array(this.W).fill(1));
        }
        return true;
    }

    solve() {
        const {H, W, grid, dp} = this;
        for (let c = 'Y'.charCodeAt(0); c >= 'A'.charCodeAt(0); c--) {
            for (let i = 0; i < H; i++) {
                for (let j = 0; j < W; j++) {
                    if (grid[i].charCodeAt(j) !== c) continue;
                    for (let d = 0; d < 8; d++) {
                        const ni = i + dx[d], nj = j + dy[d];
                        if (ni < 0 || ni >= H || nj < 0 || nj >= W) continue;
                        if (grid[ni].charCodeAt(nj) === c + 1)
                            dp[i][j] = Math.max(dp[i][j], 1 + dp[ni][nj]);
                    }
                }
            }
        }
        let ans = 0;
        for (let i = 0; i < H; i++)
            for (let j = 0; j < W; j++)
                if (grid[i][j] === 'A') ans = Math.max(ans, dp[i][j]);
        return ans;
    }
}

const s = new Solution();
let idx = 0, cas = 1;
while (idx < lines.length && s.read(idx)) {
    console.log(`Case ${cas++}: ${s.solve()}`);
    idx = s.idx;
}
