# 396. Rotate Function — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rotate-function/

---

## Solution: Math / Incremental Update — O(n) time, O(1) space

**Idea:** Observe that rotating by 1 adds the total sum and subtracts n times the last element:

`F(k) = F(k-1) + sum - n * nums[n-k]`

Proof: when rotating by 1, every element's index increases by 1 (adds `sum`), except the element that moves from index `n-1` to index `0` (loses `n * that_element`).

**Algorithm:**
1. Compute F(0) and sum.
2. For k = 1..n-1: F(k) = F(k-1) + sum - n * nums[n-k]. Track max.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
