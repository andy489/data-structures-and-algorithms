# 470. Implement Rand10() Using Rand7() — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/implement-rand10-using-rand7/

---

## Solution: Rejection Sampling — O(1) expected time, O(1) space

**Idea:** Generate a uniform value in [1, 49] by combining two rand7() calls: `(rand7()-1)*7 + rand7()`. Values 1–40 map uniformly to [1,10] (4 values per outcome). Values 41–49 are rejected. Expected iterations ≈ 1.225.

**Algorithm:**
1. Loop: `row = rand7()-1`, `col = rand7()-1`, `idx = row*7 + col`.
2. If `idx < 40`, return `idx % 10 + 1`.
3. Otherwise, retry.

**Complexity:**

| | |
|---|---|
| Time | O(1) expected — rejection probability is 9/49 ≈ 0.184 |
| Space | O(1) |
