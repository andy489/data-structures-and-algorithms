# 172. Factorial Trailing Zeroes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/factorial-trailing-zeroes/

---

## Solution: Count Factors of 5 — O(log n) time, O(1) space

**Idea:** Trailing zeroes come from factors of 10 = 2 × 5. There are always more factors of 2 than 5 in `n!`, so we only count factors of 5. Each multiple of 5 contributes one, each multiple of 25 contributes an extra one (since 25 = 5²), etc.

Formula: `⌊n/5⌋ + ⌊n/25⌋ + ⌊n/125⌋ + ...`

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
