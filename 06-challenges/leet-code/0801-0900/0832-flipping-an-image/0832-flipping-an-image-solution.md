# 832. Flipping an Image — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/flipping-an-image/

---

## Solution: In-Place Two Pointers — O(n²) time, O(1) space

**Idea:** For each row, use two pointers from both ends. Swap and XOR with 1 simultaneously. If pointers meet at middle (odd n), just invert the middle element.

**Algorithm:**
1. For each row, use left/right pointers.
2. If row[l] != row[r]: swap does nothing to values after flip+invert (they cancel); skip.
3. If row[l] == row[r]: both become 1-row[l] after flip+invert; set both.
4. Handle middle element: invert it.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — visit every cell once |
| Space | O(1) — in-place |
