# https://leetcode.com/problems/most-frequent-subtree-sum/

from collections import Counter

class Solution:
    def findFrequentTreeSum(self, root) -> list[int]:
        counts = Counter()

        def dfs(node):
            if not node:
                return 0
            s = node.val + dfs(node.left) + dfs(node.right)
            counts[s] += 1
            return s

        dfs(root)
        max_freq = max(counts.values())
        return [s for s, c in counts.items() if c == max_freq]
