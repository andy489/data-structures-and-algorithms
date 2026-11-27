// https://leetcode.com/problems/heaters/

var findRadius = function(houses, heaters) {
    heaters.sort((a, b) => a - b);
    let minRadius = 0;
    for (const house of houses) {
        let lo = 0, hi = heaters.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (heaters[mid] < house) lo = mid + 1;
            else hi = mid;
        }
        const distRight = lo < heaters.length ? heaters[lo] - house : Infinity;
        const distLeft = lo > 0 ? house - heaters[lo - 1] : Infinity;
        minRadius = Math.max(minRadius, Math.min(distLeft, distRight));
    }
    return minRadius;
};
