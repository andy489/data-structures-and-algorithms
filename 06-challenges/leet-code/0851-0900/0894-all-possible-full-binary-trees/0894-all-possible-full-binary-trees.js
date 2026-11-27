// https://leetcode.com/problems/all-possible-full-binary-trees/

var allPossibleFBT = function(n) {
    const memo = new Map();
    function build(n) {
        if (memo.has(n)) return memo.get(n);
        const result = [];
        if (n === 1) { result.push(new TreeNode(0)); }
        else if (n % 2 === 1) {
            for (let L = 1; L < n; L += 2) {
                for (const left of build(L)) {
                    for (const right of build(n - 1 - L)) {
                        result.push(new TreeNode(0, left, right));
                    }
                }
            }
        }
        memo.set(n, result);
        return result;
    }
    return build(n);
};
