# 1424. Diagonal Traverse Ii — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/diagonal-traverse-ii/

---

## Solution: HashMap by Diagonal — O(n) time, O(n) space

**Idea:** Elements on the same diagonal share the same (i+j) value. Group by diagonal sum, then output in reverse row order.

**Algorithm:**
1. For each element nums[i][j]: add to group[i+j], prepend it (so rows are in reverse order per diagonal).
2. Output groups in order of key 0,1,2,...

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
