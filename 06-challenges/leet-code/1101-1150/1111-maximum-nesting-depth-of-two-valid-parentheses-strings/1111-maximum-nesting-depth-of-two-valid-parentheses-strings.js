// https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

// Solution: Parity Split — O(n) time, O(n) space
var maxDepthAfterSplit = function(seq) {
    const ans = [];
    let depth = 0;
    for (const c of seq) {
        if (c === '(') {
            depth++;
            ans.push(depth % 2);
        } else {
            ans.push(depth % 2);
            depth--;
        }
    }
    return ans;
};
