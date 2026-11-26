# https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/

class Solution:
    def generateTheString(self, n: int) -> str:
        return 'a' * n if n % 2 else 'a' * (n-1) + 'b'
