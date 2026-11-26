// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

var maxDepth = function(s) {
    let depth = 0, maxD = 0;
    for (const c of s) {
        if (c === '(') {
            maxD = Math.max(maxD, ++depth);
        } else if (c === ')') {
            depth--;
        }
    }
    return maxD;
};
