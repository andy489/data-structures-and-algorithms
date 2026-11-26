# 1753. Maximum Score from Removing Stones — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-score-from-removing-stones/

---

## Solution: Math — O(1) time, O(1) space

**Idea:** Sort so `a <= b <= c`. If `c >= a + b`, the largest pile dominates; we can pair each stone of `a` and `b` with a stone from `c`, giving `a + b` moves. Otherwise, the total stones is `a + b + c` which is always even in terms of pairing, so the answer is `(a + b + c) / 2`.

**Algorithm:**
1. Sort to get `a <= b <= c`.
2. If `c >= a + b`, return `a + b`.
3. Else return `(a + b + c) / 2`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
