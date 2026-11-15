// https://leetcode.com/problems/path-sum-ii/

// Solution: DFS Backtracking — O(n²) time, O(h) space
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int remaining, List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        remaining -= node.val;
        if (node.left == null && node.right == null && remaining == 0) {
            result.add(new ArrayList<>(path));
        }
        dfs(node.left,  remaining, path, result);
        dfs(node.right, remaining, path, result);
        path.remove(path.size() - 1);
    }
}

// Solution 2: Iterative DFS with Explicit Stack — O(n²) time, O(n) space
class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Object[]> stack = new ArrayDeque<>();
        List<Integer> rootPath = new ArrayList<>();
        rootPath.add(root.val);
        stack.push(new Object[]{root, targetSum - root.val, rootPath});
        while (!stack.isEmpty()) {
            Object[] entry = stack.pop();
            TreeNode node      = (TreeNode)       entry[0];
            int remaining      = (int)             entry[1];
            List<Integer> path = (List<Integer>)  entry[2];
            if (node.left == null && node.right == null && remaining == 0) {
                result.add(path);
            }
            for (TreeNode child : new TreeNode[]{node.right, node.left}) {
                if (child != null) {
                    List<Integer> childPath = new ArrayList<>(path);
                    childPath.add(child.val);
                    stack.push(new Object[]{child, remaining - child.val, childPath});
                }
            }
        }
        return result;
    }
}
