# https://leetcode.com/problems/crawler-log-folder/

class Solution:
    def minOperations(self, logs: list[str]) -> int:
        depth = 0
        for log in logs:
            if log == '../':
                depth = max(0, depth - 1)
            elif log != './':
                depth += 1
        return depth
