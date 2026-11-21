// https://leetcode.com/problems/binary-search-tree-iterator/

// Solution 1: Controlled stack — O(1) avg time, O(h) space
class BSTIterator {
    private final Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

// Solution 2: Flattened list — O(n) init, O(1) per call, O(n) space
class BSTIterator2 {
    private final List<Integer> vals = new ArrayList<>();
    private int idx = 0;

    public BSTIterator2(TreeNode root) {
        inorder(root);
    }

    public int next() {
        return vals.get(idx++);
    }

    public boolean hasNext() {
        return idx < vals.size();
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        vals.add(node.val);
        inorder(node.right);
    }
}
