# https://leetcode.com/problems/delete-nodes-and-return-forest/

# Solution: Post-order DFS — O(n) time, O(n + d) space
class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[Optional[TreeNode]]:
        delete_set = set(to_delete)
        result = []

        def dfs(node, is_root):
            if not node:
                return None
            deleted = node.val in delete_set
            if not deleted and is_root:
                result.append(node)
            node.left = dfs(node.left, deleted)
            node.right = dfs(node.right, deleted)
            return None if deleted else node

        dfs(root, True)
        return result
