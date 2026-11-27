# 1680. Concatenation of Consecutive Binary Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/

---

## Solution: Bit Shifting — O(n log n) time, O(1) space

**Idea:** For each number `i` from 1 to `n`, determine its bit length `len = floor(log2(i)) + 1`. Left-shift the current result by `len` bits and add `i`, all modulo `10^9 + 7`.

**Algorithm:**
1. Initialize `result = 0`.
2. For `i` from 1 to `n`:
   - Compute `len` = number of bits in `i` (can check if `i` is a power of 2 to increment a running `len`).
   - `result = ((result << len) + i) % MOD`.
3. Return `result`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — log check using running length counter |
| Space | O(1) |
