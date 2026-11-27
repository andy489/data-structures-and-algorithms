// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

class FindElements {
    constructor(root) {
        this.vals = new Set();
        const dfs = (node, val) => {
            if (!node) return;
            this.vals.add(val);
            dfs(node.left, 2*val+1);
            dfs(node.right, 2*val+2);
        };
        dfs(root, 0);
    }
    find(target) { return this.vals.has(target); }
}
