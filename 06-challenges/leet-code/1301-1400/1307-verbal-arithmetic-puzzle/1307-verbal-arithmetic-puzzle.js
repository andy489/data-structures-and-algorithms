// https://leetcode.com/problems/verbal-arithmetic-puzzle/

var isSolvable = function(words, result) {
    const all = [...words, result];
    const charSet = new Set(all.flatMap(w => [...w]));
    const chars = [...charSet];
    const noLead = new Set(all.filter(w => w.length > 1).map(w => w[0]));
    const maxLen = Math.max(...all.map(w => w.length));
    const coef = {};
    for (const c of chars) coef[c] = 0;
    for (let col = 0; col < maxLen; col++) {
        for (const w of words) {
            const idx = w.length-1-col;
            if (idx >= 0) coef[w[idx]] += 10**col;
        }
        const idx = result.length-1-col;
        if (idx >= 0) coef[result[idx]] -= 10**col;
    }
    const coefs = chars.map(c => coef[c]);
    const used = new Set();
    function bt(i, total) {
        if (i === chars.length) return total === 0;
        for (let d = 0; d <= 9; d++) {
            if (used.has(d)) continue;
            if (d === 0 && noLead.has(chars[i])) continue;
            used.add(d);
            if (bt(i+1, total + coefs[i]*d)) return true;
            used.delete(d);
        }
        return false;
    }
    return bt(0, 0);
};
