# 931. Minimum Falling Path Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-falling-path-sum/

---

## Solution: DP In-Place — O(n²) time, O(1) space

**Idea:** Each cell's minimum path sum = cell value + min of the three cells above it. Work row by row, updating in-place.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(1) |
