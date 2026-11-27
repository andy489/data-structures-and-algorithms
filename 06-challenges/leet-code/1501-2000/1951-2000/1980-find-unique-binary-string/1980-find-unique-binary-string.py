# https://leetcode.com/problems/find-unique-binary-string/

class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        return ''.join('1' if nums[i][i] == '0' else '0' for i in range(len(nums)))
