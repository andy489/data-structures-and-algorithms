# 2032. Two Out of Three — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/two-out-of-three/

---

## Solution: Set Union — O(n1 + n2 + n3) time, O(n) space

**Idea:** For each value, count in how many arrays it appears (using sets). Return values with count >= 2.

**Algorithm:**
1. Convert each array to a set.
2. For each unique value across all, count how many sets contain it.
3. Collect those with count >= 2.

**Complexity:**

| | |
|---|---|
| Time | O(n1 + n2 + n3) |
| Space | O(n) |
