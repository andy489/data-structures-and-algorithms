# https://leetcode.com/problems/intersection-of-two-linked-lists/

# Solution: Two-pointer path equalisation — O(m + n) time, O(1) space
class Solution:
    def getIntersectionNode(self, headA, headB):
        pa, pb = headA, headB
        while pa is not pb:
            pa = headB if pa is None else pa.next
            pb = headA if pb is None else pb.next
        return pa
