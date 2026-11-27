# 1562. Find Latest Group of Size M — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-latest-group-of-size-m/

---

## Solution: Reverse Simulation with Union-Find Sizes — O(n) time, O(n) space

**Idea:** Simulate placing bits one by one. Use Union-Find to track contiguous groups and their sizes. Maintain a count of groups of each size. After each placement, record the step if a group of size m exists.

**Algorithm:**
1. Initialize Union-Find with sizes, and a `groupCount` array.
2. For each step, activate the cell, set size to 1, and increment `groupCount[1]`.
3. Union with active left/right neighbors — update groupCount when merging.
4. If `groupCount[m] > 0` after the step, record the step as a valid answer.
5. Return the last recorded valid step.

**Complexity:**

| | |
|---|---|
| Time | O(n) — amortized with path compression |
| Space | O(n) — Union-Find arrays and groupCount |
