// https://leetcode.com/problems/combination-sum-iii/

// Solution: Backtracking — O(C(9,k)) time, O(k) space
var combinationSum3 = function(k, n) {
    const result = [];

    function backtrack(start, remaining, path) {
        if (path.length === k) {
            if (remaining === 0) result.push([...path]);
            return;
        }
        for (let i = start; i <= 9; i++) {
            if (i > remaining) break;
            path.push(i);
            backtrack(i + 1, remaining - i, path);
            path.pop();
        }
    }

    backtrack(1, n, []);
    return result;
};
