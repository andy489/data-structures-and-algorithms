# https://leetcode.com/problems/exclusive-time-of-functions/

class Solution:
    def exclusiveTime(self, n: int, logs: list[str]) -> list[int]:
        time = [0] * n
        stack = []
        prev_time = 0
        for log in logs:
            parts = log.split(":")
            func_id, log_type, ts = int(parts[0]), parts[1], int(parts[2])
            if log_type == "start":
                if stack:
                    time[stack[-1]] += ts - prev_time
                stack.append(func_id)
                prev_time = ts
            else:
                time[stack.pop()] += ts - prev_time + 1
                prev_time = ts + 1
        return time
