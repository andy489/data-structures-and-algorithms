# 2115. Find All Possible Recipes from Given Supplies — Solution

**Link:** https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/

## Approach: Topological Sort (BFS / Kahn's Algorithm)

Model each recipe as a node with directed edges from each ingredient to the recipe that needs it. Use Kahn's algorithm:

1. Build a map from recipe name to its index.
2. For each recipe, count in-degree = number of ingredients that are themselves recipes (ingredients from `supplies` are always available, so they don't contribute to in-degree).
3. Start BFS with all recipes whose in-degree is 0.
4. When a recipe is processed, add it to the result and decrement in-degrees of recipes that depend on it.
5. Collect all recipes that reach in-degree 0.

## Complexity

| | Time | Space |
|---|---|---|
| **Topological Sort** | O(n * m) | O(n * m) |

Where `n` is the number of recipes and `m` is the average number of ingredients per recipe.
