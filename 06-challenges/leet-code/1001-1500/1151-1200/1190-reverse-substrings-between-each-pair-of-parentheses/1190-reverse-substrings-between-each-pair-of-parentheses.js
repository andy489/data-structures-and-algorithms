// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

// Solution: Stack — O(n²) time, O(n) space
var reverseParentheses = function(s) {
    const stack = [[]];
    for (const c of s) {
        if (c === '(') {
            stack.push([]);
        } else if (c === ')') {
            const top = stack.pop();
            top.reverse();
            stack[stack.length - 1].push(...top);
        } else {
            stack[stack.length - 1].push(c);
        }
    }
    return stack[0].join('');
};

// Solution 2: Wormhole (Portal) Trick — O(n) time, O(n) space
var reverseParentheses2 = function(s) {
    const n = s.length;
    const pair = new Array(n).fill(0);
    const stk = [];
    for (let i = 0; i < n; i++) {
        if (s[i] === '(') {
            stk.push(i);
        } else if (s[i] === ')') {
            const j = stk.pop();
            pair[i] = j;
            pair[j] = i;
        }
    }
    const res = [];
    let dir = 1;
    for (let i = 0; i >= 0 && i < n; i += dir) {
        const c = s[i];
        if (c === '(' || c === ')') {
            i = pair[i];
            dir = -dir;
        } else {
            res.push(c);
        }
    }
    return res.join('');
};
