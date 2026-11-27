# https://leetcode.com/problems/design-task-manager/
from sortedcontainers import SortedList

class TaskManager:

    def __init__(self, tasks: list[list[int]]):
        # Store (priority, taskId) in sorted list; negate for max behavior
        self.task_set = SortedList(key=lambda x: (-x[0], -x[1]))
        self.task_map = {}  # taskId -> [userId, priority]
        for userId, taskId, priority in tasks:
            self.task_set.add((priority, taskId))
            self.task_map[taskId] = [userId, priority]

    def add(self, userId: int, taskId: int, priority: int) -> None:
        self.task_set.add((priority, taskId))
        self.task_map[taskId] = [userId, priority]

    def edit(self, taskId: int, newPriority: int) -> None:
        info = self.task_map[taskId]
        self.task_set.remove((info[1], taskId))
        self.task_set.add((newPriority, taskId))
        self.task_map[taskId] = [info[0], newPriority]

    def rmv(self, taskId: int) -> None:
        info = self.task_map.pop(taskId)
        self.task_set.remove((info[1], taskId))

    def execTop(self) -> int:
        if not self.task_set:
            return -1
        priority, taskId = self.task_set[-1]
        self.task_set.pop(-1)
        info = self.task_map.pop(taskId)
        return info[0]
