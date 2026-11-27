// https://leetcode.com/problems/count-vowel-strings-in-ranges/

// Solution: Prefix Sum — O(n + q) time, O(n) space
var vowelStrings = function(words, queries) {
    const vowels = new Set(['a', 'e', 'i', 'o', 'u']);
    const n = words.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        const w = words[i];
        const val = (vowels.has(w[0]) && vowels.has(w[w.length - 1])) ? 1 : 0;
        prefix[i + 1] = prefix[i] + val;
    }
    return queries.map(([l, r]) => prefix[r + 1] - prefix[l]);
};
