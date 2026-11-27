# 1672. Richest Customer Wealth — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/richest-customer-wealth/

---

## Solution: Row Sum Maximum — O(m * n) time, O(1) space

**Idea:** Sum each row (customer's total wealth across banks) and return the maximum sum.

**Algorithm:**
1. For each customer (row), compute the sum of their account values.
2. Track and return the maximum sum.

**Complexity:**

| | |
|---|---|
| Time | O(m * n) |
| Space | O(1) |
