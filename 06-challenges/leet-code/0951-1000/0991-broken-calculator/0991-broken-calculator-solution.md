# 991. Broken Calculator — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/broken-calculator/

---

## Solution: Work Backwards — O(log target) time, O(1) space

**Idea:** Work backwards from target. If target > start: if odd, add 1 (reverse subtract); if even, divide by 2 (reverse multiply). If target <= start, just subtract.

**Complexity:**

| | |
|---|---|
| Time | O(log target) |
| Space | O(1) |
