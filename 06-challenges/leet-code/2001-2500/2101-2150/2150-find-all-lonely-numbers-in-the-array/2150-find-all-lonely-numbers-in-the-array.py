# https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
class Solution:
    def findLonely(self, nums: List[int]) -> List[int]:
        freq = Counter(nums)
        return [x for x in freq if freq[x] == 1 and x - 1 not in freq and x + 1 not in freq]
