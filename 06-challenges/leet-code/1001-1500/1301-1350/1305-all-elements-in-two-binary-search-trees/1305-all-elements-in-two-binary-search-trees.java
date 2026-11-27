// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

// Solution: Inorder + Merge — O(m+n) time, O(m+n) space
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        inorder(root1, l1);
        inorder(root2, l2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) res.add(l1.get(i++));
            else res.add(l2.get(j++));
        }
        while (i < l1.size()) res.add(l1.get(i++));
        while (j < l2.size()) res.add(l2.get(j++));
        return res;
    }
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
