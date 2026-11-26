# 338. Counting Bits — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/counting-bits/

---

## Solution: DP — O(n) time, O(n) space

**Idea:** `ans[i] = ans[i >> 1] + (i & 1)`. Shifting right removes the last bit (so the popcount differs by at most 1 based on the last bit).

**Algorithm:**
1. `ans[0] = 0`.
2. For `i` from 1 to `n`: `ans[i] = ans[i >> 1] + (i & 1)`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — output array |
