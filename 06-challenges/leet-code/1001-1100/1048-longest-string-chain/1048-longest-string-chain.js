// https://leetcode.com/problems/longest-string-chain/

var longestStrChain = function(words) {
    words.sort((a, b) => a.length - b.length);
    const dp = new Map();
    let res = 1;
    for (const w of words) {
        dp.set(w, 1);
        for (let i = 0; i < w.length; i++) {
            const prev = w.slice(0, i) + w.slice(i+1);
            if (dp.has(prev)) dp.set(w, Math.max(dp.get(w), dp.get(prev)+1));
        }
        res = Math.max(res, dp.get(w));
    }
    return res;
};
