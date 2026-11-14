# https://leetcode.com/problems/unique-binary-search-trees-ii/

# Solution: Divide and Conquer (Recursion) — O(Cₙ·n) time, O(Cₙ·n) space
class Solution:
    def generateTrees(self, n: int):
        def generate(lo, hi):
            if lo > hi:
                return [None]
            result = []
            for i in range(lo, hi + 1):
                for left in generate(lo, i - 1):
                    for right in generate(i + 1, hi):
                        root = TreeNode(i)
                        root.left = left
                        root.right = right
                        result.append(root)
            return result

        return generate(1, n)


# Solution 2: Memoized Recursion — O(Cₙ·n) time, O(Cₙ·n) space
class Solution2:
    def generateTrees(self, n: int):
        memo = {}

        def generate(lo, hi):
            if (lo, hi) in memo:
                return memo[(lo, hi)]
            if lo > hi:
                return [None]
            result = []
            for i in range(lo, hi + 1):
                for left in generate(lo, i - 1):
                    for right in generate(i + 1, hi):
                        root = TreeNode(i)
                        root.left = left
                        root.right = right
                        result.append(root)
            memo[(lo, hi)] = result
            return result

        return generate(1, n)
