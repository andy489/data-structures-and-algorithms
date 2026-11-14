# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Solution 1: Recursive DFS with HashMap
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_index = {val: i for i, val in enumerate(inorder)}

        def build(pre_l, pre_r, in_l, in_r):
            if pre_l > pre_r:
                return None
            root_val = preorder[pre_l]
            mid = inorder_index[root_val]
            left_size = mid - in_l
            root = TreeNode(root_val)
            root.left = build(pre_l + 1, pre_l + left_size, in_l, mid - 1)
            root.right = build(pre_l + left_size + 1, pre_r, mid + 1, in_r)
            return root

        return build(0, len(preorder) - 1, 0, len(inorder) - 1)


# Solution 2: Iterative with Stack
class Solution2:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        root = TreeNode(preorder[0])
        stack = [root]
        inorder_idx = 0
        for i in range(1, len(preorder)):
            node = TreeNode(preorder[i])
            if stack[-1].val != inorder[inorder_idx]:
                stack[-1].left = node
            else:
                parent = None
                while stack and stack[-1].val == inorder[inorder_idx]:
                    parent = stack.pop()
                    inorder_idx += 1
                parent.right = node
            stack.append(node)
        return root

