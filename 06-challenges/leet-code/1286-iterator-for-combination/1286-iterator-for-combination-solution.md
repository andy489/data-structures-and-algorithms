# 1286. Iterator for Combination — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/iterator-for-combination/

---

## Solution: Precompute All Combinations — O(2^n * n) init, O(1) query time, O(C(n,k)) space

**Idea:** Precompute all combinations using bitmask enumeration, sort them, store in a list, and iterate.

**Algorithm:**
1. Use bitmask to enumerate all subsets of given size.
2. Sort and store all combinations.
3. next()/hasNext() iterate through the list.

**Complexity:**

| | |
|---|---|
| Time | O(2^n * n) init, O(1) query |
| Space | O(C(n,k)) |
