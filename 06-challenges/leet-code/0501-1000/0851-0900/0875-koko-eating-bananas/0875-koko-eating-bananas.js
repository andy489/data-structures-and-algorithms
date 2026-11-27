// https://leetcode.com/problems/koko-eating-bananas/

var minEatingSpeed = function(piles, h) {
    let lo = 1, hi = Math.max(...piles);
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        const hours = piles.reduce((s, p) => s + Math.ceil(p / mid), 0);
        if (hours <= h) hi = mid;
        else lo = mid + 1;
    }
    return lo;
};
