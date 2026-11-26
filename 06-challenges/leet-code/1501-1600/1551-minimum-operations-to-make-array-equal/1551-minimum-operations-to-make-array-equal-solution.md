# 1551. Minimum Operations to Make Array Equal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-operations-to-make-array-equal/

---

## Solution: Math — O(1) time, O(1) space

**Idea:** The array is `[1, 3, 5, ..., 2n-1]` which must all become `n` (the mean). The first half is below the mean and second half above. We only need to count operations for the first half — by symmetry, operations on the second half match exactly. The number of operations needed equals the sum of `(n - arr[i])` for the first half, which simplifies to `n^2 / 4`.

**Algorithm:**
1. For odd `n`: the first floor(n/2) elements need `1 + 3 + ... + (n-2)` increments = `(n/2)^2`.
2. For even `n`: the formula is also `n^2 / 4` using integer division.
3. Return `n * n / 4`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — direct formula |
| Space | O(1) — no extra space |
