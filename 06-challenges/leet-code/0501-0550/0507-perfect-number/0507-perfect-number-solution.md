# 507. Perfect Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/perfect-number/

---

## Solution: Trial Division up to √n — O(√n) time, O(1) space

**Idea:** Iterate from 2 to √num. For each divisor i, add both i and num/i (if different). Add 1 always (1 divides everything). Compare sum to num.

**Algorithm:**
1. If num <= 1, return false.
2. Start sum = 1. Loop i from 2 to √num.
3. If i divides num: sum += i; if i != num/i: sum += num/i.
4. Return sum == num.

**Complexity:**

| | |
|---|---|
| Time | O(√n) |
| Space | O(1) |
