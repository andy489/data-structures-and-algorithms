# https://leetcode.com/problems/find-duplicate-subtrees/

class Solution:
    def findDuplicateSubtrees(self, root) -> list:
        seen = {}
        result = []

        def serialize(node):
            if not node:
                return "#"
            key = serialize(node.left) + "," + serialize(node.right) + "," + str(node.val)
            seen[key] = seen.get(key, 0) + 1
            if seen[key] == 2:
                result.append(node)
            return key

        serialize(root)
        return result
