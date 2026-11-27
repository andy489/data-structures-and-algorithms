// https://leetcode.com/problems/make-the-string-great/

var makeGood = function(s) {
    const stack = [];
    for (const c of s) {
        if (stack.length > 0 && Math.abs(stack[stack.length - 1].charCodeAt(0) - c.charCodeAt(0)) === 32) {
            stack.pop();
        } else {
            stack.push(c);
        }
    }
    return stack.join('');
};
