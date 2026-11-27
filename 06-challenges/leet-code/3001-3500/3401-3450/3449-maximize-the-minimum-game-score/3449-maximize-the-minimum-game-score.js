// https://leetcode.com/problems/maximize-the-minimum-game-score/
var maxScore = function(points, m) {
    const canAchieve = (minScore) => {
        let moves = BigInt(m);
        for (const p of points) {
            const needed = (minScore + BigInt(p) - 1n) / BigInt(p);
            moves -= 2n * needed - 1n;
            if (moves < 0n) return false;
        }
        return true;
    };

    let lo = 0n, hi = BigInt(m + 1) * BigInt(Math.max(...points));
    while (lo < hi) {
        const mid = (lo + hi + 1n) / 2n;
        if (canAchieve(mid)) {
            lo = mid;
        } else {
            hi = mid - 1n;
        }
    }

    return Number(lo);
};
