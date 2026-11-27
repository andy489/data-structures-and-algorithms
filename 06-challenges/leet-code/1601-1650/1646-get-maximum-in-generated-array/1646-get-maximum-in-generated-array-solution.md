# 1646. Get Maximum in Generated Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/get-maximum-in-generated-array/

---

## Solution: Simulation — O(n) time, O(n) space

**Idea:** Directly simulate the recurrence and track the maximum.

**Algorithm:**
1. Handle edge case `n == 0` (return 0).
2. Build `nums[0..n]` per the recurrence.
3. Return the maximum element.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
