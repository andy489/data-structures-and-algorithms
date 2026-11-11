// https://leetcode.com/problems/longest-valid-parentheses/

// Solution: Stack — O(n) time, O(n) space
var longestValidParentheses = function(s) {
    const stack = [-1];
    let ans = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') {
            stack.push(i);
        } else {
            stack.pop();
            if (stack.length === 0) {
                stack.push(i);
            } else {
                ans = Math.max(ans, i - stack[stack.length - 1]);
            }
        }
    }
    return ans;
};

// Solution 2: Two-Pass Counters — O(n) time, O(1) space
var longestValidParentheses2 = function(s) {
    let open = 0, close = 0, ans = 0;
    for (const ch of s) {
        ch === '(' ? open++ : close++;
        if (open === close) {
            ans = Math.max(ans, 2 * close);
        } else if (close > open) {
            open = close = 0;
        }
    }
    open = close = 0;
    for (let i = s.length - 1; i >= 0; i--) {
        s[i] === '(' ? open++ : close++;
        if (open === close) {
            ans = Math.max(ans, 2 * open);
        } else if (open > close) {
            open = close = 0;
        }
    }
    return ans;
};
