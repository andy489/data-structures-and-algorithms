// https://leetcode.com/problems/valid-parentheses/

// Solution: Stack — O(n) time, O(n) space
var isValid = function(s) {
    const stack = [];
    const matching = { ')': '(', '}': '{', ']': '[' };

    for (const c of s) {
        if (c === '(' || c === '{' || c === '[') {
            stack.push(c);
        } else {
            if (!stack.length || stack[stack.length - 1] !== matching[c]) {
                return false;
            }
            stack.pop();
        }
    }

    return stack.length === 0;
};
