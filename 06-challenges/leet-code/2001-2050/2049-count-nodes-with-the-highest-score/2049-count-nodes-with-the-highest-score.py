# https://leetcode.com/problems/count-nodes-with-the-highest-score/

class Solution:
    def countHighestScoreNodes(self, parents: list[int]) -> int:
        from sys import setrecursionlimit
        setrecursionlimit(200000)
        n = len(parents)
        children = [[] for _ in range(n)]
        for i in range(1, n):
            children[parents[i]].append(i)
        size = [1] * n
        def dfs(u):
            for c in children[u]:
                dfs(c)
                size[u] += size[c]
        dfs(0)
        max_score, count = 0, 0
        for i in range(n):
            ch = children[i]
            left = size[ch[0]] if len(ch) > 0 else 0
            right = size[ch[1]] if len(ch) > 1 else 0
            up = n - 1 - left - right
            score = max(left, 1) * max(right, 1) * max(up, 1)
            # only multiply non-zero
            score = 1
            for s in [left, right, up]:
                if s > 0:
                    score *= s
            if score > max_score:
                max_score, count = score, 1
            elif score == max_score:
                count += 1
        return count
