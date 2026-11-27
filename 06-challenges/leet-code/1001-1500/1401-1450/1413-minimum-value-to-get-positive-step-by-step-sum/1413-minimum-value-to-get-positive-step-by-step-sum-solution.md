# 1413. Minimum Value To Get Positive Step By Step Sum — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/

---

## Solution: Prefix Sum Min — O(n) time, O(1) space

**Idea:** Find the minimum prefix sum. We need startValue + minPrefix >= 1, so startValue = max(1, 1 - minPrefix).

**Algorithm:**
1. Compute prefix sums, track the minimum.
2. Return max(1, 1 - minPrefixSum).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
