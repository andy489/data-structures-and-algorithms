# 3038. Maximum Number of Operations With the Same Score I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** The target score is fixed as nums[0]+nums[1]. Count pairs from the front with the same sum.

**Algorithm:**
1. target = nums[0] + nums[1], count = 0.
2. i = 0. While i+1 < n and nums[i]+nums[i+1] == target: count++, i+=2.
3. Return count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
