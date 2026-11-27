# 1319. Number of Operations to Make Network Connected — Solution

## Approach
Union-Find. Count connected components. Need at least n-1 edges to connect n nodes. If edges < n-1, return -1. Otherwise return components-1.

## Complexity
- Time: O(n * alpha(n))
- Space: O(n)
