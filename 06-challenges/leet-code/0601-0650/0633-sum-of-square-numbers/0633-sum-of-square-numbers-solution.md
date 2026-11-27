# 633. Sum of Square Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-square-numbers/

---

## Solution: Two Pointers — O(√c) time, O(1) space

**Idea:** Set a=0, b=√c. If a²+b²==c, found. If less, increment a. If more, decrement b.

**Complexity:**

| | |
|---|---|
| Time | O(√c) — two pointers from 0 and √c |
| Space | O(1) |
