# 668. Kth Smallest Number in Multiplication Table — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

---

## Solution: Binary Search — O(m·log(m·n)) time, O(1) space

**Idea:** Binary search on the answer. For a given value `x`, count how many elements in the table are ≤ x. Row `i` contributes `min(x/i, n)` elements.

**Algorithm:**
1. Binary search `lo=1, hi=m*n`.
2. `count(x)` = sum over rows `i=1..m` of `min(x/i, n)`.
3. Find smallest `x` where `count(x) >= k`.

**Complexity:**

| | |
|---|---|
| Time | O(m·log(m·n)) |
| Space | O(1) |
