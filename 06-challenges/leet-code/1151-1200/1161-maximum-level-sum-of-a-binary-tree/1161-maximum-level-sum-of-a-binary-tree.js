// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

var maxLevelSum = function(root) {
    const q = [root];
    let bestLevel = 1, bestSum = -Infinity, level = 0;
    while (q.length > 0) {
        level++;
        const size = q.length;
        let sum = 0;
        for (let i = 0; i < size; i++) {
            const node = q.shift();
            sum += node.val;
            if (node.left) {
                q.push(node.left);
            }
            if (node.right) {
                q.push(node.right);
            }
        }
        if (sum > bestSum) {
            bestSum = sum;
            bestLevel = level;
        }
    }
    return bestLevel;
};
