# https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/

class Solution:
    def maxDiff(self, num: int) -> int:
        s = str(num)
        max_s = s
        for c in s:
            if c != '9':
                max_s = s.replace(c, '9')
                break
        min_s = s
        if s[0] != '1':
            min_s = s.replace(s[0], '1')
        else:
            for c in s[1:]:
                if c not in '01':
                    min_s = s.replace(c, '0')
                    break
        return int(max_s) - int(min_s)
