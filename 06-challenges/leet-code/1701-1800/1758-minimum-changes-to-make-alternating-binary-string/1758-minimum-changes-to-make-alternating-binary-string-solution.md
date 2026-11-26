# 1758. Minimum Changes to Make Alternating Binary String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

---

## Solution: Count Mismatches — O(n) time, O(1) space

**Idea:** There are only two valid alternating strings: starting with `'0'` ("010101...") and starting with `'1'` ("101010..."). Count how many positions differ from the first pattern — call it `cost0`. The cost for the second pattern is `n - cost0` (positions that match the first must differ from the second). Return the minimum.

**Algorithm:**
1. Count positions where `s[i] != (i % 2 == 0 ? '0' : '1')` → `cost0`.
2. Return `min(cost0, n - cost0)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
