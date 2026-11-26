// https://leetcode.com/problems/number-of-valid-move-combinations-on-chessboard/

// Solution: Backtracking — O(m^n) time, O(n) space
var countCombinations = function(pieces, positions) {
    const DIRS = {
        rook: [[0,1],[0,-1],[1,0],[-1,0]],
        bishop: [[1,1],[1,-1],[-1,1],[-1,-1]],
        queen: [[0,1],[0,-1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
    };
    const n = pieces.length;
    const allMoves = pieces.map((p, i) => {
        const moves = [[...positions[i]]];
        for (const [dr, dc] of DIRS[p]) {
            let [r, c] = positions[i];
            r += dr; c += dc;
            while (r >= 1 && r <= 8 && c >= 1 && c <= 8) { moves.push([r, c]); r += dr; c += dc; }
        }
        return moves;
    });
    const valid = (targets) => {
        const r = positions.map(p => p[0]), c = positions.map(p => p[1]);
        const tr = targets.map(t => t[0]), tc = targets.map(t => t[1]);
        const dr = r.map((_, i) => Math.sign(tr[i]-r[i]));
        const dc = c.map((_, i) => Math.sign(tc[i]-c[i]));
        const done = new Array(n).fill(false);
        for (let t = 0; t < 8; t++) {
            for (let i = 0; i < n; i++) {
                if (!done[i]) { r[i] += dr[i]; c[i] += dc[i]; if (r[i]===tr[i] && c[i]===tc[i]) done[i]=true; }
            }
            const set = new Set(r.map((_, i) => r[i]*10+c[i]));
            if (set.size < n) return false;
        }
        return true;
    };
    let res = 0;
    const bt = (idx, chosen) => {
        if (idx === n) { if (valid(chosen)) res++; return; }
        for (const m of allMoves[idx]) { bt(idx+1, [...chosen, m]); }
    };
    bt(0, []);
    return res;
};
