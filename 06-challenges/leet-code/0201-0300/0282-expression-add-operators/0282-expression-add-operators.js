// https://leetcode.com/problems/expression-add-operators/

// Solution: Backtracking with Multiplication Tracking — O(4^n · n) time, O(n) space
var addOperators = function(num, target) {
    const res = [];
    function backtrack(pos, expr, eval_, mult) {
        if (pos === num.length) {
            if (eval_ === target) res.push(expr);
            return;
        }
        for (let i = pos; i < num.length; i++) {
            if (i !== pos && num[pos] === '0') break;
            const cur = parseInt(num.slice(pos, i + 1));
            const s = String(cur);
            if (pos === 0) {
                backtrack(i + 1, s, cur, cur);
            } else {
                backtrack(i + 1, expr + '+' + s, eval_ + cur, cur);
                backtrack(i + 1, expr + '-' + s, eval_ - cur, -cur);
                backtrack(i + 1, expr + '*' + s, eval_ - mult + mult * cur, mult * cur);
            }
        }
    }
    backtrack(0, '', 0, 0);
    return res;
};
