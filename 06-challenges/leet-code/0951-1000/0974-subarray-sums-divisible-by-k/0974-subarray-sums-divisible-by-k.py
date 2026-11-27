# https://leetcode.com/problems/subarray-sums-divisible-by-k/

class Solution:
    def subarraysDivByK(self, nums: list[int], k: int) -> int:
        count = {0: 1}
        prefix = ans = 0
        for x in nums:
            prefix = (prefix + x) % k
            ans += count.get(prefix, 0)
            count[prefix] = count.get(prefix, 0) + 1
        return ans
