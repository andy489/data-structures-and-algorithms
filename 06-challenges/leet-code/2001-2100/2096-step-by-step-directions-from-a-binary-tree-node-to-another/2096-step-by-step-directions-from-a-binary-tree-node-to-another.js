// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

// Solution: LCA + Path Finding — O(n) time, O(n) space
var getDirections = function(root, startValue, destValue) {
    const findPath = (node, target, path) => {
        if (!node) return false;
        if (node.val === target) return true;
        path.push('L');
        if (findPath(node.left, target, path)) return true;
        path.pop();
        path.push('R');
        if (findPath(node.right, target, path)) return true;
        path.pop();
        return false;
    };
    const pathS = [], pathD = [];
    findPath(root, startValue, pathS);
    findPath(root, destValue, pathD);
    let i = 0;
    while (i < pathS.length && i < pathD.length && pathS[i] === pathD[i]) i++;
    return 'U'.repeat(pathS.length - i) + pathD.slice(i).join('');
};
