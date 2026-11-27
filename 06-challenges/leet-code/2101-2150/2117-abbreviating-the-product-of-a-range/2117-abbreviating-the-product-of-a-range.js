// https://leetcode.com/problems/abbreviating-the-product-of-a-range/
var abbreviateProduct = function(left, right) {
    // Count factors of 2 and 5
    let c2 = 0n, c5 = 0n;
    for (let i = left; i <= right; i++) {
        let x = i;
        while (x % 2 === 0) { c2++; x = Math.floor(x / 2); }
        while (x % 5 === 0) { c5++; x = Math.floor(x / 5); }
    }
    const C = c2 < c5 ? c2 : c5;

    // Try exact using BigInt
    let product = 1n;
    let overflow = false;
    for (let i = left; i <= right; i++) {
        product *= BigInt(i);
        if (product.toString().length > 200) {
            overflow = true;
            break;
        }
    }

    if (!overflow) {
        while (product % 10n === 0n) product /= 10n;
        const s = product.toString();
        if (s.length <= 10) return s + 'e' + C.toString();
    }

    // Large: track suffix and log prefix
    const MOD = 100000n;
    let suf = 1n;
    let extra2 = c2 - C, extra5 = c5 - C;
    for (let i = left; i <= right; i++) {
        let x = BigInt(i);
        while (extra2 > 0n && x % 2n === 0n) { x /= 2n; extra2--; }
        while (extra5 > 0n && x % 5n === 0n) { x /= 5n; extra5--; }
        suf = (suf * x) % MOD;
    }

    let logSum = 0;
    for (let i = left; i <= right; i++) logSum += Math.log10(i);
    logSum -= Number(C);
    const frac = logSum - Math.floor(logSum);
    const pre = Math.floor(Math.pow(10, frac + 4));
    const sufStr = suf.toString().padStart(5, '0');

    return `${pre}...${sufStr}e${C}`;
};
