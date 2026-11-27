# https://leetcode.com/problems/student-attendance-record-i/
# Solution: String scan — O(n) time, O(1) space
class Solution:
    def checkRecord(self, s: str) -> bool:
        return s.count('A') < 2 and 'LLL' not in s
