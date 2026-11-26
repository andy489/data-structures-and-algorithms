# 1492. The Kth Factor Of N — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/the-kth-factor-of-n/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Iterate from 1 to n, count factors. Return the k-th one.

**Algorithm:**
1. For i from 1 to n: if n % i == 0, decrement k. If k==0, return i.
2. Return -1.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
