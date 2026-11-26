// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

var maxVowels = function(s, k) {
    const v = new Set('aeiou');
    let cur = 0, best = 0;
    for (let i = 0; i < k; i++) if (v.has(s[i])) cur++;
    best = cur;
    for (let i = k; i < s.length; i++) {
        cur += (v.has(s[i]) ? 1 : 0) - (v.has(s[i-k]) ? 1 : 0);
        best = Math.max(best, cur);
    }
    return best;
};
