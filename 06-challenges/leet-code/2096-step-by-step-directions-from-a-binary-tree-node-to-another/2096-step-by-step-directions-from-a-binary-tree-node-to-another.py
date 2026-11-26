# https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

class Solution:
    def getDirections(self, root, startValue: int, destValue: int) -> str:
        def find_path(node, target, path):
            if not node:
                return False
            if node.val == target:
                return True
            path.append('L')
            if find_path(node.left, target, path):
                return True
            path.pop()
            path.append('R')
            if find_path(node.right, target, path):
                return True
            path.pop()
            return False
        path_s, path_d = [], []
        find_path(root, startValue, path_s)
        find_path(root, destValue, path_d)
        i = 0
        while i < len(path_s) and i < len(path_d) and path_s[i] == path_d[i]:
            i += 1
        return 'U' * (len(path_s) - i) + ''.join(path_d[i:])
