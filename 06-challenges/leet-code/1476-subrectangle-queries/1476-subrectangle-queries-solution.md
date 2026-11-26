# 1476. Subrectangle Queries — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/subrectangle-queries/

---

## Solution: Lazy Log (Stack of Updates) — O(1) update, O(updates) query time, O(updates) space

**Idea:** Store updates in a list. For getValue, scan updates in reverse order to find the latest update that covers (row,col).

**Algorithm:**
1. updates = []. Store original rectangle.
2. updateSubrectangle: append (r1,c1,r2,c2,val) to updates.
3. getValue: scan updates in reverse; return first covering value. Else return original.

**Complexity:**

| | |
|---|---|
| Time | O(1) update, O(updates) query |
| Space | O(updates) |
