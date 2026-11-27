# https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/

# Solution: String Replacement — O(d) time, O(d) space
class Solution:
    def minMaxDifference(self, num: int) -> int:
        s = str(num)
        # Maximize: replace first non-9 digit with 9
        to_max = next((c for c in s if c != '9'), None)
        max_val = int(s.replace(to_max, '9')) if to_max else num
        # Minimize: replace first digit with 0
        min_val = int(s.replace(s[0], '0'))
        return max_val - min_val
