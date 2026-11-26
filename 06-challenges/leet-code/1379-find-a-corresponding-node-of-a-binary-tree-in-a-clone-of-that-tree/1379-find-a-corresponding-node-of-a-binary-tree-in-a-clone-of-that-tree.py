# https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

class Solution:
    def getTargetCopy(self, original, cloned, target):
        if not original:
            return None
        if original is target:
            return cloned
        return self.getTargetCopy(original.left, cloned.left, target) or \
               self.getTargetCopy(original.right, cloned.right, target)
