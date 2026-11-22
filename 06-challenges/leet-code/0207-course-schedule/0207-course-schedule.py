# https://leetcode.com/problems/course-schedule/

from collections import deque

# Solution: DFS Cycle Detection (3-colour) — O(V+E) time, O(V+E) space
class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        graph: list[list[int]] = [[] for _ in range(numCourses)]

        for a, b in prerequisites:
            graph[a].append(b)

        state = [0] * numCourses

        def dfs(node: int) -> bool:
            state[node] = 1

            for nb in graph[node]:
                if state[nb] == 1:
                    return False
                if state[nb] == 0 and not dfs(nb):
                    return False

            state[node] = 2
            return True

        return all(state[i] != 0 or dfs(i) for i in range(numCourses))

# Solution 2: Kahn's Algorithm (BFS Topological Sort) — O(V+E) time, O(V+E) space
class Solution2:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        graph: list[list[int]] = [[] for _ in range(numCourses)]
        in_degree = [0] * numCourses

        for a, b in prerequisites:
            graph[b].append(a)
            in_degree[a] += 1

        queue = deque(i for i in range(numCourses) if in_degree[i] == 0)
        count = 0

        while queue:
            course = queue.popleft()
            count += 1

            for nxt in graph[course]:
                in_degree[nxt] -= 1

                if in_degree[nxt] == 0:
                    queue.append(nxt)

        return count == numCourses
