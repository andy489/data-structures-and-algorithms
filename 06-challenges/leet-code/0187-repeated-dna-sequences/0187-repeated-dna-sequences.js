// https://leetcode.com/problems/repeated-dna-sequences/

// Solution 1: HashMap of substrings — O(n) time, O(n) space
var findRepeatedDnaSequences = function(s) {
    if (s.length <= 10) return [];
    const seen = new Map();
    const result = [];
    for (let i = 0; i <= s.length - 10; i++) {
        const sub = s.substring(i, i + 10);
        const cnt = (seen.get(sub) || 0) + 1;
        seen.set(sub, cnt);
        if (cnt === 2) result.push(sub);
    }
    return result;
};

// Solution 2: Bit-encoding rolling hash — O(n) time, O(n) space
var findRepeatedDnaSequences2 = function(s) {
    const n = s.length;
    if (n <= 10) return [];
    const encode = { A: 0, C: 1, G: 2, T: 3 };
    const MASK = (1 << 20) - 1;
    let h = 0;
    for (let i = 0; i < 10; i++) h = (h << 2) | encode[s[i]];
    const seen = new Set([h]);
    const added = new Set();
    const result = [];
    for (let i = 10; i < n; i++) {
        h = ((h << 2) | encode[s[i]]) & MASK;
        if (seen.has(h) && !added.has(h)) {
            result.push(s.substring(i - 9, i + 1));
            added.add(h);
        } else {
            seen.add(h);
        }
    }
    return result;
};
