# 985. Sum of Even Numbers After Queries — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-even-numbers-after-queries/

---

## Solution: Running Even Sum — O(n+q) time, O(n+q) space

**Idea:** Maintain running sum of evens. For each query, adjust the sum based on what changes.

**Complexity:**

| | |
|---|---|
| Time | O(n+q) |
| Space | O(n+q) — answer array |
