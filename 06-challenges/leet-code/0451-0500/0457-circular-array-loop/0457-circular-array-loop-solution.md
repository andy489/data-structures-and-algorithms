# 457. Circular Array Loop — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/circular-array-loop/

---

## Solution: Fast/Slow Pointers — O(n) time, O(1) space

**Idea:** For each starting index, use slow/fast pointers to detect a cycle. A valid cycle requires: length > 1, all same direction. Mark visited nodes with 0 to avoid re-processing.

**Algorithm:**
1. For each index `i` where `nums[i] != 0`:
   - Run slow/fast pointer. `next(i)` = `(i + nums[i] % n + n) % n`.
   - If slow meets fast: check cycle length > 1.
   - Regardless, mark visited path with 0.
2. Return `false` if no valid cycle found.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each element processed at most twice |
| Space | O(1) — in-place marking |
