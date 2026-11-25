// https://leetcode.com/problems/most-common-word/

var mostCommonWord = function(paragraph, banned) {
    const bannedSet = new Set(banned);
    const words = paragraph.toLowerCase().split(/[^a-z]+/).filter(w => w);
    const freq = new Map();
    for (const w of words) {
        if (!bannedSet.has(w)) {
            freq.set(w, (freq.get(w) || 0) + 1);
        }
    }
    let best = '', max = 0;
    for (const [w, c] of freq) {
        if (c > max) { max = c; best = w; }
    }
    return best;
};
