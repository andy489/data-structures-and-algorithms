// https://leetcode.com/problems/shortest-matching-substring/

var shortestMatchingSubstring = function(s, p) {
    const parts = p.split('*');
    const [a, b, c] = parts;

    function kmpEnds(text, pattern) {
        if (pattern.length === 0) {
            return Array.from({length: text.length + 1}, (_, i) => i);
        }
        const m = pattern.length;
        const lps = new Array(m).fill(0);
        let j = 0;
        for (let i = 1; i < m; i++) {
            while (j > 0 && pattern[i] !== pattern[j]) j = lps[j - 1];
            if (pattern[i] === pattern[j]) j++;
            lps[i] = j;
        }
        const result = [];
        j = 0;
        for (let i = 0; i < text.length; i++) {
            while (j > 0 && text[i] !== pattern[j]) j = lps[j - 1];
            if (text[i] === pattern[j]) j++;
            if (j === m) {
                result.push(i + 1);
                j = lps[j - 1];
            }
        }
        return result;
    }

    const aEnds = kmpEnds(s, a);
    const bEnds = kmpEnds(s, b);
    const cEnds = kmpEnds(s, c);
    const cStarts = cEnds.map(e => e - c.length);

    if (!aEnds.length || !bEnds.length || !cEnds.length) return -1;
    if (!a && !b && !c) return 0;

    let ans = Infinity;
    let ai = 0, ci = 0;
    for (const be of bEnds) {
        const bs = be - b.length;
        while (ai < aEnds.length && aEnds[ai] <= bs) ai++;
        while (ci < cStarts.length && cStarts[ci] < be) ci++;
        const aIdx = ai - 1;
        if (aIdx < 0 && a) continue;
        if (ci >= cStarts.length && c) break;
        const windowStart = !a ? bs : aEnds[aIdx] - a.length;
        const windowEnd = !c ? be : cStarts[ci] + c.length;
        ans = Math.min(ans, windowEnd - windowStart);
    }
    return ans === Infinity ? -1 : ans;
};
