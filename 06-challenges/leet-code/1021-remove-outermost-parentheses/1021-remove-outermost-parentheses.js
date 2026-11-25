// https://leetcode.com/problems/remove-outermost-parentheses/

var removeOuterParentheses = function(s) {
    let result = '', depth = 0;
    for (const c of s) {
        if (c === '(') { if (depth > 0) result += c; depth++; }
        else { depth--; if (depth > 0) result += c; }
    }
    return result;
};
