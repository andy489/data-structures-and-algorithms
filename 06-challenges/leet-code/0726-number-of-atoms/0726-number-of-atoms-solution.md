# 726. Number of Atoms — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-atoms/

---

## Solution: Stack-based Parsing — O(n log n) time, O(n) space

**Idea:** Use a stack of maps. When we see `(`, push a new map. When we see `)`, pop the top map, multiply counts by the following number, and merge into the map below. At the end, sort and format.

**Algorithm:**
1. Push an initial empty map onto the stack.
2. Scan left to right:
   - Uppercase letter: parse full element name, then count (default 1); add to top map.
   - `(`: push a new empty map.
   - `)`: pop top map, parse multiplier, multiply all counts, merge into new top.
3. Sort elements alphabetically, build output string.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting the element names |
| Space | O(n) — stack of maps |
