# https://leetcode.com/problems/employee-importance/

from collections import deque

class Solution:
    def getImportance(self, employees: list, id: int) -> int:
        id_map = {e.id: e for e in employees}
        total = 0
        queue = deque([id])
        while queue:
            e = id_map[queue.popleft()]
            total += e.importance
            queue.extend(e.subordinates)
        return total
