// https://leetcode.com/problems/array-of-doubled-pairs/

var canReorderDoubled = function(arr) {
    const count = new Map();
    for (const x of arr) count.set(x, (count.get(x) || 0) + 1);
    const keys = [...count.keys()].sort((a, b) => Math.abs(a) - Math.abs(b));
    for (const k of keys) {
        const cnt = count.get(k);
        if (cnt === 0) continue;
        const dbl = count.get(2 * k) || 0;
        if (dbl < cnt) return false;
        count.set(2 * k, dbl - cnt);
    }
    return true;
};
