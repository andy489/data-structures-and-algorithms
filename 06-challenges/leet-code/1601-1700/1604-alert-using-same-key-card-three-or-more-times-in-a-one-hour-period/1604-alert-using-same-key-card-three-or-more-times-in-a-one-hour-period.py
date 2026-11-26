# https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/

from collections import defaultdict

class Solution:
    def alertNames(self, keyName: list[str], keyTime: list[str]) -> list[str]:
        time_map = defaultdict(list)
        for name, t in zip(keyName, keyTime):
            h, m = map(int, t.split(':'))
            time_map[name].append(h * 60 + m)
        alerted = []
        for name, times in time_map.items():
            times.sort()
            for j in range(2, len(times)):
                if times[j] - times[j - 2] <= 60:
                    alerted.append(name)
                    break
        return sorted(alerted)
