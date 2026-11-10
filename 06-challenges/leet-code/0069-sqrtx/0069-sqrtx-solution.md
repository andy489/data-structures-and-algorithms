# 69. Sqrt(x) — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sqrtx/

---

## Solution 1: Binary Search — O(log x) time, O(1) space

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

### Worked Example — `x = 8`

Search range: `lo = 1`, `hi = 4`

| Iteration | lo | hi | mid | mid² | action          |
|-----------|----|----|-----|------|-----------------|
| 1         | 1  | 4  | 2   | 4    | 4 < 8 → lo = 3  |
| 2         | 3  | 4  | 3   | 9    | 9 > 8 → hi = 2  |

Loop ends (`lo > hi`). Return `hi = 2`. ✓

---

### Worked Example — `x = 9`

Search range: `lo = 1`, `hi = 4`

| Iteration | lo | hi | mid | mid² | action          |
|-----------|----|----|-----|------|-----------------|
| 1         | 1  | 4  | 2   | 4    | 4 < 9 → lo = 3  |
| 2         | 3  | 4  | 3   | 9    | 9 == 9 → return 3 |

**Answer: 3** ✓

---

## Solution 2: Newton's Method — O(log log x) iterations, O(1) space

### Historical context

Newton's method (also called the **Newton–Raphson method**) was developed by Isaac Newton around 1669 and independently by Joseph Raphson in 1690. For computing square roots specifically, the underlying recurrence `r ← (r + x/r) / 2` is actually far older — it appears in **Babylonian clay tablets from ~2000 BCE** and is sometimes called the **Babylonian method** or **Heron's method** (after the Greek mathematician Heron of Alexandria, ~60 CE, who described it explicitly). It is arguably the oldest known numerical algorithm.

Newton rediscovered it as a special case of his general root-finding framework: to solve `f(r) = 0`, iterate `r ← r - f(r) / f'(r)`. For `f(r) = r² - x`, this yields exactly the Babylonian recurrence.

### Derivation

We want `sqrt(x)`, i.e. the root of `f(r) = r² - x = 0`. Newton's update rule:

```
r_next = r - f(r) / f'(r)
       = r - (r² - x) / (2r)
       = (2r² - r² + x) / (2r)
       = (r + x/r) / 2
```

This is the arithmetic mean of `r` and `x/r`. By the AM-GM inequality these two terms straddle `sqrt(x)` (their geometric mean), so the update always overshoots toward `sqrt(x)` — never below it.

### Proof of correctness

**1. Sequence never goes below sqrt(x) (AM-GM)**

For any `r > 0`, by AM-GM:

```
(r + x/r) / 2  >=  sqrt(r · x/r)  =  sqrt(x)
```

So `r_next >= sqrt(x)` always. The sequence approaches from above, meaning `r*r > x` is the correct loop guard.

**2. Sequence is strictly decreasing while r² > x**

```
r_next < r
⟺  (r + x/r) / 2 < r
⟺  x/r < r
⟺  x < r²
```

Which is exactly the loop condition. So each iteration strictly reduces `r`.

**3. Loop terminates at floor(sqrt(x))**

The sequence is monotonically decreasing and bounded below by `sqrt(x)`, so it converges. For integer arithmetic, once `r² <= x` the loop exits. At that point:

```
r²  <=  x  <  (r+1)²
```

The left side is the exit condition. The right side follows because the previous (larger) iterate satisfied `r_prev >= r + 1` and `r_prev >= sqrt(x)`, so `r = floor(sqrt(x))` exactly.

### Convergence: quadratic

Let `e_n = r_n - sqrt(x)` be the error at step `n`. Substituting `r_n = sqrt(x) + e_n`:

```
e_{n+1} = r_{n+1} - sqrt(x)
        = (r_n + x/r_n)/2 - sqrt(x)
        = e_n² / (2 · r_n)
```

Since `r_n >= sqrt(x)`:

```
e_{n+1}  <=  e_n² / (2 · sqrt(x))
```

The error **squares each iteration**. Starting from `r = x`, convergence to the integer answer takes at most ~5 iterations for any 32-bit input — compared to ~16 iterations for binary search.

| Method | Iterations | Convergence |
|---|---|---|
| Binary search | O(log x) ≈ 16 for 32-bit | linear |
| Newton's method | O(log log x) ≈ 5 for 32-bit | quadratic |

**Algorithm:**
1. If `x == 0`, return `0`.
2. Start with `r = x` (safe initial guess above `sqrt(x)` for `x >= 1`).
3. While `r * r > x`: `r = (r + x / r) / 2`.
4. Return `r`.

**Overflow guard:** Use `long` — `r * r` can overflow `int` when `x` is near `2^31 - 1`.

**Complexity:**

| | |
|---|---|
| Time  | O(log log x) — quadratic convergence |
| Space | O(1) |

---

### Worked Example — `x = 8`

Start: `r = 8`

| Iteration | r  | r²  | action        |
|-----------|----|-----|---------------|
| 1         | 8  | 64  | 64 > 8 → r = (8 + 8/8)/2 = (8+1)/2 = 4 |
| 2         | 4  | 16  | 16 > 8 → r = (4 + 8/4)/2 = (4+2)/2 = 3 |
| 3         | 3  | 9   | 9 > 8  → r = (3 + 8/3)/2 = (3+2)/2 = 2 (integer division) |
| 4         | 2  | 4   | 4 <= 8 → exit |

Return `2`. ✓

---

### Worked Example — `x = 2147395600` (near `2^31 - 1`, answer = 46340)

Newton's method converges in 5 iterations; binary search would take ~16. The `long` cast prevents `r * r` from overflowing.
