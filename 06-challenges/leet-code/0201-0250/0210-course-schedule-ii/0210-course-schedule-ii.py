# https://leetcode.com/problems/course-schedule-ii/

from collections import deque

# Solution: Kahn's Algorithm (BFS Topological Sort) — O(V+E) time, O(V+E) space
class Solution:
    def findOrder(self, numCourses: int, prerequisites: list[list[int]]) -> list[int]:
        graph: list[list[int]] = [[] for _ in range(numCourses)]
        in_degree = [0] * numCourses

        for a, b in prerequisites:
            graph[b].append(a)
            in_degree[a] += 1

        queue = deque(i for i in range(numCourses) if in_degree[i] == 0)
        order: list[int] = []

        while queue:
            course = queue.popleft()
            order.append(course)

            for nxt in graph[course]:
                in_degree[nxt] -= 1

                if in_degree[nxt] == 0:
                    queue.append(nxt)

        return order if len(order) == numCourses else []

# Solution 2: DFS Post-order — O(V+E) time, O(V+E) space
class Solution2:
    def findOrder(self, numCourses: int, prerequisites: list[list[int]]) -> list[int]:
        graph: list[list[int]] = [[] for _ in range(numCourses)]

        for a, b in prerequisites:
            graph[a].append(b)

        state = [0] * numCourses
        stack: list[int] = []

        def dfs(node: int) -> bool:
            state[node] = 1

            for nb in graph[node]:
                if state[nb] == 1:
                    return False
                if state[nb] == 0 and not dfs(nb):
                    return False

            state[node] = 2
            stack.append(node)
            return True

        for i in range(numCourses):
            if state[i] == 0 and not dfs(i):
                return []

        return stack[::-1]
