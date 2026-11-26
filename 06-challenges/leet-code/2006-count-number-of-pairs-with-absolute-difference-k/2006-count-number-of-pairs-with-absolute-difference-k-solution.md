# 2006. Count Number of Pairs With Absolute Difference K — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/

---

## Solution: Brute Force — O(n^2) time, O(1) space

**Idea:** With n ≤ 200 brute force is sufficient. For each pair check if the absolute difference equals k.

**Algorithm:**
1. Iterate all pairs `(i, j)` with `i < j`.
2. Count pairs where `|nums[i] - nums[j]| == k`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(1) |
