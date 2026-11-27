# https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
from collections import deque

class Solution:
    def findAllRecipes(self, recipes: list[str], ingredients: list[list[str]], supplies: list[str]) -> list[str]:
        recipe_set = set(recipes)
        recipe_idx = {r: i for i, r in enumerate(recipes)}
        available = set(supplies)
        n = len(recipes)
        in_degree = [0] * n
        graph = {}

        for i, ings in enumerate(ingredients):
            for ing in ings:
                if ing not in available:
                    if ing in recipe_set:
                        graph.setdefault(ing, []).append(i)
                        in_degree[i] += 1
                    else:
                        in_degree[i] = float('inf')
                        break

        queue = deque(i for i in range(n) if in_degree[i] == 0)
        result = []
        while queue:
            idx = queue.popleft()
            result.append(recipes[idx])
            for nxt in graph.get(recipes[idx], []):
                in_degree[nxt] -= 1
                if in_degree[nxt] == 0:
                    queue.append(nxt)
        return result
