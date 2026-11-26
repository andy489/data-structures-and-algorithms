# 923. 3Sum With Multiplicity — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/3sum-with-multiplicity/

---

## Solution: Count + Combinatorics — O(101²) time, O(101) space

**Idea:** Count frequency of each value (0–100). Iterate all pairs (i, j) where i ≤ j, check if k = target - i - j exists and k ≥ j, then count combinations based on whether i=j=k, i=j<k, i<j=k, or all distinct.

**Complexity:**

| | |
|---|---|
| Time | O(101²) ≈ O(1) effectively |
| Space | O(101) |
