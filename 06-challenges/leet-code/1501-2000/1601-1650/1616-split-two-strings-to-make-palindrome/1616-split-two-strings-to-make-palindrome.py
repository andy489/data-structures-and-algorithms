# https://leetcode.com/problems/split-two-strings-to-make-palindrome/

class Solution:
    def checkPalindromeFormation(self, a: str, b: str) -> bool:
        def check(a: str, b: str) -> bool:
            l, r = 0, len(a) - 1
            while l < r and a[l] == b[r]:
                l += 1
                r -= 1
            return is_palindrome(a, l, r) or is_palindrome(b, l, r)

        def is_palindrome(s: str, l: int, r: int) -> bool:
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True

        return check(a, b) or check(b, a)
