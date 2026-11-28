# https://leetcode.com/problems/lexicographically-smallest-generated-string/

class Solution:
    def generateString(self, str1: str, str2: str) -> str:
        n, m = len(str1), len(str2)
        word = ['a'] * (n + m - 1)
        # Stamp all T positions
        for i in range(n):
            if str1[i] == 'T':
                for j in range(m):
                    if word[i + j] != 'a' and word[i + j] != str2[j]:
                        return ""
                    word[i + j] = str2[j]
        # Fix F positions
        for i in range(n):
            if str1[i] == 'F':
                if word[i:i + m] == list(str2):
                    pos = i + m - 1
                    # Check if pos is locked by a T
                    forced = any(
                        str1[k] == 'T'
                        for k in range(max(0, pos - m + 1), min(n, pos + 1))
                    )
                    if forced:
                        return ""
                    word[pos] = chr(ord(word[pos]) + 1)
        # Validate T windows
        for i in range(n):
            if str1[i] == 'T':
                if word[i:i + m] != list(str2):
                    return ""
        return ''.join(word)
