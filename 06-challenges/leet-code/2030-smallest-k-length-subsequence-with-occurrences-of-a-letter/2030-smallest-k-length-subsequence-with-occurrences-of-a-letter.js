// https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/

// Solution: Monotone Stack — O(n) time, O(k) space
var smallestSubsequence = function(s, k, letter, repetition) {
    const n = s.length;
    let lc = 0;
    for (const c of s) if (c === letter) lc++;
    const stack = [];
    let lin = 0;
    for (let i = 0; i < n; i++) {
        const c = s[i], rem = n - i - 1;
        while (stack.length > 0) {
            const top = stack[stack.length - 1];
            if (top > c && stack.length - 1 + rem + 1 >= k) {
                const needLet = lin - (top === letter ? 1 : 0);
                const availLet = lc - (c === letter ? 1 : 0);
                if (needLet + availLet + (c === letter ? 1 : 0) >= repetition) {
                    if (top === letter) { lin--; lc++; }
                    stack.pop();
                } else break;
            } else break;
        }
        if (stack.length < k) {
            stack.push(c);
            if (c === letter) { lin++; lc--; }
        } else {
            if (c === letter) lc--;
        }
    }
    return stack.slice(0, k).join('');
};
