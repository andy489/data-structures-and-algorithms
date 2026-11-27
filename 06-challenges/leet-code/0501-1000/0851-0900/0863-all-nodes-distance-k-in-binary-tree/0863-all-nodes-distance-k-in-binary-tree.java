// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

// Solution: BFS with Parent Pointers — O(n) time, O(n) space
class Solution {
    private Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParentMap(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int dist = 0;
        while (!queue.isEmpty()) {
            if (dist == k) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode neighbor : new TreeNode[]{node.left, node.right, parent.get(node)}) {
                    if (neighbor != null && !visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            dist++;
        }
        return new ArrayList<>();
    }

    private void buildParentMap(TreeNode node, TreeNode par) {
        if (node == null) {
            return;
        }
        parent.put(node, par);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }
}
