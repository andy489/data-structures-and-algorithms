// https://leetcode.com/problems/backspace-string-compare/

var backspaceCompare = function(s, t) {
    function process(str) {
        const stack = [];
        for (const c of str) {
            if (c === '#') { stack.pop(); }
            else { stack.push(c); }
        }
        return stack.join('');
    }
    return process(s) === process(t);
};
