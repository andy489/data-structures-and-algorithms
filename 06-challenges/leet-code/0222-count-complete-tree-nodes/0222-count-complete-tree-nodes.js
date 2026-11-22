// https://leetcode.com/problems/count-complete-tree-nodes/

// Solution: Binary Search on Last Level — O(log²n) time, O(log n) space
var countNodes = function(root) {
    if (!root) return 0;
    let lh = 0, rh = 0;
    let l = root, r = root;
    while (l) { lh++; l = l.left; }
    while (r) { rh++; r = r.right; }
    if (lh === rh) return (1 << lh) - 1;
    return 1 + countNodes(root.left) + countNodes(root.right);
};
