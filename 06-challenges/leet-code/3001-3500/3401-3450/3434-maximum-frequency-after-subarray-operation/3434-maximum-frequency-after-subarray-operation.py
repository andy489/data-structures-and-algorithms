# https://leetcode.com/problems/maximum-frequency-after-subarray-operation/
class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        count_k = nums.count(k)
        best = count_k

        for v in range(1, 51):
            if v == k:
                continue
            cur = 0
            max_gain = 0
            for num in nums:
                if num == v:
                    cur += 1
                elif num == k:
                    cur -= 1
                if cur < 0:
                    cur = 0
                if cur > max_gain:
                    max_gain = cur
            total = count_k + max_gain
            if total > best:
                best = total

        return best
