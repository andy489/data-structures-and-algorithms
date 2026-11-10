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

### Where does it come from?

About 4000 years ago, Babylonian mathematicians noticed something simple:

> If `r` is too large a guess for `√x`, then `x/r` is too small. The true answer is **somewhere in between**.

So take the average:

```
r_next = (r + x/r) / 2
```

Repeat until `r` stops changing. That's it. This recurrence appears in **Babylonian clay tablets from ~2000 BCE** and is sometimes called the **Babylonian method** or **Heron's method** (after the Greek mathematician Heron of Alexandria, ~60 CE). It is arguably the oldest known numerical algorithm.

Isaac Newton rediscovered it ~1669 as a special case of his general root-finding framework: to solve `f(r) = 0`, iterate `r ← r - f(r) / f'(r)`. For `f(r) = r² - x` this gives exactly the same recurrence:

```
r_next = r - f(r) / f'(r)
       = r - (r² - x) / (2r)
       = (r + x/r) / 2
```

---

### Proof of correctness

#### Part 1 — The sequence never goes below sqrt(x)

We need to show: `(r + x/r) / 2 >= sqrt(x)` for any `r > 0`.

This is just the **AM-GM inequality** — the arithmetic mean of two positive numbers is always at least their geometric mean:

```
(a + b) / 2  >=  sqrt(a · b)
```

Set `a = r` and `b = x/r`:

```
(r + x/r) / 2  >=  sqrt(r · x/r)  =  sqrt(x)
```

So `r_next >= sqrt(x)` always. The sequence approaches from above and **never undershoots**. This is why `r * r > x` is the right loop guard — once `r² <= x`, we have arrived.

---

#### Part 2 — The sequence strictly decreases while the loop runs

We want to show: if `r² > x`, then `r_next < r`.

```
r_next < r
⟺  (r + x/r) / 2 < r
⟺  x/r < r
⟺  x < r²
```

Which is exactly the loop condition. So every iteration shrinks `r`.

---

#### Part 3 — The loop stops at exactly floor(sqrt(x))

From Parts 1 and 2 the sequence is:
- monotonically **decreasing**
- bounded **below** by `sqrt(x)`

So it must converge. For integer arithmetic, once `r² <= x` the loop exits. At that point:

```
r²  <=  x  <  (r+1)²
```

That is the definition of `floor(sqrt(x))`. ✓

---

### Why is it so fast?

Let `e_n = r_n - sqrt(x)` be the error. Substituting `r_n = sqrt(x) + e_n` into the recurrence:

```
e_{n+1}  =  e_n²  /  (2 · r_n)
         <=  e_n²  /  (2 · sqrt(x))
```

The error **squares every iteration**. If the error is 100, next step it's ~10, then ~0.1, then ~0.0001. The number of correct digits doubles each step. For any 32-bit input this takes at most **5–6 iterations** from any starting point, versus ~16 for binary search.

| Method | Iterations (32-bit) | Convergence |
|---|---|---|
| Binary search | ~16 | linear (halves error each step) |
| Newton's method | ~5 | quadratic (squares error each step) |

---

### Algorithm

1. If `x == 0`, return `0`.
2. Start with `r = x` (always above `sqrt(x)` for `x >= 1`).
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

| Iteration | r | r² | action |
|-----------|---|----|--------|
| 1 | 8 | 64 | 64 > 8 → r = (8 + 8/8)/2 = (8+1)/2 = **4** |
| 2 | 4 | 16 | 16 > 8 → r = (4 + 8/4)/2 = (4+2)/2 = **3** |
| 3 | 3 | 9  | 9 > 8  → r = (3 + 8/3)/2 = (3+2)/2 = **2** (integer division) |
| 4 | 2 | 4  | 4 <= 8 → **exit** |

Return `2`. ✓

---

### Worked Example — `x = 2147395600` (near `2^31 - 1`, answer = 46340)

Newton's method converges in 5 iterations; binary search would take ~16. The `long` cast prevents `r * r` from overflowing.
