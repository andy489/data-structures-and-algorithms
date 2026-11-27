# https://leetcode.com/problems/the-number-of-beautiful-subsets/
class Solution:
    def beautifulSubsets(self, nums: list[int], k: int) -> int:
        nums.sort()
        freq = {}
        count = [0]

        def backtrack(idx: int) -> None:
            for i in range(idx, len(nums)):
                num = nums[i]
                if freq.get(num - k, 0) == 0:
                    freq[num] = freq.get(num, 0) + 1
                    count[0] += 1
                    backtrack(i + 1)
                    freq[num] -= 1
                    if freq[num] == 0:
                        del freq[num]

        backtrack(0)
        return count[0]
