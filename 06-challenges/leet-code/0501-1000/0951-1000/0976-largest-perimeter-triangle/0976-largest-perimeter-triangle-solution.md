# 976. Largest Perimeter Triangle — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/largest-perimeter-triangle/

---

## Solution: Sort + Scan — O(n log n) time, O(1) space

**Idea:** Sort descending. For each triple of consecutive elements, check if the two smaller form a valid triangle with the largest.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
