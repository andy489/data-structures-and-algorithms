# 1837. Sum of Digits in Base K — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sum-of-digits-in-base-k/

---

## Solution: Repeated Division — O(log_k n) time, O(1) space

**Idea:** Repeatedly divide `n` by `k`, accumulating remainders (which are the base-k digits), until `n` becomes 0.

**Algorithm:**
1. Initialize `sum = 0`.
2. While `n > 0`: add `n % k` to `sum`, set `n = n / k`.
3. Return `sum`.

**Complexity:**

| | |
|---|---|
| Time | O(log_k n) — number of digits in base k |
| Space | O(1) — constant extra space |
