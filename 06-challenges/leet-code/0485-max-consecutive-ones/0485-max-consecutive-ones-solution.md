# 485. Max Consecutive Ones — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/max-consecutive-ones/

---

## Solution: Single Pass — O(N) time, O(1) space

**Idea:** Track current run length. Reset to 0 on 0; update max on each step.

**Algorithm:**
1. Scan left to right; maintain `current` and `maxCount`.
2. If `nums[i] == 1`: increment `current`, update `maxCount`.
3. Else: reset `current = 0`.

**Complexity:**

| | |
|---|---|
| Time | O(N) |
| Space | O(1) |
