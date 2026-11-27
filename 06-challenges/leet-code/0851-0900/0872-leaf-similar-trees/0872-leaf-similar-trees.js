// https://leetcode.com/problems/leaf-similar-trees/

var leafSimilar = function(root1, root2) {
    function leaves(node) {
        if (!node) return [];
        if (!node.left && !node.right) return [node.val];
        return [...leaves(node.left), ...leaves(node.right)];
    }
    const l1 = leaves(root1), l2 = leaves(root2);
    return l1.length === l2.length && l1.every((v, i) => v === l2[i]);
};
