# 593. Valid Square — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/valid-square/

---

## Solution: Distance Set — O(1) time, O(1) space

**Idea:** Compute all 6 pairwise squared distances between the 4 points. A valid square has exactly 2 distinct distances: 4 equal side lengths and 2 equal diagonal lengths (diagonal = √2 × side). No zero distances allowed.

**Algorithm:**
1. Compute all 6 squared distances.
2. Add to a set; the set must have exactly 2 distinct values.
3. Neither can be 0 (all points must be distinct).

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed 4 points |
| Space | O(1) |
