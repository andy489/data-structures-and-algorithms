# 962. Maximum Width Ramp — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-width-ramp/

---

## Solution: Monotonic Stack + Right Scan — O(n) time, O(n) space

**Idea:** Build decreasing stack of potential left endpoints, then scan from right to find max width.

**Algorithm:**
1. Build strictly decreasing stack from left.
2. Scan from right; for each j, pop from stack while nums[stack.top] <= nums[j], updating max width.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — stack |
