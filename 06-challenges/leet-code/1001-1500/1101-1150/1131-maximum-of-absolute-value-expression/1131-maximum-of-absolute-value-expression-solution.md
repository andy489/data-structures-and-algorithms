# 1131. Maximum of Absolute Value Expression — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-of-absolute-value-expression/

---

## Solution: Absolute Value Decomposition — O(n) time, O(1) space

**Idea:** Each absolute value expands into two cases based on sign. With three absolute values, we get 2^3 = 8 sign combinations, but they collapse to 4 distinct expressions due to symmetry. For sign vector `(s1, s2, s3)` where each is ±1:

```
s1*(arr1[i]-arr1[j]) + s2*(arr2[i]-arr2[j]) + s3*(i-j)
= (s1*arr1[i] + s2*arr2[i] + s3*i) - (s1*arr1[j] + s2*arr2[j] + s3*j)
```

The maximum over all pairs `(i, j)` is `max(val[i]) - min(val[j])` where `val[k] = s1*arr1[k] + s2*arr2[k] + s3*k`.

The 4 unique sign combinations (up to global negation) are `(+,+,+)`, `(+,+,-)`, `(+,-,+)`, `(+,-,-)`.

**Algorithm:**
1. For each of the 4 sign vectors `(s1, s2)` with `s3 = ±1`:
   - Compute `f(k) = s1*arr1[k] + s2*arr2[k] + k` and `g(k) = s1*arr1[k] + s2*arr2[k] - k`.
   - Track max and min of f and g in one pass.
   - Candidate answer: `max(f) - min(f)` and `max(g) - min(g)`.
2. Return the global maximum candidate.

**Complexity:**

| | |
|---|---|
| Time | O(n) — 4 passes of O(n) |
| Space | O(1) |
