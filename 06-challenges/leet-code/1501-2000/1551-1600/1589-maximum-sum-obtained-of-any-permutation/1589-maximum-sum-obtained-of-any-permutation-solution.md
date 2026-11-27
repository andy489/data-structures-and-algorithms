# 1589. Maximum Sum Obtained of Any Permutation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/

---

## Solution: Difference Array + Sort — O(n log n) time, O(n) space

**Idea:** Compute how many times each index is covered by requests using a difference array. The most-requested indices should get the largest values. Sort both arrays and pair them greedily.

**Algorithm:**
1. Build difference array `freq`: for each `[l, r]`, do `freq[l]++`, `freq[r+1]--`.
2. Prefix sum to get request count per index.
3. Sort `nums` ascending and `freq` ascending.
4. Multiply corresponding elements and sum modulo `10^9 + 7`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting dominates |
| Space | O(n) — frequency array |
