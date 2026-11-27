# 2952. Minimum Number of Coins to Be Added — Solution

## Approach: Greedy — Extend Reachable Range

Sort the coins. Maintain `reach` = the maximum value currently reachable using a subset of coins we have processed. Initially `reach = 0` meaning we can form 0.

Iterate through sorted coins:
- If `coin > reach + 1`, we cannot form `reach + 1`, so we must add a coin of value `reach + 1`. This doubles our reach: `reach += (reach + 1)`.
- Repeat until `coin <= reach + 1`, then extend: `reach += coin`.
- After processing all coins, if `reach < target`, keep adding coins of value `reach + 1` until `reach >= target`.

The key insight: if we can form all values in [1, reach], and the next coin has value c <= reach+1, then we can form all values in [1, reach+c].

## Complexity

| | Time | Space |
|---|---|---|
| Sort + Greedy scan | O(n log n) | O(1) |
