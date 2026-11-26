// https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
// Solution: Recursive quad-tree OR — O(n^2) time, O(log n) space
var intersect = function(quadTree1, quadTree2) {
    if (quadTree1.isLeaf) {
        return quadTree1.val ? quadTree1 : quadTree2;
    }
    if (quadTree2.isLeaf) {
        return quadTree2.val ? quadTree2 : quadTree1;
    }
    const tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
    const tr = intersect(quadTree1.topRight, quadTree2.topRight);
    const bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
    const br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
    if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && tl.val === tr.val && tl.val === bl.val && tl.val === br.val) {
        return new Node(tl.val, true, null, null, null, null);
    }
    return new Node(false, false, tl, tr, bl, br);
};
