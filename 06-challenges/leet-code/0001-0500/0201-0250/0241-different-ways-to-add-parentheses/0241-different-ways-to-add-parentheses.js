// https://leetcode.com/problems/different-ways-to-add-parentheses/

// Solution: Divide & Conquer + Memoization
var diffWaysToCompute = function(expression) {
    const memo = new Map();

    function solve(expr) {
        if (memo.has(expr)) return memo.get(expr);
        const result = [];
        for (let i = 0; i < expr.length; i++) {
            const c = expr[i];
            if (c === '+' || c === '-' || c === '*') {
                const lefts = solve(expr.slice(0, i));
                const rights = solve(expr.slice(i + 1));
                for (const l of lefts) {
                    for (const r of rights) {
                        if (c === '+') result.push(l + r);
                        else if (c === '-') result.push(l - r);
                        else result.push(l * r);
                    }
                }
            }
        }
        if (!result.length) result.push(Number(expr));
        memo.set(expr, result);
        return result;
    }

    return solve(expression);
};
