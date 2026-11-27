# 829. Consecutive Numbers Sum — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/consecutive-numbers-sum/

---

## Solution: Math — O(√n) time, O(1) space

**Idea:** A sequence of k consecutive integers starting at m sums to k*m + k*(k-1)/2 = n, so m = (n - k*(k-1)/2) / k must be a positive integer. Try all valid k.

**Algorithm:**
1. For k from 1 upward while k*(k-1)/2 < n:
2. If (n - k*(k-1)/2) % k == 0 and the starting number > 0, count it.

**Complexity:**

| | |
|---|---|
| Time | O(√n) — k grows until k*(k-1)/2 ≥ n |
| Space | O(1) — constant space |
