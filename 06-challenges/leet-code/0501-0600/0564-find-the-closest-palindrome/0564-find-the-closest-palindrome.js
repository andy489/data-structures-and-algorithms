/**
 * @param {string} n
 * @return {string}
 */
var nearestPalindromic = function (n) {
    const num = BigInt(n);
    const len = n.length;
    const candidates = new Set();
    candidates.add(BigInt(10) ** BigInt(len - 1) - 1n);
    candidates.add(BigInt(10) ** BigInt(len) + 1n);
    const prefix = BigInt(n.slice(0, Math.ceil(len / 2)));
    for (const p of [prefix - 1n, prefix, prefix + 1n]) {
        const half = p.toString();
        let full;
        if (len % 2 === 0) {
            full = half + half.split('').reverse().join('');
        } else {
            full = half + half.slice(0, -1).split('').reverse().join('');
        }
        candidates.add(BigInt(full));
    }
    candidates.delete(num);
    let result = null;
    for (const c of candidates) {
        const diff = c > num ? c - num : num - c;
        if (result === null) {
            result = c;
        } else {
            const bestDiff = result > num ? result - num : num - result;
            if (diff < bestDiff || (diff === bestDiff && c < result)) {
                result = c;
            }
        }
    }
    return result.toString();
};
