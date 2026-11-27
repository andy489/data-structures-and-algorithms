// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

var shipWithinDays = function(weights, days) {
    const canShip = cap => {
        let needed = 1, cur = 0;
        for (const w of weights) {
            if (cur + w > cap) { needed++; cur = 0; }
            cur += w;
        }
        return needed <= days;
    };
    let lo = Math.max(...weights), hi = weights.reduce((s, v) => s + v, 0);
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (canShip(mid)) hi = mid; else lo = mid + 1;
    }
    return lo;
};
