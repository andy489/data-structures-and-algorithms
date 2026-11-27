// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/

/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthLargestLevelSum = function(root, k) {
    const sums = [];
    const queue = [root];
    while (queue.length > 0) {
        const size = queue.length;
        let levelSum = 0;
        for (let i = 0; i < size; i++) {
            const node = queue.shift();
            levelSum += node.val;
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        sums.push(levelSum);
    }
    if (sums.length < k) return -1;
    sums.sort((a, b) => b - a);
    return sums[k - 1];
};
