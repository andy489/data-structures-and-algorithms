# https://leetcode.com/problems/avoid-flood-in-the-city/

class Solution:
    def avoidFlood(self, rains: list[int]) -> list[int]:
        import sortedcontainers
        n = len(rains)
        res = [-1] * n
        full = {}
        dry_days = sortedcontainers.SortedList()
        for i, rain in enumerate(rains):
            if rain == 0:
                dry_days.add(i)
                res[i] = 1
            else:
                if rain in full:
                    idx = dry_days.bisect_left(full[rain])
                    if idx == len(dry_days):
                        return []
                    day = dry_days[idx]
                    res[day] = rain
                    dry_days.remove(day)
                full[rain] = i
        return res
