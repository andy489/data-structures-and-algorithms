# 1409. Queries On A Permutation With Key — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/queries-on-a-permutation-with-key/

---

## Solution: Simulation — O(m * q) time, O(m) space

**Idea:** Maintain a list representing the permutation. For each query, find the index (1-based), record it, remove and prepend.

**Algorithm:**
1. Initialize list = [1,...,m].
2. For each q: find 1-based index, record, remove, prepend to front.
3. Return recorded positions.

**Complexity:**

| | |
|---|---|
| Time | O(m * q) |
| Space | O(m) |
