# https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        slots = 1
        for token in preorder.split(','):
            slots -= 1
            if slots < 0:
                return False
            if token != '#':
                slots += 2
        return slots == 0
