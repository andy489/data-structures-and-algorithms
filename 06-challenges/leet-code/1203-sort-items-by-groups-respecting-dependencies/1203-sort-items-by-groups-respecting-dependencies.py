# https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/

class Solution:
    def sortItems(self, n: int, m: int, group: list[int], beforeItems: list[list[int]]) -> list[int]:
        from collections import deque, defaultdict
        for i in range(n):
            if group[i] == -1: group[i] = m; m += 1
        item_graph = defaultdict(list); group_graph = defaultdict(list)
        item_deg = [0]*n; group_deg = [0]*m
        for i in range(n):
            for pre in beforeItems[i]:
                item_graph[pre].append(i); item_deg[i] += 1
                if group[pre] != group[i]: group_graph[group[pre]].append(group[i]); group_deg[group[i]] += 1
        def topo(graph, deg, size):
            q = deque(i for i in range(size) if deg[i] == 0)
            res = []
            while q:
                u = q.popleft(); res.append(u)
                for v in graph[u]:
                    deg[v] -= 1
                    if deg[v] == 0: q.append(v)
            return res if len(res) == size else []
        item_order = topo(item_graph, item_deg, n)
        group_order = topo(group_graph, group_deg, m)
        if not item_order or not group_order: return []
        group_items = defaultdict(list)
        for x in item_order: group_items[group[x]].append(x)
        return [x for g in group_order for x in group_items[g]]
