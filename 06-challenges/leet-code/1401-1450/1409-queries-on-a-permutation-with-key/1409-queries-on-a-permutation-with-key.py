# https://leetcode.com/problems/queries-on-a-permutation-with-key/

class Solution:
    def processQueries(self, queries: list[int], m: int) -> list[int]:
        perm = list(range(1, m + 1))
        res = []
        for q in queries:
            pos = perm.index(q)
            res.append(pos + 1)
            perm.pop(pos)
            perm.insert(0, q)
        return res
