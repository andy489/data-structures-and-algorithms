// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

var getAllElements = function(root1, root2) {
    const inorder = node => node ? [...inorder(node.left), node.val, ...inorder(node.right)] : [];
    const l1 = inorder(root1), l2 = inorder(root2);
    const res = []; let i = 0, j = 0;
    while (i < l1.length && j < l2.length) {
        res.push(l1[i] <= l2[j] ? l1[i++] : l2[j++]);
    }
    return res.concat(l1.slice(i), l2.slice(j));
};
