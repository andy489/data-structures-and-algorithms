# 1438. Longest Continuous Subarray With Absolute Diff Less Than Or Equal To Limit — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

---

## Solution: Monotonic Deques Sliding Window — O(n) time, O(n) space

**Idea:** Use two deques: one tracking max (decreasing), one tracking min (increasing). Shrink window when max - min > limit.

**Algorithm:**
1. maxDq (decreasing) tracks window maximum. minDq (increasing) tracks window minimum.
2. Expand right: update deques.
3. While maxDq.front - minDq.front > limit: advance left, remove stale fronts.
4. Track max window length.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
