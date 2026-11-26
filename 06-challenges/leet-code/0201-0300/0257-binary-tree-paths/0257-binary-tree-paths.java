// https://leetcode.com/problems/binary-tree-paths/

// Solution 1: DFS Recursive — O(n) time, O(h) space
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode node, String path, List<String> res) {
        if (node == null) {
            return;
        }
        path += node.val;
        if (node.left == null && node.right == null) {
            res.add(path);
        } else {
            path += "->";
            dfs(node.left, path, res);
            dfs(node.right, path, res);
        }
    }
}

// Solution 2: DFS Iterative — O(n) time, O(n) space
class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<String> paths = new ArrayDeque<>();
        nodes.push(root);
        paths.push(String.valueOf(root.val));
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            String path = paths.pop();
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            if (node.right != null) {
                nodes.push(node.right);
                paths.push(path + "->" + node.right.val);
            }
            if (node.left != null) {
                nodes.push(node.left);
                paths.push(path + "->" + node.left.val);
            }
        }
        return res;
    }
}
