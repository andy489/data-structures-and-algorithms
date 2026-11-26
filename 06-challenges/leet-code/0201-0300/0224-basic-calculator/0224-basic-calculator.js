// https://leetcode.com/problems/basic-calculator/

// Solution: Stack-based — O(n) time, O(n) space
var calculate = function(s) {
    const stack = [];
    let result = 0, sign = 1, num = 0;

    for (const c of s) {
        if (c >= '0' && c <= '9') {
            num = num * 10 + (c - '0');
        } else if (c === '+') {
            result += sign * num; num = 0; sign = 1;
        } else if (c === '-') {
            result += sign * num; num = 0; sign = -1;
        } else if (c === '(') {
            stack.push(result); stack.push(sign);
            result = 0; sign = 1;
        } else if (c === ')') {
            result += sign * num; num = 0;
            result *= stack.pop();
            result += stack.pop();
        }
    }
    return result + sign * num;
};
