# 1526. Minimum Number of Increments on Subarrays to Form a Target Array — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/

---

## Solution: Greedy Upward Steps — O(n) time, O(1) space

**Idea:** Each "upward step" in the target array requires a new operation. When target[i] > target[i-1], we need (target[i] - target[i-1]) additional operations to cover this rise. Descents are free because we can simply stop extending the previous operation at that point.

**Algorithm:**
1. Start with `ops = target[0]` (the first element's height requires that many operations).
2. For each subsequent element, if it's higher than the previous, add the difference.
3. Return the total.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — no extra storage |
