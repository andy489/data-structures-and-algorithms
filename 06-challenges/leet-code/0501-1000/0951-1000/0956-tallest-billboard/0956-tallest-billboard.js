// https://leetcode.com/problems/tallest-billboard/

var tallestBillboard = function(rods) {
    let dp = new Map([[0, 0]]);
    for (const r of rods) {
        const cur = new Map(dp);
        for (const [diff, tall] of cur) {
            dp.set(diff + r, Math.max(dp.get(diff + r) || 0, tall + r));
            const newDiff = Math.abs(diff - r);
            const newTall = diff >= r ? tall : tall + r - diff;
            dp.set(newDiff, Math.max(dp.get(newDiff) || 0, newTall));
        }
    }
    return dp.get(0) || 0;
};
