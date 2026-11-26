# https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

class Solution:
    def groupThePeople(self, groupSizes: list[int]) -> list[list[int]]:
        from collections import defaultdict
        pending = defaultdict(list)
        res = []
        for i, sz in enumerate(groupSizes):
            pending[sz].append(i)
            if len(pending[sz]) == sz:
                res.append(pending[sz][:])
                pending[sz].clear()
        return res
