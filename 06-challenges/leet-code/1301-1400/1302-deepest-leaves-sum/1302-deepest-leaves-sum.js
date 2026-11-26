// https://leetcode.com/problems/deepest-leaves-sum/

var deepestLeavesSum = function(root) {
    let q = [root], sum = 0;
    while (q.length) {
        sum = q.reduce((s, n) => s + n.val, 0);
        q = q.flatMap(n => [n.left, n.right].filter(Boolean));
    }
    return sum;
};
