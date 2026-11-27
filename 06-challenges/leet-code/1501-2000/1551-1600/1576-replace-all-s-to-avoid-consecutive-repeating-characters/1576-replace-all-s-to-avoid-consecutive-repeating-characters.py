# https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

class Solution:
    def modifyString(self, s: str) -> str:
        arr = list(s)
        n = len(arr)
        for i in range(n):
            if arr[i] == '?':
                for c in 'abc':
                    if (i == 0 or arr[i - 1] != c) and (i == n - 1 or arr[i + 1] != c):
                        arr[i] = c
                        break
        return ''.join(arr)
