# 937. Reorder Data in Log Files — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reorder-data-in-log-files/

---

## Solution: Custom Sort — O(n log n) time, O(n) space

**Idea:** Separate letter and digit logs. Sort letter logs by (content, identifier). Concatenate letter + digit.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
