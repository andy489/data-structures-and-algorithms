// https://leetcode.com/problems/grid-illumination/

var gridIllumination = function(n, lamps, queries) {
    const row = new Map(), col = new Map(), diag = new Map(), anti = new Map();
    const lit = new Set();
    const inc = (m, k) => m.set(k, (m.get(k) || 0) + 1);
    const dec = (m, k) => m.set(k, (m.get(k) || 0) - 1);
    for (const [r, c] of lamps) {
        const key = r * 1e9 + c;
        if (!lit.has(key)) {
            lit.add(key);
            inc(row, r); inc(col, c); inc(diag, r - c); inc(anti, r + c);
        }
    }
    const dirs = [-1, 0, 1];
    const ans = [];
    for (const [r, c] of queries) {
        if ((row.get(r) || 0) > 0 || (col.get(c) || 0) > 0 ||
            (diag.get(r - c) || 0) > 0 || (anti.get(r + c) || 0) > 0) {
            ans.push(1);
        } else {
            ans.push(0);
        }
        for (const dr of dirs) {
            for (const dc of dirs) {
                const nr = r + dr, nc = c + dc;
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                const key = nr * 1e9 + nc;
                if (lit.has(key)) {
                    lit.delete(key);
                    dec(row, nr); dec(col, nc); dec(diag, nr - nc); dec(anti, nr + nc);
                }
            }
        }
    }
    return ans;
};
