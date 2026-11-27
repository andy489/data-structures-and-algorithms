# Solution: Maximum Score of Non-overlapping Intervals

## Approach

We need to choose up to 4 non-overlapping intervals with maximum total weight, returning the lexicographically smallest index array.

**DP approach**: dp[k][i] = best total weight using exactly k intervals from the first i intervals (sorted by right endpoint), with last interval ending at i.

Sort intervals by right endpoint (breaking ties by left endpoint, then index for lex order). Use binary search to find, for each interval i, the last interval j such that intervals[j].right < intervals[i].left (strict non-overlap since sharing boundary counts as overlap).

dp[k][i] = max(dp[k][i-1], dp[k-1][j] + weight[i]) where j = last non-overlapping.

Track parent pointers to reconstruct the index list.

Since we need the lexicographically smallest list, among solutions with the same weight we prefer smaller indices. Sort carefully and handle tie-breaking.

## Complexity

| | Complexity |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
