# 3858. Minimum Bitwise OR From Grid — Solution

**Link:** https://leetcode.com/problems/minimum-bitwise-or-from-grid/

## Approach: Greedy Bit-by-Bit or DP on Set of Reachable OR Values

**Key insight:** Since values are ≤ 10^5 < 2^17, there are only 17 bits. We can maintain a set of all reachable OR values after processing each row.

For each row, for each currently reachable OR value `v`, try OR-ing with each element in the row and add the result to the new reachable set.

The answer is the minimum value in the final reachable set.

**Why this is efficient:** The set of reachable values can only grow as bits get set. With 17-bit values, the set has at most 2^17 ≈ 131072 elements (practically much smaller since OR is monotone). But with the given constraints (m*n ≤ 10^5), processing is bounded.

Actually, since OR only sets bits and never clears them, the set of reachable values after processing each row is closed upward (superset of all previous values ORed with new elements). The set size is bounded by the number of distinct OR subsets of a 17-bit number.

## Complexity

- **Time:** O(m * |states| * n) but |states| ≤ 2^17 and m*n ≤ 10^5, so practical
- **Space:** O(2^17) for the states set
