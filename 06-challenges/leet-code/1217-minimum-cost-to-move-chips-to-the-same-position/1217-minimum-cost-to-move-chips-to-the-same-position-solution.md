# 1217. Minimum Cost to Move Chips to the Same Position — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

---

## Solution: Parity Count — O(n) time, O(1) space

**Idea:** Moving 2 steps is free. So all chips at even positions can be moved to any even position for free, and odd to odd. The only cost is moving all chips to either the even group or the odd group.

**Algorithm:**
1. Count chips at odd positions and even positions.
2. Return min(odd_count, even_count).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
