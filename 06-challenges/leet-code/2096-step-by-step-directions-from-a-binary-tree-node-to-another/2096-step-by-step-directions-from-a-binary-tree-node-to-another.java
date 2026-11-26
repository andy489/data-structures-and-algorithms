// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

// Solution: LCA + Path Finding — O(n) time, O(n) space
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> pathToStart = new ArrayList<>(), pathToDest = new ArrayList<>();
        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);
        int i = 0;
        while (i < pathToStart.size() && i < pathToDest.size() && pathToStart.get(i) == pathToDest.get(i)) { i++; }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < pathToStart.size(); j++) { sb.append('U'); }
        for (int j = i; j < pathToDest.size(); j++) { sb.append(pathToDest.get(j)); }
        return sb.toString();
    }
    private boolean findPath(TreeNode node, int target, List<Character> path) {
        if (node == null) { return false; }
        if (node.val == target) { return true; }
        path.add('L');
        if (findPath(node.left, target, path)) { return true; }
        path.remove(path.size() - 1);
        path.add('R');
        if (findPath(node.right, target, path)) { return true; }
        path.remove(path.size() - 1);
        return false;
    }
}
