# https://leetcode.com/problems/find-all-people-with-secret/

class Solution:
    def findAllPeople(self, n: int, meetings: list[list[int]], firstPerson: int) -> list[int]:
        parent = list(range(n))
        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x
        def union(a, b):
            a, b = find(a), find(b)
            if a != b:
                parent[b] = a
        union(0, firstPerson)
        meetings.sort(key=lambda x: x[2])
        i = 0
        while i < len(meetings):
            j, t = i, meetings[i][2]
            while j < len(meetings) and meetings[j][2] == t:
                j += 1
            people = set()
            for x, y, _ in meetings[i:j]:
                union(x, y)
                people.add(x)
                people.add(y)
            for p in people:
                if find(p) != find(0):
                    parent[p] = p
            i = j
        root0 = find(0)
        return [i for i in range(n) if find(i) == root0]
