// https://leetcode.com/problems/maximum-width-of-binary-tree/

var widthOfBinaryTree = function(root) {
    let maxWidth = 0;
    let queue = [[root, 0n]];
    while (queue.length) {
        const size = queue.length;
        const first = queue[0][1];
        let last = 0n;
        const next = [];
        for (let i = 0; i < size; i++) {
            const [node, idx] = queue[i];
            last = idx;
            const norm = idx - first;
            if (node.left) next.push([node.left, 2n * norm]);
            if (node.right) next.push([node.right, 2n * norm + 1n]);
        }
        maxWidth = Math.max(maxWidth, Number(last - first + 1n));
        queue = next;
    }
    return maxWidth;
};
