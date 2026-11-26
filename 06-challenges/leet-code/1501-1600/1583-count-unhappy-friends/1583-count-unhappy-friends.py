# https://leetcode.com/problems/count-unhappy-friends/

class Solution:
    def unhappyFriends(self, n: int, preferences: list[list[int]], pairs: list[list[int]]) -> int:
        rank = [[0] * n for _ in range(n)]
        for i in range(n):
            for j, p in enumerate(preferences[i]):
                rank[i][p] = j
        paired = {}
        for x, y in pairs:
            paired[x] = y
            paired[y] = x
        count = 0
        for x in range(n):
            y = paired[x]
            for u in range(n):
                if u == x or u == y:
                    continue
                v = paired[u]
                if rank[x][u] < rank[x][y] and rank[u][x] < rank[u][v]:
                    count += 1
                    break
        return count
