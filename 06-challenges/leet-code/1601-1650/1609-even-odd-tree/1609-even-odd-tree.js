// https://leetcode.com/problems/even-odd-tree/

var isEvenOddTree = function(root) {
    const queue = [root];
    let evenLevel = true;
    while (queue.length > 0) {
        let prev = evenLevel ? -Infinity : Infinity;
        const size = queue.length;
        for (let i = 0; i < size; i++) {
            const node = queue.shift();
            const val = node.val;
            if (evenLevel && (val % 2 === 0 || val <= prev)) {
                return false;
            }
            if (!evenLevel && (val % 2 !== 0 || val >= prev)) {
                return false;
            }
            prev = val;
            if (node.left) {
                queue.push(node.left);
            }
            if (node.right) {
                queue.push(node.right);
            }
        }
        evenLevel = !evenLevel;
    }
    return true;
};
