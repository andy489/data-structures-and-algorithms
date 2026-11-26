# 899. Orderly Queue — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/orderly-queue/

---

## Solution: Math Insight — O(n^2) time, O(n) space

**Idea:**
- If `k == 1`: only rotations are possible. Try all n rotations and return the minimum.
- If `k >= 2`: any permutation is achievable via bubble-sort-like swaps. Return the sorted string.

**Complexity:**

| | |
|---|---|
| Time | O(n²) for k=1 (n rotations, each O(n)); O(n log n) for k≥2 |
| Space | O(n) |
