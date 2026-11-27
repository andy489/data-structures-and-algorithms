# https://leetcode.com/problems/replace-all-digits-with-characters/

class Solution:
    def replaceDigits(self, s: str) -> str:
        arr = list(s)
        for i in range(1, len(arr), 2):
            arr[i] = chr(ord(arr[i - 1]) + int(arr[i]))
        return "".join(arr)
