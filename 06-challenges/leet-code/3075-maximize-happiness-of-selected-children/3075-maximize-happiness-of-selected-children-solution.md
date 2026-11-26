# 3075. Maximize Happiness Of Selected Children — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-happiness-of-selected-children/

---

## Solution: Greedy + Sort — O(n log n) time, O(1) space

**Idea:** Sort descending. The ith selected child (0-indexed) contributes max(0, happiness[i] - i) since i children were picked before it.

**Algorithm:**
1. Sort happiness descending.
2. For i in 0..k-1: add max(0, happiness[i] - i) to result.
3. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — O(n log n) — sort |
| Space | O(1) — O(1) extra |
