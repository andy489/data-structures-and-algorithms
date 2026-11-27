# Solution: 3429. Paint House IV

**Link:** https://leetcode.com/problems/paint-house-iv/

## Approach

DP where the state is (color of house i, color of house n-1-i) for the two mirrored positions.

Since houses i and n-1-i must have different colors, and must each differ from their adjacent houses, we iterate from outside in.

State: dp[c1][c2] = min cost to paint houses 0..i and n-1-i..n-1 symmetrically, where house i has color c1 and house n-1-i has color c2 (c1 != c2).

Transition from i to i+1:
- House i+1 must differ from c1.
- House n-2-i must differ from c2.
- House i+1 and n-2-i must differ from each other (new equidistant pair constraint).

Initialize: dp[c1][c2] = cost[0][c1] + cost[n-1][c2] for c1 != c2.

## Complexity

- Time: O(n * 9) = O(n)
- Space: O(9) = O(1)
