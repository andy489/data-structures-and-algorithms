# Solution: Remove Methods From Project

## Approach: BFS/DFS to Find Suspicious Set + Validation

1. **Find all suspicious methods:** BFS/DFS from `k` using the directed invocation graph to find all methods reachable from `k`.

2. **Check if removal is valid:** For each edge `a -> b` in invocations, if `b` is suspicious but `a` is NOT suspicious, then we cannot remove the suspicious set (non-suspicious method invokes a suspicious method).

3. If removal is valid, return all non-suspicious methods. Otherwise return all methods `[0..n-1]`.

## Complexity

- **Time:** O(n + m) where m = invocations.length.
- **Space:** O(n + m) for adjacency list and visited set.
