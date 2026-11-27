// https://leetcode.com/problems/shortest-palindrome/

// Solution: KMP Failure Function — O(n) time, O(n) space
var shortestPalindrome = function(s) {
    const rev = s.split('').reverse().join('');
    const t = s + '#' + rev;
    const fail = new Array(t.length).fill(0);
    for (let i = 1; i < t.length; i++) {
        let j = fail[i - 1];
        while (j > 0 && t[i] !== t[j]) j = fail[j - 1];
        if (t[i] === t[j]) j++;
        fail[i] = j;
    }
    const k = fail[t.length - 1];
    return rev.slice(0, s.length - k) + s;
};
