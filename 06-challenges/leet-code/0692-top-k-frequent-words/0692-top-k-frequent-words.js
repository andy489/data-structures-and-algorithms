// https://leetcode.com/problems/top-k-frequent-words/

var topKFrequent = function(words, k) {
    const freq = new Map();
    for (const w of words) freq.set(w, (freq.get(w) || 0) + 1);
    return [...freq.keys()]
        .sort((a, b) => freq.get(b) - freq.get(a) || a.localeCompare(b))
        .slice(0, k);
};
