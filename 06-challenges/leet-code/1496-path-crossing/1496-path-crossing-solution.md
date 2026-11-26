# 1496. Path Crossing — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/path-crossing/

---

## Solution: HashSet Tracking — O(n) time, O(n) space

**Idea:** Track visited positions. If we revisit any position, return true.

**Algorithm:**
1. Start at (0,0). Track visited positions in a set.
2. Move according to each direction. If new position is in visited, return true.
3. Add new position to visited. Return false.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
