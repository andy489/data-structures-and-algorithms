// https://leetcode.com/problems/unique-binary-search-trees-ii/

// Solution: Divide and Conquer (Recursion) — O(Cₙ·n) time, O(Cₙ·n) space
var generateTrees = function(n) {
    function generate(lo, hi) {
        if (lo > hi) return [null];
        const result = [];
        for (let i = lo; i <= hi; i++) {
            for (const left of generate(lo, i - 1)) {
                for (const right of generate(i + 1, hi)) {
                    result.push({ val: i, left, right });
                }
            }
        }
        return result;
    }
    return generate(1, n);
};
