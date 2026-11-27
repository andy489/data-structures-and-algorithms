// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/
var maxDifference = function(s, k) {
    const n = s.length;
    let res = -Infinity;
    const INF = Infinity;

    for (let a = 0; a <= 4; a++) {
        for (let b = 0; b <= 4; b++) {
            if (a === b) continue;
            const prefA = new Array(n + 1).fill(0);
            const prefB = new Array(n + 1).fill(0);
            for (let i = 0; i < n; i++) {
                const d = parseInt(s[i]);
                prefA[i + 1] = prefA[i] + (d === a ? 1 : 0);
                prefB[i + 1] = prefB[i] + (d === b ? 1 : 0);
            }
            const best = [[INF, INF], [INF, INF]];
            for (let r = k; r <= n; r++) {
                const l = r - k;
                const paL = prefA[l] % 2;
                const pbL = prefB[l] % 2;
                if (prefB[l] < prefB[r]) {
                    const val = prefA[l] - prefB[l];
                    if (val < best[paL][pbL]) {
                        best[paL][pbL] = val;
                    }
                }
                const paR = prefA[r] % 2;
                const pbR = prefB[r] % 2;
                const neededPa = 1 - paR;
                const neededPb = pbR;
                const bv = best[neededPa][neededPb];
                if (bv < INF) {
                    const candidate = (prefA[r] - prefB[r]) - bv;
                    if (candidate > res) {
                        res = candidate;
                    }
                }
            }
        }
    }
    return res;
};
