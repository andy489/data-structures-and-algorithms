# https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/

class Solution:
    def numOfSubarrays(self, arr) -> int:
        MOD = int(1e9) + 7
        result = 0
        even, odd, prefix = 1, 0, 0
        for x in arr:
            prefix += x
            if prefix & 1:
                result += even
                odd += 1
            else:
                result += odd
                even += 1
        return result % MOD
