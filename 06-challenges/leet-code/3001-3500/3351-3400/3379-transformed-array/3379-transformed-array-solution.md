# 3379. Transformed Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/transformed-array/

---

## Solution: Direct Simulation — O(n) time, O(n) space

**Idea:** Each position is independent. For each index `i`, the target index is `(i + nums[i]) % n` using Python-style modulo (handles negatives). If `nums[i] == 0` the result is 0 (not a lookup).

**Algorithm:**
1. For each `i`, if `nums[i] == 0` set `result[i] = 0`.
2. Otherwise compute `j = ((i + nums[i]) % n + n) % n` to handle both positive and negative steps with wrap-around.
3. Set `result[i] = nums[j]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — output array |
