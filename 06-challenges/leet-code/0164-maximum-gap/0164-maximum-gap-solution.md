# 164. Maximum Gap — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-gap/

---

## Solution: Bucket Sort (Pigeonhole) — O(n) time, O(n) space

**Idea:** If we have `n` elements spread over range `[min, max]`, by the pigeonhole principle the maximum gap is at least `(max-min)/(n-1)`. Create `n-1` buckets each of width `w = ceil((max-min)/(n-1))`. Each bucket only needs to track its local min and max. The maximum gap is never within a bucket — it must be between buckets (a non-empty bucket's min and the previous non-empty bucket's max).

**Algorithm:**
1. Find global `min` and `max`. Edge cases: `n < 2` → 0; `min == max` → 0.
2. Bucket width `w = max(1, ceil((max-min)/(n-1)))`.
3. For each number `x`, bucket index `i = (x - min) / w`. Update bucket's local min/max.
4. Sweep buckets: for each consecutive pair of non-empty buckets, compute `curMin - prevMax`. Track maximum.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — buckets |
