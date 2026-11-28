// https://leetcode.com/problems/distribute-candies-among-children-ii/

var distributeCandies = function(n, limit) {
    function f(x) {
        if (x < 0) return 0n;
        const bx = BigInt(x);
        return (bx + 1n) * (bx + 2n) / 2n;
    }
    const result = f(n) - 3n * f(n - limit - 1) + 3n * f(n - 2 * (limit + 1)) - f(n - 3 * (limit + 1));
    return Number(result);
};
