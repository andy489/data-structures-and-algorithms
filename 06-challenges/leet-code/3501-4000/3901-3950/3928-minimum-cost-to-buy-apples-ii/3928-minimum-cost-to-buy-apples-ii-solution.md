# 3928. Minimum Cost to Buy Apples II — Solution

## Approach: Multi-Source Dijkstra (Reverse Graph)

**Key insight:** For each starting shop `i`, the total cost of traveling to shop `j`, buying apples there, and returning is:
- `travelEmpty(i → j) + prices[j] + travelLoaded(j → i)`

The forward trip (empty) can follow any path, the return trip (loaded) multiplies each edge by its `tax`.

**Reverse thinking:** Instead of running Dijkstra from every shop, we can build a **reverse weighted graph** where edge weights are `cost * tax`. Then run Dijkstra on this reverse graph from all shops simultaneously (multi-source), where each source `j` starts with initial "load" = `prices[j]`. The shortest path in the reverse loaded graph from `j` to `i` gives `loadedReturn(j → i)`.

For the empty forward trip, run a standard Dijkstra on the unweighted (by `cost`) graph.

**Combined:** For each `j`, the minimum cost to bring apples from `j` back to `i` is:
`prices[j] + distEmpty(i, j) + distLoaded(j, i)`

Since `distEmpty(i, j) = distEmpty(j, i)` in an undirected graph with the same empty costs, we can:
1. Build two graphs: empty-weight (edge cost = `cost`) and loaded-weight (edge cost = `cost * tax`).
2. For each starting shop `i`, the answer is `min over all j of (prices[j] + distEmpty(i, j) + distLoaded(j, i))`.

This is equivalent to running multi-source Dijkstra where each source `j` has initial distance `prices[j]`, then:
- On the **loaded** graph: `distFromJ_loaded[i] = min loaded distance from j to i`.
- On the **empty** graph: `distFromI_empty[j] = min empty distance from i to j`.

The answer for `i` is: `min_j(prices[j] + distEmpty[i][j] + distLoaded[j][i])`.

Since `n, roads` are small (n ≤ 1000, roads ≤ 2000), we can run Dijkstra from each node on both graphs: O(n * (E log V)).

## Complexity

- **Time:** O(n * (E + V) log V) — Dijkstra from each node on each graph
- **Space:** O(V + E)
