// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

var minRemoveToMakeValid = function(s) {
    const arr = s.split(''), stack = [];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === '(') stack.push(i);
        else if (arr[i] === ')') {
            if (stack.length) stack.pop();
            else arr[i] = '';
        }
    }
    for (const i of stack) arr[i] = '';
    return arr.join('');
};
