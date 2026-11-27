# 2139. Minimum Moves to Reach Target Score — Solution

**Link:** https://leetcode.com/problems/minimum-moves-to-reach-target-score/

## Approach: Greedy — Work Backwards

Work backwards from `target` to `1`:
- If `target` is odd, increment (in reverse: subtract 1 from target, add 1 move).
- If `target` is even and we have doubles remaining, double (in reverse: halve target, add 1 move, decrement doubles remaining).
- Once `maxDoubles == 0`, the remaining moves are simply `target - 1` increments.

This greedy works because whenever we can halve, it's always better to do so (saves more moves than incrementing).

## Complexity

| | Time | Space |
|---|---|---|
| **Greedy Reverse** | O(log target + maxDoubles) | O(1) |
