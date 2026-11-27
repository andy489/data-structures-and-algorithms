// https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
var minimumPerimeter = function(neededApples) {
    let lo = 1n, hi = 100000n;
    const target = BigInt(neededApples);
    while (lo < hi) {
        const mid = lo + (hi - lo) / 2n;
        if (2n * mid * (mid + 1n) * (2n * mid + 1n) >= target) {
            hi = mid;
        } else {
            lo = mid + 1n;
        }
    }
    return Number(8n * lo);
};
