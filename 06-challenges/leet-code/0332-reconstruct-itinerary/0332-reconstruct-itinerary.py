# https://leetcode.com/problems/reconstruct-itinerary/

class Solution:
    def findItinerary(self, tickets: list[list[str]]) -> list[str]:
        graph = {}
        for frm, to in sorted(tickets, reverse=True):
            graph.setdefault(frm, []).append(to)
        result = []

        def dfs(airport):
            while graph.get(airport):
                dfs(graph[airport].pop())
            result.append(airport)

        dfs('JFK')
        return result[::-1]
