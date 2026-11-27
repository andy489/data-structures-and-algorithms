# 789. Escape the Ghosts — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/escape-the-ghosts/

---

## Solution: Manhattan Distance — O(g) time, O(1) space

**Idea:** You escape if and only if your Manhattan distance to the target is strictly less than every ghost's Manhattan distance to the target. Any ghost that reaches the target before or at the same time as you will intercept you.

**Algorithm:**
1. Compute your distance: `|target[0]| + |target[1]|`.
2. For each ghost, compute its distance to target.
3. If any ghost distance ≤ your distance, return false.

**Complexity:**

| | |
|---|---|
| Time | O(g) — one pass over ghosts |
| Space | O(1) |
