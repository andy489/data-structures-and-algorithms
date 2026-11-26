// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// Solution: Preorder DFS with Null Markers — O(n) time, O(n) space
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serDfs(root, sb);
        return sb.toString();
    }

    private void serDfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(',');
        serDfs(node.left, sb);
        serDfs(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        Queue<String> tokens = new LinkedList<>(Arrays.asList(data.split(",")));
        return desDfs(tokens);
    }

    private TreeNode desDfs(Queue<String> tokens) {
        String token = tokens.poll();
        if ("#".equals(token)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = desDfs(tokens);
        node.right = desDfs(tokens);
        return node;
    }
}
