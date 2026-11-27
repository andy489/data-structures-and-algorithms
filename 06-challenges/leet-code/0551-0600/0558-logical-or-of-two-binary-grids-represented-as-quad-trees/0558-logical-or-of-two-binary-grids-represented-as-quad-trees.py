# https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/
# Solution: Recursive quad-tree OR — O(n^2) time, O(log n) space
class Solution:
    def intersect(self, quadTree1, quadTree2):
        if quadTree1.isLeaf:
            return quadTree1 if quadTree1.val else quadTree2
        if quadTree2.isLeaf:
            return quadTree2 if quadTree2.val else quadTree1
        tl = self.intersect(quadTree1.topLeft, quadTree2.topLeft)
        tr = self.intersect(quadTree1.topRight, quadTree2.topRight)
        bl = self.intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
        br = self.intersect(quadTree1.bottomRight, quadTree2.bottomRight)
        if tl.isLeaf and tr.isLeaf and bl.isLeaf and br.isLeaf and tl.val == tr.val == bl.val == br.val:
            return Node(tl.val, True)
        return Node(False, False, tl, tr, bl, br)
