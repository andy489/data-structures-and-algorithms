// https://leetcode.com/problems/smallest-good-base/

var smallestGoodBase = function(n) {
    const num = BigInt(n);
    const maxM = Math.floor(Math.log2(Number(num)));

    const geometricSum = (k, m) => {
        let total = 0n, power = 1n;
        for (let i = 0; i < m; i++) {
            total += power;
            power *= k;
        }
        return total;
    };

    for (let m = maxM; m >= 2; m--) {
        const k = BigInt(Math.round(Math.pow(Number(num), 1.0 / (m - 1))));
        for (const candidate of [k - 1n, k, k + 1n]) {
            if (candidate >= 2n && geometricSum(candidate, m) === num) {
                return candidate.toString();
            }
        }
    }
    return (num - 1n).toString();
};
