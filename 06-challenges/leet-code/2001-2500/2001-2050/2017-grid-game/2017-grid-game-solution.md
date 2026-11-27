# 2017. Grid Game — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/grid-game/

---

## Solution: Prefix Sums — O(n) time, O(n) space

**Idea:** Robot 1 turns down at column `i`. Robot 2 takes either the top-right sum or bottom-left sum. Robot 1 minimizes the max of these.

**Algorithm:**
1. Compute prefix sums for both rows.
2. For each column `i` Robot 1 turns down: Robot 2 gets max(top[i+1..n-1], bottom[0..i-1]).
3. Robot 1 picks `i` to minimize that max.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
