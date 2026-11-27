// https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/

var isValid = function(s) {
    const stack = [];
    for (const c of s) {
        if (c === 'c') {
            if (stack.length < 2 || stack[stack.length-1] !== 'b' || stack[stack.length-2] !== 'a') return false;
            stack.pop(); stack.pop();
        } else {
            stack.push(c);
        }
    }
    return stack.length === 0;
};
