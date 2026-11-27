# 1267. Count Servers that Communicate — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-servers-that-communicate/

---

## Solution: Row/Column Count — O(m*n) time, O(m+n) space

**Idea:** Count servers per row and per column. A server can communicate if its row count > 1 OR its column count > 1.

**Algorithm:**
1. Count servers per row and per column.
2. For each server: if row[i] > 1 or col[j] > 1, count it.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) |
| Space | O(m+n) |
