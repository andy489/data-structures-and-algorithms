# https://leetcode.com/problems/course-schedule-iii/

import heapq

class Solution:
    def scheduleCourse(self, courses: list[list[int]]) -> int:
        courses.sort(key=lambda c: c[1])
        max_heap = []
        time = 0
        for duration, last_day in courses:
            time += duration
            heapq.heappush(max_heap, -duration)
            if time > last_day:
                time += heapq.heappop(max_heap)
        return len(max_heap)
