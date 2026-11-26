# https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/

class Solution:
    def minKBitFlips(self, nums: list[int], k: int) -> int:
        n = len(nums)
        flip = [0] * n
        flipped = ans = 0
        for i in range(n):
            if i >= k:
                flipped ^= flip[i - k]
            if (nums[i] ^ flipped) == 0:
                if i + k > n:
                    return -1
                flip[i] = 1
                flipped ^= 1
                ans += 1
        return ans
