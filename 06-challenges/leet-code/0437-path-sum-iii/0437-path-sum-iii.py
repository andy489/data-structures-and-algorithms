# https://leetcode.com/problems/path-sum-iii/

class Solution:
    def pathSum(self, root, targetSum: int) -> int:
        from collections import defaultdict
        prefix_counts = defaultdict(int)
        prefix_counts[0] = 1

        def dfs(node, current_sum):
            if not node:
                return 0
            current_sum += node.val
            count = prefix_counts[current_sum - targetSum]
            prefix_counts[current_sum] += 1
            count += dfs(node.left, current_sum)
            count += dfs(node.right, current_sum)
            prefix_counts[current_sum] -= 1
            return count

        return dfs(root, 0)
