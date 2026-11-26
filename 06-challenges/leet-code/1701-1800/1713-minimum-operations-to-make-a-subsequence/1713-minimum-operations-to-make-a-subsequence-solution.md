# 1713. Minimum Operations to Make a Subsequence — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-operations-to-make-a-subsequence/

---

## Solution: LCS via LIS with Binary Search — O((n + m) log n) time, O(n) space

**Idea:** The minimum insertions = `len(target) - LCS(target, arr)`. Since `target` has distinct values, we can map each element of `arr` to its index in `target`, then find the LIS (Longest Increasing Subsequence) of those indices — that equals the LCS length.

**Algorithm:**
1. Build a map from `target[i] -> i`.
2. Convert `arr` to indices: for each element in `arr` that exists in `target`, record its index.
3. Find LIS length of this index sequence using patience sorting (binary search).
4. Answer = `target.length - LIS length`.

**Complexity:**

| | |
|---|---|
| Time | O((n + m) log n) — LIS with binary search |
| Space | O(n) — index map and tails array |
