# https://leetcode.com/problems/make-three-strings-equal/

class Solution:
    def findMinimumOperations(self, s1: str, s2: str, s3: str) -> int:
        min_len = min(len(s1), len(s2), len(s3))
        prefix = 0
        for i in range(min_len):
            if s1[i] == s2[i] == s3[i]:
                prefix += 1
            else:
                break
        if prefix == 0:
            return -1
        return (len(s1) - prefix) + (len(s2) - prefix) + (len(s3) - prefix)
