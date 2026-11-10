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

### Why is it so fast? — Proof that it is O(log log x)

#### Step 1 — Name the error

Let `e_n` be how far off our guess is at step `n`:

```
e_n  =  r_n  -  sqrt(x)
```

So `e_0 = x - sqrt(x)` (we start at `r = x`), and we stop when `e_n < 1` (error less than 1 means we have the right integer floor).

#### Step 2 — Derive how the error evolves

Substitute `r_n = sqrt(x) + e_n` into the Newton recurrence `r_{n+1} = (r_n + x/r_n) / 2`:

```
e_{n+1}  =  r_{n+1} - sqrt(x)
          =  (r_n + x/r_n) / 2  -  sqrt(x)
          =  (r_n² + x - 2·r_n·sqrt(x))  /  (2·r_n)
          =  (r_n - sqrt(x))²  /  (2·r_n)
          =  e_n²  /  (2·r_n)
```

Since `r_n >= sqrt(x)` (proved in Part 1):

```
e_{n+1}  <=  e_n²  /  (2·sqrt(x))
```

The error at the next step is at most the **square** of the current error, divided by a constant. This is called **quadratic convergence**.

#### Step 3 — Unroll the recurrence

Let `C = 2·sqrt(x)`. Then:

```
e_1  <=  e_0²  /  C
e_2  <=  e_1²  /  C  <=  (e_0²/C)²  /  C  =  e_0⁴  /  C³
e_3  <=  e_0⁸  /  C⁷
e_k  <=  e_0^(2^k)  /  C^(2^k - 1)
```

The exponent on `e_0` is `2^k` — it **doubles every step**.

#### Step 4 — Find when we stop

We need `e_k < 1`. Ignoring the denominator (it only helps), we need:

```
e_0^(2^k)  <  1
```

Taking logarithm of both sides:

```
2^k · log(e_0)  <  0
```

That is automatically satisfied once `e_0 < 1`, but we want the general case where `e_0` can be as large as `x`. We need:

```
2^k  >=  log(e_0)  /  log(C/e_0)
```

The key point is that `e_0 < x` and `C ~ sqrt(x)`, so `log(e_0) ~ log(x)`. Therefore:

```
2^k  ~  log(x)
k    ~  log(log(x))
```

#### Step 5 — The intuition in one line

Binary search **halves** the search space each step → needs `log(x)` steps.
Newton **squares away** the error each step → only needs `log(log(x))` steps, because you just need to double the exponent until it reaches `log(x)`, and doubling takes logarithm time again.

#### Sanity check

For `x = 2^31`:

```
log₂(x)       =  31        ← binary search steps
log₂(log₂(x)) =  log₂(31) ≈ 5  ← Newton steps
```

Matches the observed ~5 iterations in the worked examples.

| Method | Iterations (32-bit) | Convergence |
|---|---|---|
| Binary search | ~16 | linear — error halves each step |
| Newton's method | ~5 | quadratic — error squares each step |

---

### The role of epsilon (ε)

Epsilon is the **stopping threshold** — the maximum error you are willing to accept.

In the **integer versions** (Solutions 1 and 2) ε is implicit: we work in whole numbers, so the finest granularity is 1 and we stop as soon as we hit the floor. In the **floating-point versions** (Solutions 3 and 4) ε is explicit: you declare how close is "close enough".

| Desired precision | ε | extra iterations vs. integer |
|---|---|---|
| Whole number (Solutions 1 & 2) | implicit `1` | 0 |
| 1 decimal place | `1e-1` | — |
| 5 decimal places | `1e-5` | — |
| 10 decimal places | `1e-10` | — |

How many extra iterations does a smaller ε cost?
- **Binary search** halves the interval each step, so going from ε = 1 to ε = 1e-5 costs `log₂(1/1e-5) ≈ 17` more steps (linear).
- **Newton's method** squares the precision each step, so the same shrink costs only `log₂(17) ≈ 4` more steps (logarithmic in the number of binary-search steps).

That is the concrete payoff of quadratic convergence.

### Validation for Solutions 3 and 4

Two things must be validated at the boundary of these functions:

**1. `x >= 0`**

Square root of a negative number is undefined in real arithmetic. Pass a negative `x` and the loop would run forever (or produce NaN on the first `sqrt` attempt).

**2. `eps >= machine epsilon`**

`double` / `float64` has 52 mantissa bits, giving a machine epsilon of `2^-52 ≈ 2.22e-16` (in Java: `Math.ulp(1.0)`, in Python: `sys.float_info.epsilon`, in JS: `Number.EPSILON`).

If you ask for `eps = 1e-20`:
- The stopping condition `|r*r - x| > eps` may never become false, because adjacent representable doubles are further apart than `1e-20` for typical values of `r*r`.
- Result: **infinite loop**.

Minimum safe epsilon by language:

