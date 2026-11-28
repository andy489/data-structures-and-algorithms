# 3484. Design Spreadsheet — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-spreadsheet/

---

## Solution: HashMap — O(1) per operation time, O(n) space

**Idea:** Store cell values in a HashMap keyed by cell reference string. For `getValue`, parse the formula by splitting on `+`, then evaluate each operand as either an integer literal or a cell reference lookup.

**Algorithm:**
1. Constructor: store `rows`, initialize an empty `HashMap<String, Integer>`.
2. `setCell(cell, value)`: put cell -> value in map.
3. `resetCell(cell)`: remove cell from map.
4. `getValue(formula)`: strip leading `=`, split on `+`, resolve each part (digit check vs cell lookup), return sum.

**Complexity:**

| | |
|---|---|
| Time | O(1) per operation |
| Space | O(n) for stored cells |
