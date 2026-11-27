# https://leetcode.com/problems/russian-doll-envelopes/

import bisect

class Solution:
    def maxEnvelopes(self, envelopes: list[list[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        tails = []
        for _, h in envelopes:
            pos = bisect.bisect_left(tails, h)
            if pos == len(tails):
                tails.append(h)
            else:
                tails[pos] = h
        return len(tails)
