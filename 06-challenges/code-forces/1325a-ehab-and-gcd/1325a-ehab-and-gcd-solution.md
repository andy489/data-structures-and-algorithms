# 1325A. EhAb AnD gCd — Solution

---

## Key Insight

The simplest valid pair is always `a = 1, b = x - 1`:

```
GCD(1, x-1) = 1
LCM(1, x-1) = x - 1
GCD + LCM = 1 + (x-1) = x ✓
```

This works for any *x* ≥ 2 since `x - 1 ≥ 1`.

---

## Algorithm

For each test case, output `1` and `x - 1`.

**Why this is always valid:**
- GCD(1, n) = 1 for all n ≥ 1 (1 divides everything).
- LCM(1, n) = n (since 1 × n / GCD(1, n) = n).
- 1 + (x − 1) = x ✓.

---

## Complexity

| | |
|---|---|
| Time | O(t) — constant per test case |
| Space | O(1) |
