// https://leetcode.com/problems/vowel-spellchecker/

var spellchecker = function(wordlist, queries) {
    const mask = w => w.toLowerCase().replace(/[aeiou]/g, '*');
    const exact = new Set(wordlist);
    const lowerMap = new Map(), vowelMap = new Map();
    for (const w of wordlist) {
        if (!lowerMap.has(w.toLowerCase())) lowerMap.set(w.toLowerCase(), w);
        if (!vowelMap.has(mask(w))) vowelMap.set(mask(w), w);
    }
    return queries.map(q => {
        if (exact.has(q)) return q;
        if (lowerMap.has(q.toLowerCase())) return lowerMap.get(q.toLowerCase());
        return vowelMap.get(mask(q)) || '';
    });
};
