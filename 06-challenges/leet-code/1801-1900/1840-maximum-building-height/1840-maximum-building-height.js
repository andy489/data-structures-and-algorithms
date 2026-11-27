// https://leetcode.com/problems/maximum-building-height/

var maxBuilding = function(n, restrictions) {
    const r = [[1, 0], ...restrictions, [n, n - 1]];
    r.sort((a, b) => a[0] - b[0]);
    for (let i = 1; i < r.length; i++) {
        r[i][1] = Math.min(r[i][1], r[i - 1][1] + r[i][0] - r[i - 1][0]);
    }
    for (let i = r.length - 2; i >= 0; i--) {
        r[i][1] = Math.min(r[i][1], r[i + 1][1] + r[i + 1][0] - r[i][0]);
    }
    let ans = 0;
    for (let i = 1; i < r.length; i++) {
        const [a, ha] = r[i - 1], [b, hb] = r[i];
        ans = Math.max(ans, (ha + hb + b - a) >> 1);
    }
    return ans;
};
