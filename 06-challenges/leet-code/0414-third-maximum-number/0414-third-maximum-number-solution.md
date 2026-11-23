# 414. Third Maximum Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/third-maximum-number/

---

## Solution: Three-Pointer Tracking — O(n) time, O(1) space

**Idea:** Maintain three variables for the top-3 distinct maximums. Use `Long.MIN_VALUE` as sentinel so that actual `Integer.MIN_VALUE` values in the input are handled correctly. Track whether a third maximum was actually found.

**Algorithm:**
1. Initialize `first = second = third = Long.MIN_VALUE`.
2. For each `num`: skip if equal to any of the three; update the three variables in order.
3. If `third` was updated from sentinel, return it; otherwise return `first`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — three variables |
