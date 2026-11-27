// https://leetcode.com/problems/average-of-levels-in-binary-tree/

var averageOfLevels = function(root) {
    const result = [];
    const queue = [root];
    while (queue.length > 0) {
        const size = queue.length;
        let sum = 0;
        for (let i = 0; i < size; i++) {
            const node = queue.shift();
            sum += node.val;
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        result.push(sum / size);
    }
    return result;
};
