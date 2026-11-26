// https://leetcode.com/problems/n-ary-tree-postorder-traversal/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        for (Node child : node.children) {
            dfs(child, result);
        }
        result.add(node.val);
    }
}

class Solution2 {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.addFirst(curr.val);
            for (Node child : curr.children) {
                stack.push(child);
            }
        }
        return result;
    }
}
