# https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

class Solution:
    def maxSumBST(self, root) -> int:
        self.ans = 0
        INF = float('inf')
        def dfs(node):
            if not node:
                return 1, INF, -INF, 0
            lbst, lmin, lmax, lsum = dfs(node.left)
            rbst, rmin, rmax, rsum = dfs(node.right)
            if lbst and rbst and node.val > lmax and node.val < rmin:
                s = node.val + lsum + rsum
                self.ans = max(self.ans, s)
                return 1, min(lmin, node.val), max(rmax, node.val), s
            return 0, 0, 0, 0
        dfs(root)
        return self.ans
