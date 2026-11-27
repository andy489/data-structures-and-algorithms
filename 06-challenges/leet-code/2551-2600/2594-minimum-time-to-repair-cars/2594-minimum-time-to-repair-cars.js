// https://leetcode.com/problems/minimum-time-to-repair-cars/
/**
 * @param {number[]} ranks
 * @param {number} cars
 * @return {number}
 */
var repairCars = function(ranks, cars) {
    const minRank = Math.min(...ranks);

    const canFinish = (t) => {
        let total = BigInt(0);
        const bigT = BigInt(t);
        for (const r of ranks) {
            total += BigInt(Math.floor(Math.sqrt(Number(bigT / BigInt(r)))));
            if (total >= BigInt(cars)) {
                return true;
            }
        }
        return total >= BigInt(cars);
    };

    let lo = 1n, hi = BigInt(minRank) * BigInt(cars) * BigInt(cars);
    while (lo < hi) {
        const mid = lo + (hi - lo) / 2n;
        if (canFinish(mid)) {
            hi = mid;
        } else {
            lo = mid + 1n;
        }
    }
    return Number(lo);
};
