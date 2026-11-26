// https://leetcode.com/problems/basic-calculator-ii/

// Solution: Stack with Eager */÷ — O(n) time, O(n) space
var calculate = function(s) {
    const stack = [];
    let num = 0, op = '+';

    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (c >= '0' && c <= '9') num = num * 10 + (c - '0');
        if ((c < '0' && c !== ' ') || i === s.length - 1) {
            if (op === '+') stack.push(num);
            else if (op === '-') stack.push(-num);
            else if (op === '*') stack.push(stack.pop() * num);
            else stack.push(Math.trunc(stack.pop() / num));
            op = c; num = 0;
        }
    }
    return stack.reduce((a, b) => a + b, 0);
};
