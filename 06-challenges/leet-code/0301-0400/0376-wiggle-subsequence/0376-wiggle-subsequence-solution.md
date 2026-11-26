# 376. Wiggle Subsequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/wiggle-subsequence/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** Track whether the last direction was up or down. Count a new element only when the direction changes.

**Algorithm:**
1. Keep `up` = length of longest wiggle ending with an increase, `down` = ending with a decrease, both starting at 1.
2. For each element: if `nums[i] > nums[i-1]` then `up = down + 1`; if `nums[i] < nums[i-1]` then `down = up + 1`.
3. Return `max(up, down)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
