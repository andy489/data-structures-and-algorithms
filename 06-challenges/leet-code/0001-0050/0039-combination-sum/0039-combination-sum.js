// https://leetcode.com/problems/combination-sum/

var combinationSum = function(candidates, target) {
    candidates.sort((a, b) => a - b);
    const result = [];

    function backtrack(start, remaining, path) {
        if (remaining === 0) {
            result.push([...path]);
            return;
        }
        for (let i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) {
                break;
            }
            path.push(candidates[i]);
            backtrack(i, remaining - candidates[i], path);
            path.pop();
        }
    }

    backtrack(0, target, []);
    return result;
};
