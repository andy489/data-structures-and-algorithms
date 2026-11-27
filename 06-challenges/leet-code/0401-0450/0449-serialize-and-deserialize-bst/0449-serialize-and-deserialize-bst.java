// https://leetcode.com/problems/serialize-and-deserialize-bst/

// Solution: Preorder Traversal — O(n) time, O(n) space
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString().trim();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val).append(' ');
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (String token : data.split(" ")) {
            queue.offer(Integer.parseInt(token));
        }
        return buildBST(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildBST(Deque<Integer> queue, int min, int max) {
        if (queue.isEmpty()) {
            return null;
        }
        int val = queue.peek();
        if (val < min || val > max) {
            return null;
        }
        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = buildBST(queue, min, val);
        node.right = buildBST(queue, val, max);
        return node;
    }
}
