# https://leetcode.com/problems/task-scheduler/

from collections import Counter

class Solution:
    def leastInterval(self, tasks: list[str], n: int) -> int:
        freq = Counter(tasks)
        max_freq = max(freq.values())
        max_count = sum(1 for f in freq.values() if f == max_freq)
        return max(len(tasks), (max_freq - 1) * (n + 1) + max_count)