| Language | Value | Constant |
|---|---|---|
| Java | `~2.22e-16` | `Math.ulp(1.0)` |
| Python | `~2.22e-16` | `sys.float_info.epsilon` |
| JavaScript | `~2.22e-16` | `Number.EPSILON` |

Both checks are at system boundaries (caller-supplied inputs), which is exactly where validation belongs.

---

## Solution 3: Binary Search with explicit ε — O(log(x/ε)) time, O(1) space

Same idea as Solution 1 but on floating-point: narrow the interval `[lo, hi]` until its width drops below ε.

**Key difference from Solution 1:** instead of tracking integer indices we track real bounds and stop when `hi - lo < ε`.

**Note:** `hi` starts at `max(1, x)` rather than `x/2` to handle `0 < x < 1` correctly (sqrt(0.25) = 0.5 > 0.25).

**Algorithm:**
1. If `x == 0`, return `0`.
2. Set `lo = 0`, `hi = max(1, x)`.
3. While `hi - lo > ε`:
   - `mid = lo + (hi - lo) / 2`
   - If `mid * mid <= x`: `lo = mid`
   - Else: `hi = mid`
4. Return `lo`.

**Complexity:**

| | |
|---|---|
| Time  | O(log(x/ε)) — interval halves each step; needs log₂(x/ε) steps to reach width ε |
| Space | O(1) |

### Worked Example — `x = 8.0, ε = 0.1`

Start: `lo = 0`, `hi = 8`

| Iteration | lo | hi | hi-lo | mid | mid² | action |
|-----------|----|----|-------|-----|------|--------|
| 1 | 0 | 8 | 8.0 | 4.0 | 16 | 16 > 8 → hi = 4 |
| 2 | 0 | 4 | 4.0 | 2.0 | 4 | 4 ≤ 8 → lo = 2 |
| 3 | 2 | 4 | 2.0 | 3.0 | 9 | 9 > 8 → hi = 3 |
| 4 | 2 | 3 | 1.0 | 2.5 | 6.25 | 6.25 ≤ 8 → lo = 2.5 |
| 5 | 2.5 | 3 | 0.5 | 2.75 | 7.5625 | 7.5625 ≤ 8 → lo = 2.75 |
| 6 | 2.75 | 3 | 0.25 | 2.875 | 8.265 | 8.265 > 8 → hi = 2.875 |
| 7 | 2.75 | 2.875 | 0.125 | 2.8125 | 7.91 | 7.91 ≤ 8 → lo = 2.8125 |
| 8 | 2.8125 | 2.875 | 0.0625 | ... | ... | ... |
| ... | ... | ... | < 0.1 | — | — | **exit** |

Return `lo ≈ 2.82...`. ✓

---

## Solution 4: Newton's Method with explicit ε — O(log log(x/ε)) time, O(1) space

Same recurrence as Solution 2, but floating-point with an explicit stopping condition.

**Algorithm:**
1. If `x == 0`, return `0`.
2. Start with `r = x`.
3. While `|r*r - x| > ε`: `r = (r + x / r) / 2.0`.
4. Return `r`.

**Complexity:**

| | |
|---|---|
| Time  | O(log log(x/ε)) — quadratic convergence; each step doubles the number of correct digits |
| Space | O(1) |

### Worked Example — `x = 8.0, ε = 1e-5`

Start: `r = 8.0`

| Iteration | r | \|r²−8\| | action |
|-----------|---|----------|--------|
| 1 | 8.0 | 56.0 | > 1e-5 → r = (8 + 8/8)/2 = **4.5** |
| 2 | 4.5 | 12.25 | > 1e-5 → r = (4.5 + 8/4.5)/2 = **3.139** |
| 3 | 3.139 | 1.853 | > 1e-5 → r = **2.8432** |
| 4 | 2.8432 | 0.0832 | > 1e-5 → r = **2.82843** |
| 5 | 2.82843 | ~0.000012 | > 1e-5 → r = **2.828427** |
| 6 | 2.828427 | ~0 | ≤ 1e-5 → **exit** |

Return `2.828427`. ✓ (true value: `2.8284271...`)

---

### Side-by-side comparison

| Solution | Method | ε | Stops when | Time |
|---|---|---|---|---|
| 1 | Binary search | implicit 1 | `lo > hi` (integers) | O(log x) |
| 2 | Newton | implicit 1 | `r*r <= x` (integers) | O(log log x) |
| 3 | Binary search | explicit | `hi - lo <= ε` | O(log(x/ε)) |
| 4 | Newton | explicit | `\|r*r - x\| <= ε` | O(log log(x/ε)) |

Solutions 3 and 4 generalise their integer counterparts. The Newton variant (4) is dramatically faster for tight ε because halving the interval costs one step but halving the *error exponent* also costs one step — and Newton is already at a tiny error before binary search is halfway done.
