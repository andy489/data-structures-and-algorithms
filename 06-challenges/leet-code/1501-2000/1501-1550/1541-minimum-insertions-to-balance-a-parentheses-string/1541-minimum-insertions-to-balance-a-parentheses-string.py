# https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

class Solution:
    def minInsertions(self, s: str) -> int:
        insertions = 0
        open_count = 0
        i = 0
        while i < len(s):
            if s[i] == '(':
                open_count += 1
                i += 1
            else:
                if i + 1 < len(s) and s[i + 1] == ')':
                    i += 2
                else:
                    insertions += 1
                    i += 1
                if open_count > 0:
                    open_count -= 1
                else:
                    insertions += 1
        insertions += open_count * 2
        return insertions
