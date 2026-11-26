# 1491. Average Salary Excluding The Minimum And Maximum Salary — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

---

## Solution: Min/Max/Sum — O(n) time, O(1) space

**Idea:** Sum all, subtract min and max, divide by (n-2).

**Algorithm:**
1. Compute total sum, min, max. Return (total - min - max) / (n - 2).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
