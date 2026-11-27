# https://leetcode.com/problems/valid-palindrome-ii/

class Solution:
    def validPalindrome(self, s: str) -> bool:
        def is_palin(lo, hi):
            while lo < hi:
                if s[lo] != s[hi]:
                    return False
                lo += 1; hi -= 1
            return True

        lo, hi = 0, len(s) - 1
        while lo < hi:
            if s[lo] != s[hi]:
                return is_palin(lo + 1, hi) or is_palin(lo, hi - 1)
            lo += 1; hi -= 1
        return True
