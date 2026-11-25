// https://leetcode.com/problems/verifying-an-alien-dictionary/

var isAlienSorted = function(words, order) {
    const rank = {};
    for (let i = 0; i < order.length; i++) rank[order[i]] = i;
    for (let i = 0; i < words.length - 1; i++) {
        const w1 = words[i], w2 = words[i + 1];
        const len = Math.min(w1.length, w2.length);
        let found = false;
        for (let j = 0; j < len; j++) {
            if (rank[w1[j]] < rank[w2[j]]) { found = true; break; }
            if (rank[w1[j]] > rank[w2[j]]) return false;
        }
        if (!found && w1.length > w2.length) return false;
    }
    return true;
};
