# https://leetcode.com/problems/reverse-string-ii/
# Solution: Chunk traversal — O(n) time, O(n) space
class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        chars = list(s)
        n = len(chars)
        for i in range(0, n, 2 * k):
            left, right = i, min(i + k - 1, n - 1)
            while left < right:
                chars[left], chars[right] = chars[right], chars[left]
                left += 1
                right -= 1
        return ''.join(chars)
