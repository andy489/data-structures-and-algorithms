// https://leetcode.com/problems/complete-binary-tree-inserter/

var CBTInserter = function(root) {
    this.root = root;
    this.candidates = [];
    const q = [root];
    for (let i = 0; i < q.length; i++) {
        const node = q[i];
        if (!node.left || !node.right) this.candidates.push(node);
        if (node.left) q.push(node.left);
        if (node.right) q.push(node.right);
    }
};

CBTInserter.prototype.insert = function(val) {
    const node = { val, left: null, right: null };
    const parent = this.candidates[0];
    if (!parent.left) {
        parent.left = node;
    } else {
        parent.right = node;
        this.candidates.shift();
    }
    this.candidates.push(node);
    return parent.val;
};

CBTInserter.prototype.get_root = function() {
    return this.root;
};
