// https://leetcode.com/problems/find-mode-in-binary-search-tree/

// Solution: Morris In-order Traversal — O(n) time, O(1) space
class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        int maxCount = 0, curCount = 0;
        Integer prev = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                if (prev != null && prev == curr.val) {
                    curCount++;
                } else {
                    curCount = 1;
                }
                if (curCount > maxCount) {
                    maxCount = curCount;
                    modes.clear();
                    modes.add(curr.val);
                } else if (curCount == maxCount) {
                    modes.add(curr.val);
                }
                prev = curr.val;
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    if (prev != null && prev == curr.val) {
                        curCount++;
                    } else {
                        curCount = 1;
                    }
                    if (curCount > maxCount) {
                        maxCount = curCount;
                        modes.clear();
                        modes.add(curr.val);
                    } else if (curCount == maxCount) {
                        modes.add(curr.val);
                    }
                    prev = curr.val;
                    curr = curr.right;
                }
            }
        }
        return modes.stream().mapToInt(Integer::intValue).toArray();
    }
}

// Solution 2: Recursive In-order — O(n) time, O(h) space
class Solution2 {
    private int maxCount = 0, curCount = 0;
    private Integer prev = null;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        return modes.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != null && prev == node.val) {
            curCount++;
        } else {
            curCount = 1;
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            modes.clear();
            modes.add(node.val);
        } else if (curCount == maxCount) {
            modes.add(node.val);
        }
        prev = node.val;
        inorder(node.right);
    }
}
