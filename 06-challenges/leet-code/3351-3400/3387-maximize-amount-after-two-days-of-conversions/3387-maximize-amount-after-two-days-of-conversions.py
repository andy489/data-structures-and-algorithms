# https://leetcode.com/problems/maximize-amount-after-two-days-of-conversions/

from collections import defaultdict, deque

class Solution:
    def maxAmount(self, initialCurrency: str,
                  pairs1: list[list[str]], rates1: list[float],
                  pairs2: list[list[str]], rates2: list[float]) -> float:

        def build_graph(pairs, rates):
            graph = defaultdict(list)
            for (a, b), r in zip(pairs, rates):
                graph[a].append((b, r))
                graph[b].append((a, 1.0 / r))
            return graph

        def bfs(init_amounts, graph):
            amounts = dict(init_amounts)
            queue = deque(init_amounts.keys())
            while queue:
                cur = queue.popleft()
                cur_amt = amounts[cur]
                for nb, rate in graph[cur]:
                    new_amt = cur_amt * rate
                    if nb not in amounts or new_amt > amounts[nb]:
                        amounts[nb] = new_amt
                        queue.append(nb)
            return amounts

        g1 = build_graph(pairs1, rates1)
        g2 = build_graph(pairs2, rates2)

        day1 = bfs({initialCurrency: 1.0}, g1)
        day2 = bfs(day1, g2)

        return day2.get(initialCurrency, 1.0)
