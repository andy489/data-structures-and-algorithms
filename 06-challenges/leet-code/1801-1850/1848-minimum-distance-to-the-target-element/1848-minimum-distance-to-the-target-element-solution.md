# 1848. Minimum Distance to the Target Element — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-distance-to-the-target-element/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Scan the array once, track the minimum absolute difference between `start` and each index where `nums[i] == target`.

**Algorithm:**
1. Initialize `ans = Integer.MAX_VALUE`.
2. For each index `i`: if `nums[i] == target`, update `ans = min(ans, abs(i - start))`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra space |
