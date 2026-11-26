# 2080. Range Frequency Queries — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/range-frequency-queries/

---

## Solution: Binary Search on Precomputed Indices — O(n) build, O(log n) query time, O(n) space

**Idea:** Store sorted list of indices for each value. For each query, binary search to count occurrences in range.

**Algorithm:**
1. Build map: value → sorted list of indices.
2. For query(left, right, value): binary search to count indices in [left, right].

**Complexity:**

| | |
|---|---|
| Time | O(n) build, O(log n) query |
| Space | O(n) |
