// https://leetcode.com/problems/prefix-and-suffix-search/

var WordFilter = function(words) {
    this.lookup = new Map();
    for (let i = 0; i < words.length; i++) {
        const w = words[i], n = w.length;
        for (let p = 0; p <= n; p++) {
            for (let s = 0; s <= n; s++) {
                this.lookup.set(w.slice(0, p) + '#' + w.slice(n - s), i);
            }
        }
    }
};

WordFilter.prototype.f = function(pref, suff) {
    return this.lookup.has(pref + '#' + suff) ? this.lookup.get(pref + '#' + suff) : -1;
};
