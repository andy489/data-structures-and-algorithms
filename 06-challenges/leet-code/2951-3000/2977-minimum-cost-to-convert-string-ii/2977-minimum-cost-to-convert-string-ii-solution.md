# Solution: Minimum Cost to Convert String II

## Approach: Trie + Floyd-Warshall + DP

1. Build a trie of all substring keys (original[i] and changed[i] mapped to node IDs).
2. Use Floyd-Warshall to find minimum cost between any two (original, changed) pairs that share the same length substring.
3. Use DP where dp[i] = minimum cost to convert source[0..i-1] to target[0..i-1]. For each position i, try skipping (dp[i+1] = dp[i] if source[i]==target[i]) or applying a substring transformation using the trie to enumerate applicable rules.

## Complexity

| | Time | Space |
|---|---|---|
| **Trie + Floyd-Warshall + DP** | **O(n² + K³)** | **O(K² + nK)** |

where K = number of distinct substrings in original/changed.

## Key Insight

Group original/changed strings by assigning each distinct string an ID. Floyd-Warshall on the string IDs computes minimum-cost multi-hop conversions. Then DP with trie traversal finds optimal assignments avoiding overlaps.
