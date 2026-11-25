// https://leetcode.com/problems/uncommon-words-from-two-sentences/

var uncommonFromSentences = function(s1, s2) {
    const count = new Map();
    for (const w of (s1 + ' ' + s2).split(' ')) {
        count.set(w, (count.get(w) || 0) + 1);
    }
    return [...count.entries()].filter(([, c]) => c === 1).map(([w]) => w);
};
