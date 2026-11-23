// https://leetcode.com/problems/n-ary-tree-preorder-traversal/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        for (Node child : node.children) {
            dfs(child, result);
        }
    }
}

class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.add(curr.val);
            List<Node> children = curr.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return result;
    }
}
