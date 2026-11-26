// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

var smallestSubsequence = function(s) {
    const last = {};
    for (let i = 0; i < s.length; i++) last[s[i]] = i;
    const stack = [], seen = new Set();
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (seen.has(c)) continue;
        while (stack.length && stack[stack.length-1] > c && last[stack[stack.length-1]] > i) {
            seen.delete(stack.pop());
        }
        stack.push(c);
        seen.add(c);
    }
    return stack.join('');
};
