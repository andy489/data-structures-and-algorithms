# https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/
class Solution:
    def maxDistance(self, s: str, k: int) -> int:
        opp = {'N': 'S', 'S': 'N', 'E': 'W', 'W': 'E'}
        res = 0
        for t1, t2 in [('N', 'E'), ('N', 'W'), ('S', 'E'), ('S', 'W')]:
            a1 = a2 = changes = 0
            for c in s:
                if c == t1:
                    a1 += 1
                elif c == t2:
                    a2 += 1
                elif changes < k:
                    changes += 1
                    if c == opp[t1]:
                        a1 += 1
                    else:
                        a2 += 1
                else:
                    if c == opp[t1]:
                        a1 -= 1
                    else:
                        a2 -= 1
                res = max(res, a1 + a2)
        return res
