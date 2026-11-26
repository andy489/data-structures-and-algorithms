// https://leetcode.com/problems/find-duplicate-subtrees/

var findDuplicateSubtrees = function(root) {
    const seen = new Map();
    const result = [];

    function serialize(node) {
        if (!node) return "#";
        const key = serialize(node.left) + "," + serialize(node.right) + "," + node.val;
        seen.set(key, (seen.get(key) || 0) + 1);
        if (seen.get(key) === 2) result.push(node);
        return key;
    }

    serialize(root);
    return result;
};
