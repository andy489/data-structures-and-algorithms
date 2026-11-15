# 168. Excel Sheet Column Title — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/excel-sheet-column-title/

---

## Solution: Iterative Base-26 Conversion — O(log n) time, O(log n) space

**Idea:** This is base-26 conversion, but 1-indexed (A=1, …, Z=26) rather than 0-indexed. The trick: before taking `columnNumber % 26`, decrement by 1 to shift to 0-indexed (0=A, …, 25=Z). This cleanly handles the `Z` boundary case — without the decrement, a remainder of 0 has no character mapping.

**Algorithm:**
1. Initialize an empty `StringBuilder` (or list).
2. While `columnNumber > 0`:
   - Decrement `columnNumber` by 1.
   - Prepend `(char)('A' + columnNumber % 26)` to the result.
   - Set `columnNumber /= 26`.
3. Return the built string.

**Complexity:**

| | |
|---|---|
| Time | O(log₂₆ n) — number of digits in base-26 representation |
| Space | O(log₂₆ n) — result string length |

---

## Solution 2: Recursive — O(log n) time, O(log n) space

**Idea:** Same 1-indexed base-26 logic expressed recursively. Reduce `columnNumber` by 1 before each recursive call to handle the 1-indexing, then append the current letter on the way back up.

**Algorithm:**
1. Base case: if `columnNumber == 0`, return `""`.
2. Return `convertToTitle(columnNumber - 1) / 26` + `(char)('A' + (columnNumber - 1) % 26)`.

**Complexity:**

| | |
|---|---|
| Time | O(log₂₆ n) — one call per digit |
| Space | O(log₂₆ n) — call stack depth |
