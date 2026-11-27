# https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/

class Solution:
    def maxNumOfSubstrings(self, s: str):
        first = {}
        last = {}
        for i, c in enumerate(s):
            if c not in first:
                first[c] = i
            last[c] = i

        def get_right(i):
            r = last[s[i]]
            j = i
            while j <= r:
                c = s[j]
                if first[c] < i:
                    return -1
                r = max(r, last[c])
                j += 1
            return r

        result = []
        prev_end = -1
        for i, c in enumerate(s):
            if first[c] != i:
                continue
            r = get_right(i)
            if r == -1:
                continue
            if i > prev_end:
                result.append(s[i:r + 1])
                prev_end = r
            elif r - i + 1 < len(result[-1]):
                result[-1] = s[i:r + 1]
                prev_end = r
        return result
