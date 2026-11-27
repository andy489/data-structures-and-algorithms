// https://leetcode.com/problems/complete-binary-tree-inserter/

// Solution: BFS Candidate Queue — O(n) init, O(1) insert
class CBTInserter {
    private TreeNode root;
    private java.util.Deque<TreeNode> candidates;

    public CBTInserter(TreeNode root) {
        this.root = root;
        candidates = new java.util.ArrayDeque<>();
        java.util.Queue<TreeNode> q = new java.util.ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left == null || node.right == null) {
                candidates.add(node);
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode parent = candidates.peek();
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            candidates.poll();
        }
        candidates.add(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
