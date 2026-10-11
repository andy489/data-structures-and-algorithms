# 1325D. Ehab the Xorcist — Solution

---

## Key Insight

**Necessary conditions:**
1. XOR ≤ Sum: since XOR ignores carries but sum includes them, we need `u ≤ v`.
2. `(v - u)` must be even: because XOR and sum have the same parity difference — adding a pair `(x, x)` increases sum by `2x` and XOR by 0. So `v - u` must be divisible by 2.

If either condition fails: output `-1`.

**Case analysis:**
- `u == 0` and `v == 0`: empty array, output `0`.
- `u == v`: output array `[u]` (single element, XOR = u, sum = u).
- `u != v` (and conditions hold): we need at minimum **3 elements**.
  - We want `a XOR b = u` and `a + b = v`.
  - Set `a = (v - u) / 2` and `b = (v - u) / 2 + u`.
  - Verify: `a XOR b`: since `a = (v-u)/2` and `b = a + u` (adding u via XOR when no bit overlap... but bits may overlap).
  - Actually: `a + b = v - u + u = v` ✓. `a XOR b`: we need to check.
  - If `a XOR b == u`: output `[a, b]` (length 2).
  - Otherwise: output `[a, b XOR u, u]` — but verify this... or simply output `[(v-u)/2, (v-u)/2, u]` (length 3): XOR = 0 ⊕ 0 ⊕ u = u ✓, sum = (v-u) + u = v ✓. This always works as a 3-element fallback.

**Optimal minimum length:**
- 0 if `u = v = 0`
- 1 if `u = v ≠ 0`
- 2 if `u ≠ v` and we can find `a, b > 0` with `a XOR b = u`, `a + b = v`
- 3 otherwise (always possible if conditions are met)

**When can we achieve length 2?**  
Set `a = (v - u) / 2`, `b = (v + u) / 2`. Check `a XOR b == u` and both are positive.

---

## Complexity

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
