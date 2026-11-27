// https://leetcode.com/problems/count-good-integers-on-a-grid-path/
/**
 * @param {number} l
 * @param {number} r
 * @param {string} directions
 * @return {number}
 */
var countGoodIntegers = function(l, r, directions) {
    function computePath(dir) {
        const pos = [];
        let row = 0, col = 0;
        pos.push(row * 4 + col);
        for (const ch of dir) {
            if (ch === 'D') { row++; } else { col++; }
            pos.push(row * 4 + col);
        }
        return pos;
    }

    const pathPos = computePath(directions);

    function countUpTo(n) {
        if (n <= 0n) { return 0n; }
        const s = n.toString().padStart(16, '0');
        const memo = new Map();

        function dp(pos, tight, lastPathVal, pathIdx) {
            if (pos === 16) { return pathIdx === 7 ? 1n : 0n; }
            const key = `${pos},${tight},${lastPathVal},${pathIdx}`;
            if (!tight && memo.has(key)) { return memo.get(key); }
            const limit = tight ? parseInt(s[pos]) : 9;
            let res = 0n;
            for (let d = 0; d <= limit; d++) {
                const isPathPos = pathIdx < 7 && pathPos[pathIdx] === pos;
                if (isPathPos) {
                    if (lastPathVal === -1 || d >= lastPathVal) {
                        res += dp(pos + 1, tight && d === limit, d, pathIdx + 1);
                    }
                } else {
                    res += dp(pos + 1, tight && d === limit, lastPathVal, pathIdx);
                }
            }
            if (!tight) { memo.set(key, res); }
            return res;
        }

        return dp(0, true, -1, 0);
    }

    return Number(countUpTo(BigInt(r)) - countUpTo(BigInt(l) - 1n));
};
