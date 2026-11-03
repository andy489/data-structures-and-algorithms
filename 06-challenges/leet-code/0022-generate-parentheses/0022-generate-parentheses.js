// https://leetcode.com/problems/generate-parentheses/

// Solution: Backtracking — O(4ⁿ / √n) time, O(n) space
var generateParenthesis = function(n) {
    const result = [];

    function backtrack(s, open, close) {
        if (s.length === 2 * n) {
            result.push(s);
            return;
        }
        if (open < n) {
            backtrack(s + "(", open + 1, close);
        }
        if (close < open) {
            backtrack(s + ")", open, close + 1);
        }
    }

    backtrack("", 0, 0);
    return result;
};
