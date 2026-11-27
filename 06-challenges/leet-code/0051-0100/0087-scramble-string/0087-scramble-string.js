// https://leetcode.com/problems/scramble-string/

var isScramble = function(s1, s2) {
    const memo = new Map();

    function helper(a, b) {
        if (a === b) return true;
        const key = a + '#' + b;
        if (memo.has(key)) return memo.get(key);
        const freq = new Array(26).fill(0);
        for (let i = 0; i < a.length; i++) {
            freq[a.charCodeAt(i) - 97]++;
            freq[b.charCodeAt(i) - 97]--;
        }
        if (freq.some(f => f !== 0)) {
            memo.set(key, false);
            return false;
        }
        const n = a.length;
        for (let k = 1; k < n; k++) {
            if ((helper(a.slice(0, k), b.slice(0, k)) && helper(a.slice(k), b.slice(k))) ||
                (helper(a.slice(0, k), b.slice(n - k)) && helper(a.slice(k), b.slice(0, n - k)))) {
                memo.set(key, true);
                return true;
            }
        }
        memo.set(key, false);
        return false;
    }

    return helper(s1, s2);
};
