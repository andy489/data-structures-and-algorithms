// https://leetcode.com/problems/binary-tree-postorder-traversal/

// Solution: Reverse Preorder with Stack — O(n) time, O(n) space
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if (node.left  != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return result;
    }
}

// Solution 2: Recursive DFS — O(n) time, O(h) space
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        dfs(node.left,  result);
        dfs(node.right, result);
        result.add(node.val);
    }
}

// Solution 3: Iterative with Two Stacks — O(n) time, O(n) space
class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> out   = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            out.push(node);
            if (node.left  != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        while (!out.isEmpty()) {
            result.add(out.pop().val);
        }
        return result;
    }
}

// Solution 4: Morris Postorder Traversal — O(n) time, O(1) space
class Solution4 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode curr = dummy;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    addReversed(curr.left, pred, result);
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    private void addReversed(TreeNode from, TreeNode to, List<Integer> result) {
        reverse(from, to);
        TreeNode node = to;
        while (true) {
            result.add(node.val);
            if (node == from) break;
            node = node.right;
        }
        reverse(to, from);
    }

    private void reverse(TreeNode from, TreeNode to) {
        if (from == to) return;
        TreeNode prev = from, curr = from.right;
        while (prev != to) {
            TreeNode next = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
    }
}
