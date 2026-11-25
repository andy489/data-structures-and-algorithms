// https://leetcode.com/problems/cousins-in-binary-tree/

var isCousins = function(root, x, y) {
    let xInfo = null, yInfo = null;
    const queue = [[root, null, 0]];
    while (queue.length) {
        const [node, parent, depth] = queue.shift();
        if (node.val === x) xInfo = [depth, parent];
        if (node.val === y) yInfo = [depth, parent];
        if (node.left) queue.push([node.left, node.val, depth+1]);
        if (node.right) queue.push([node.right, node.val, depth+1]);
    }
    return xInfo[0] === yInfo[0] && xInfo[1] !== yInfo[1];
};
