# https://leetcode.com/problems/maximum-score-of-a-node-sequence/

class Solution:
    def maximumScore(self, scores: list[int], edges: list[list[int]]) -> int:
        n = len(scores)
        top3 = [[] for _ in range(n)]

        def add_top3(lst, node, score):
            lst.append((score, node))
            lst.sort(reverse=True)
            if len(lst) > 3:
                lst.pop()

        for u, v in edges:
            add_top3(top3[u], v, scores[v])
            add_top3(top3[v], u, scores[u])

        ans = -1
        for u, v in edges:
            for sa, a in top3[u]:
                for sb, b in top3[v]:
                    if a != v and b != u and a != b:
                        total = scores[u] + scores[v] + sa + sb
                        if total > ans:
                            ans = total
        return ans
