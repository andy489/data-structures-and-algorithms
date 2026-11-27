# https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

class FindElements:
    def __init__(self, root):
        self.vals = set()
        def dfs(node, val):
            if not node: return
            self.vals.add(val)
            dfs(node.left, 2*val+1)
            dfs(node.right, 2*val+2)
        dfs(root, 0)
    def find(self, target: int) -> bool:
        return target in self.vals
