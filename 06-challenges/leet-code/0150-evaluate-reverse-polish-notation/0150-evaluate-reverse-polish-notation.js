// https://leetcode.com/problems/evaluate-reverse-polish-notation/

// Solution: Stack — O(n) time, O(n) space
var evalRPN = function(tokens) {
    const stack = [];
    for (const t of tokens) {
        if (t === '+' || t === '-' || t === '*' || t === '/') {
            const b = stack.pop(), a = stack.pop();
            if (t === '+') stack.push(a + b);
            else if (t === '-') stack.push(a - b);
            else if (t === '*') stack.push(a * b);
            else stack.push(Math.trunc(a / b));
        } else {
            stack.push(Number(t));
        }
    }
    return stack[0];
};
