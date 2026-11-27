// https://leetcode.com/problems/substring-xor-queries/

// Solution: Precompute Substring Values (up to 32 bits) — O(32n + q) time
var substringXorQueries = function(s, queries) {
    const firstOccurrence = new Map();
    const n = s.length;
    for (let l = 0; l < n; l++) {
        if (s[l] === '0') {
            if (!firstOccurrence.has(0)) {
                firstOccurrence.set(0, [l, l]);
            }
            continue;
        }
        let val = 0;
        for (let r = l; r < Math.min(l + 32, n); r++) {
            val = (val << 1) | Number(s[r]);
            if (!firstOccurrence.has(val)) {
                firstOccurrence.set(val, [l, r]);
            }
        }
    }
    return queries.map(([a, b]) => firstOccurrence.get(a ^ b) || [-1, -1]);
};
