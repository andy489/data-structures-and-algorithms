# 69. Sqrt(x) — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sqrtx/

---

## Solution: Binary Search — O(log x) time, O(1) space

**Idea:** The integer square root of `x` is the largest integer `m` such that `m * m <= x`. Since this is a monotone predicate on `[0, x]`, binary search finds it directly.

**Algorithm:**
1. Handle the base case: if `x < 2`, return `x` (sqrt(0) = 0, sqrt(1) = 1).
2. Set `lo = 1`, `hi = x / 2` (the answer is always at most `x / 2` for `x >= 2`).
3. While `lo <= hi`:
   - Compute `mid = lo + (hi - lo) / 2`.
   - If `mid * mid == x`, return `mid` exactly.
   - If `mid * mid < x`, the answer is at least `mid`; record it and move `lo = mid + 1`.
   - Otherwise `mid * mid > x`; move `hi = mid - 1`.
4. Return `hi` — the last valid `mid` whose square did not exceed `x`.

**Why `hi = x / 2`?** For any `x >= 2`, `sqrt(x) <= x / 2`. (When `x = 2`, `sqrt(2) ≈ 1.41 <= 1 = 2/2` in integer division.) This halves the initial search space.

**Overflow guard:** Use `long` for the product `mid * mid` to avoid 32-bit overflow when `x` is near `2^31 - 1`.

**Complexity:**

| | |
|---|---|
| Time  | O(log x) — binary search over [1, x/2] |
| Space | O(1) — no extra memory |

---

## Worked Example — `x = 8`

Search range: `lo = 1`, `hi = 4`

| Iteration | lo | hi | mid | mid² | action          |
|-----------|----|----|-----|------|-----------------|
| 1         | 1  | 4  | 2   | 4    | 4 < 8 → lo = 3  |
| 2         | 3  | 4  | 3   | 9    | 9 > 8 → hi = 2  |

Loop ends (`lo > hi`). Return `hi = 2`. ✓

---

## Worked Example — `x = 9`

Search range: `lo = 1`, `hi = 4`

| Iteration | lo | hi | mid | mid² | action          |
|-----------|----|----|-----|------|-----------------|
| 1         | 1  | 4  | 2   | 4    | 4 < 9 → lo = 3  |
| 2         | 3  | 4  | 3   | 9    | 9 == 9 → return 3 |

**Answer: 3** ✓
