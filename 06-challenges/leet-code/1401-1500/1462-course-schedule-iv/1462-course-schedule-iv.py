# https://leetcode.com/problems/course-schedule-iv/

class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: list[list[int]], queries: list[list[int]]) -> list[bool]:
        reach = [[False]*numCourses for _ in range(numCourses)]
        for u, v in prerequisites:
            reach[u][v] = True
        for k in range(numCourses):
            for i in range(numCourses):
                for j in range(numCourses):
                    if reach[i][k] and reach[k][j]:
                        reach[i][j] = True
        return [reach[u][v] for u, v in queries]
