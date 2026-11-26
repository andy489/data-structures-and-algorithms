# https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

class Solution:
    def buildTree(self, inorder, postorder):
        inorder_index = {val: i for i, val in enumerate(inorder)}

        def build(in_l, in_r, post_l, post_r):
            if in_l > in_r:
                return None
            root = TreeNode(postorder[post_r])
            mid = inorder_index[postorder[post_r]]
            left_size = mid - in_l
            root.left = build(in_l, mid - 1, post_l, post_l + left_size - 1)
            root.right = build(mid + 1, in_r, post_l + left_size, post_r - 1)
            return root

        return build(0, len(inorder) - 1, 0, len(postorder) - 1)


class Solution2:
    def buildTree(self, inorder, postorder):
        root = TreeNode(postorder[-1])
        stack = [root]
        inorder_idx = len(inorder) - 1
        for i in range(len(postorder) - 2, -1, -1):
            node = TreeNode(postorder[i])
            if stack[-1].val != inorder[inorder_idx]:
                stack[-1].right = node
            else:
                parent = None
                while stack and stack[-1].val == inorder[inorder_idx]:
                    parent = stack.pop()
                    inorder_idx -= 1
                parent.left = node
            stack.append(node)
        return root
