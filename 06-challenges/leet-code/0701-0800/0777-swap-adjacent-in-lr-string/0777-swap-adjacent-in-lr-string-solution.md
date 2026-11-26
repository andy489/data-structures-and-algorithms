# 777. Swap Adjacent in LR String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/swap-adjacent-in-lr-string/

---

## Solution: Two-Pointer Invariant — O(n) time, O(1) space

**Idea:** `L` can only move left and `R` can only move right (past X). So: (1) removing X from both strings must yield equal sequences; (2) each `L` in result must not be to the right of its corresponding `L` in start; (3) each `R` in result must not be to the left of its corresponding `R` in start.

**Algorithm:**
1. If `start` and `result` with all X removed are not equal, return false.
2. Use two pointers; skip X in both strings.
3. For each aligned pair: if char is `L` and result index > start index → false; if char is `R` and result index < start index → false.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single scan |
| Space | O(1) — no extra storage |
