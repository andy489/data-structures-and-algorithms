# 674. Longest Continuous Increasing Subsequence — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/longest-continuous-increasing-subsequence/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Scan with a running count of current increasing run length. Reset when non-increasing.

**Algorithm:**
1. Track `curr` length and `best` maximum.
2. For each i > 0: if nums[i] > nums[i-1], increment curr; else reset curr to 1.
3. Update best.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
