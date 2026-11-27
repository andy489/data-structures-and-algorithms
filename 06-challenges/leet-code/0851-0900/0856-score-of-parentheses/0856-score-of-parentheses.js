// https://leetcode.com/problems/score-of-parentheses/

var scoreOfParentheses = function(s) {
    const stack = [0];
    for (const c of s) {
        if (c === '(') {
            stack.push(0);
        } else {
            const v = stack.pop();
            stack[stack.length - 1] += Math.max(2 * v, 1);
        }
    }
    return stack[0];
};
