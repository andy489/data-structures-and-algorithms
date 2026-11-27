// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

var distanceK = function(root, target, k) {
    const parent = new Map();
    function buildParent(node, par) {
        if (!node) return;
        parent.set(node, par);
        buildParent(node.left, node);
        buildParent(node.right, node);
    }
    buildParent(root, null);

    let queue = [target];
    const visited = new Set([target]);
    let dist = 0;
    while (queue.length) {
        if (dist === k) return queue.map(n => n.val);
        const next = [];
        for (const node of queue) {
            for (const nb of [node.left, node.right, parent.get(node)]) {
                if (nb && !visited.has(nb)) {
                    visited.add(nb);
                    next.push(nb);
                }
            }
        }
        queue = next;
        dist++;
    }
    return [];
};
