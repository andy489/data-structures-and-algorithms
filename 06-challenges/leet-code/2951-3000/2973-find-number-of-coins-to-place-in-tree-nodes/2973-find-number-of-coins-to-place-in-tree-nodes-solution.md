# Solution: Find Number of Coins to Place in Tree Nodes

## Approach: DFS + Top-K Elements Per Subtree

For each node, perform DFS to gather the top-3 largest and bottom-2 smallest cost values in the subtree. The maximum product of 3 values is either:
1. The 3 largest positive values
2. The 2 smallest (most negative) values × the largest positive value

We propagate from leaves to root, merging the top-3 largest and bottom-2 smallest for each subtree efficiently.

## Complexity

| | Time | Space |
|---|---|---|
| **DFS + Bounded Merge** | **O(n)** | **O(n)** |

## Key Insight

We only need the top 3 and bottom 2 values from each subtree. The maximum product of 3 elements can come from (max1, max2, max3) or (min1, min2, max1). Keep at most 5 candidates per subtree during DFS.
