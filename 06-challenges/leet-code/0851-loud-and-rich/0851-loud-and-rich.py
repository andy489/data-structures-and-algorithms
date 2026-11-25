# https://leetcode.com/problems/loud-and-rich/

class Solution:
    def loudAndRich(self, richer: list[list[int]], quiet: list[int]) -> list[int]:
        n = len(quiet)
        richer_than = [[] for _ in range(n)]
        for a, b in richer:
            richer_than[b].append(a)
        answer = [-1] * n

        def dfs(x):
            if answer[x] != -1:
                return answer[x]
            answer[x] = x
            for r in richer_than[x]:
                candidate = dfs(r)
                if quiet[candidate] < quiet[answer[x]]:
                    answer[x] = candidate
            return answer[x]

        for i in range(n):
            dfs(i)
        return answer
