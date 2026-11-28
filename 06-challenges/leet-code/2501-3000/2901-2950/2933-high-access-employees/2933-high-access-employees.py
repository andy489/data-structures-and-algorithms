# https://leetcode.com/problems/high-access-employees/

from collections import defaultdict

class Solution:
    def findHighAccessEmployees(self, access_times: list[list[str]]) -> list[str]:
        times_by_emp = defaultdict(list)
        for name, t in access_times:
            minutes = int(t[:2]) * 60 + int(t[2:])
            times_by_emp[name].append(minutes)

        result = []
        for name, times in times_by_emp.items():
            times.sort()
            for i in range(len(times) - 2):
                if times[i + 2] - times[i] < 60:
                    result.append(name)
                    break
        return result
