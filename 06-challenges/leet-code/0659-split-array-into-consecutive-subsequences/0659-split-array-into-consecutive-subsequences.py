# https://leetcode.com/problems/split-array-into-consecutive-subsequences/

class Solution:
    def isPossible(self, nums: list) -> bool:
        from collections import Counter
        freq = Counter(nums)
        append_freq = Counter()
        for num in nums:
            if freq[num] == 0:
                continue
            if append_freq[num] > 0:
                append_freq[num] -= 1
                append_freq[num + 1] += 1
            elif freq[num + 1] > 0 and freq[num + 2] > 0:
                freq[num + 1] -= 1
                freq[num + 2] -= 1
                append_freq[num + 3] += 1
            else:
                return False
            freq[num] -= 1
        return True
