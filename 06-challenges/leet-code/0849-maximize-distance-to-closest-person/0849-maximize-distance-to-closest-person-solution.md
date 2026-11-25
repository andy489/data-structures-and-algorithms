# 849. Maximize Distance to Closest Person — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-distance-to-closest-person/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Track the last occupied seat. For empty gaps, the best position is the midpoint. Handle edge cases: leading and trailing zeros separately.

**Algorithm:**
1. Track `last` = index of last person seen (start at -1).
2. When a person is found at index `i`:
   - If `last == -1`, the gap to the left is `i` (edge case).
   - Otherwise, mid-gap distance is `(i - last) / 2`.
3. After the loop, the trailing zero gap is `n - 1 - last`.
4. Return max of all computed distances.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
