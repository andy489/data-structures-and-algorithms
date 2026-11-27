# 3854. Minimum Operations to Make Array Parity Alternating — Solution

**Link:** https://leetcode.com/problems/minimum-operations-to-make-array-parity-alternating/

## Approach: Greedy — Try Both Target Patterns

There are two valid parity patterns for an alternating array:
- Pattern A: even, odd, even, odd, ...
- Pattern B: odd, even, odd, even, ...

For each pattern, count the number of positions where the current parity doesn't match. This count is the minimum number of operations (`+1` or `-1` changes parity with 1 op).

The minimum operations is the smaller of the two counts.

For the range (max - min) part: after fixing which elements need to change parity, each changed element `v` becomes either `v+1` or `v-1` (we pick the one that minimizes the range). We compute the minimum possible range over all elements after optimal adjustments.

## Complexity

- **Time:** O(n)
- **Space:** O(1)
