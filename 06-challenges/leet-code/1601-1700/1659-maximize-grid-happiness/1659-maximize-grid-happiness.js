// https://leetcode.com/problems/maximize-grid-happiness/

var getMaxGridHappiness = function(m, n, introvertsCount, extrovertsCount) {
    const INTRO_BASE = 120, EXTRO_BASE = 40;
    const INTRO_COST = -30, EXTRO_GAIN = 20;

    function interaction(t1, t2) {
        if (t1 === 0 || t2 === 0) {
            return 0;
        }
        const my = t1 === 1 ? INTRO_COST : EXTRO_GAIN;
        const nb = t2 === 1 ? INTRO_COST : EXTRO_GAIN;
        return my + nb;
    }

    const memo = new Map();

    function solve(pos, intro, extro, prevRow) {
        if (pos === m * n || (intro === 0 && extro === 0)) {
            return 0;
        }
        const key = `${pos},${intro},${extro},${prevRow.join(',')}`;
        if (memo.has(key)) {
            return memo.get(key);
        }
        const col = pos % n;
        const top = prevRow[col];
        const curRow = [...prevRow];
        const left = col > 0 ? curRow[col - 1] : 0;

        let best = solve(pos + 1, intro, extro, curRow);

        if (intro > 0) {
            const delta = INTRO_BASE + interaction(1, top) + interaction(1, left);
            curRow[col] = 1;
            best = Math.max(best, delta + solve(pos + 1, intro - 1, extro, curRow));
            curRow[col] = 0;
        }
        if (extro > 0) {
            const delta = EXTRO_BASE + interaction(2, top) + interaction(2, left);
            curRow[col] = 2;
            best = Math.max(best, delta + solve(pos + 1, intro, extro - 1, curRow));
            curRow[col] = 0;
        }

        memo.set(key, best);
        return best;
    }

    return solve(0, introvertsCount, extrovertsCount, new Array(n).fill(0));
};
