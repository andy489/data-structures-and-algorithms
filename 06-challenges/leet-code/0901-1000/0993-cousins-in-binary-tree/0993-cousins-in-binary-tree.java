// https://leetcode.com/problems/cousins-in-binary-tree/

// Solution: BFS — O(n) time, O(n) space
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<int[]> queue = new LinkedList<>(); // [val, parentVal]
        queue.offer(new int[]{root.val, -1});
        Map<Integer, TreeNode> children = new HashMap<>();
        children.put(root.val, root);
        // BFS with parent tracking
        int xParent = -1, yParent = -1, xDepth = -1, yDepth = -1;
        int depth = 0;
        Queue<TreeNode[]> q2 = new LinkedList<>();
        q2.offer(new TreeNode[]{root, null});
        while (!q2.isEmpty()) {
            int size = q2.size();
            for (int i = 0; i < size; i++) {
                TreeNode[] entry = q2.poll();
                TreeNode node = entry[0], parent = entry[1];
                int pVal = parent == null ? -1 : parent.val;
                if (node.val == x) { xParent = pVal; xDepth = depth; }
                if (node.val == y) { yParent = pVal; yDepth = depth; }
                if (node.left != null) { q2.offer(new TreeNode[]{node.left, node}); }
                if (node.right != null) { q2.offer(new TreeNode[]{node.right, node}); }
            }
            depth++;
        }
        return xDepth == yDepth && xParent != yParent;
    }
}
