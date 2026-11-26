# 1418. Display Table Of Food Orders In A Restaurant — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/

---

## Solution: HashMap + TreeMap — O(n log n) time, O(n) space

**Idea:** Track food items (sorted) and table counts using maps, then build the result table.

**Algorithm:**
1. Collect all food names (sorted), all table numbers (sorted).
2. Count orders per table per food.
3. Build result rows: header + data rows with counts (default 0).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
