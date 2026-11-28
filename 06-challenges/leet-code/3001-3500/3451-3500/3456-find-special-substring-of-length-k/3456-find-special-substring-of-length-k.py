# https://leetcode.com/problems/find-special-substring-of-length-k/

class Solution:
    def hasSpecialSubstring(self, s: str, k: int) -> bool:
        n = len(s)
        i = 0
        while i < n:
            c = s[i]
            j = i
            while j < n and s[j] == c:
                j += 1
            length = j - i
            if length == k:
                valid_before = (i == 0 or s[i - 1] != c)
                valid_after = (j == n or s[j] != c)
                if valid_before and valid_after:
                    return True
            i = j
        return False
