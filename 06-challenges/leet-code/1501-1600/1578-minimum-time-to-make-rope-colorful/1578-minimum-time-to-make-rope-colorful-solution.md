# 1578. Minimum Time to Make Rope Colorful — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

---

## Solution: Greedy Group Sum — O(n) time, O(1) space

**Idea:** Consecutive balloons of the same color form a "group". To make the rope colorful, we keep exactly one balloon per group (the most expensive one, to minimize cost). The minimum cost for each group is therefore the total group time minus the maximum time in the group.

**Algorithm:**
1. Walk the string grouping consecutive same-colored balloons.
2. For each group, compute the total time and the maximum single removal time.
3. Add `total - max` to the result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only loop variables |
