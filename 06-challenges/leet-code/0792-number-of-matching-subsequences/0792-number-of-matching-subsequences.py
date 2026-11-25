# https://leetcode.com/problems/number-of-matching-subsequences/

from collections import defaultdict

class Solution:
    def numMatchingSubseq(self, s: str, words: list[str]) -> int:
        buckets = defaultdict(list)
        for w in words:
            buckets[w[0]].append(iter(w))
        count = 0
        for c in s:
            waiting = buckets.pop(c, [])
            for it in waiting:
                next(it)
                nxt = next(it, None)
                if nxt is None:
                    count += 1
                else:
                    buckets[nxt].append(it)
        return count
