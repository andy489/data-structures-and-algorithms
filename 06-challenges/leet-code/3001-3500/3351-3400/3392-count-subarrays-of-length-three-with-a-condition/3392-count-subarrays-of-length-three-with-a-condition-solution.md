# 3392. Count Subarrays of Length Three With a Condition — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Slide a window of size 3 across the array. For each triplet `(a, b, c)`, check whether `2 * (a + c) == b` (using integer arithmetic to avoid floating-point issues).

**Algorithm:**
1. Iterate `i` from `0` to `n - 3`.
2. For each `i`, let `a = nums[i]`, `b = nums[i+1]`, `c = nums[i+2]`.
3. If `2 * (a + c) == b`, increment the counter.
4. Return the counter.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
