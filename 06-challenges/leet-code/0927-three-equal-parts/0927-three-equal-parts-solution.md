# 927. Three Equal Parts — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/three-equal-parts/

---

## Solution: Find Positions of Ones — O(n) time, O(n) space

**Idea:** Count total ones. If not divisible by 3, return [-1,-1]. Find start of each third group. Verify all three parts match character by character.

**Algorithm:**
1. Collect positions of all ones.
2. If 0 ones, return [0, 2]. If total % 3 != 0, return [-1,-1].
3. The three groups start at positions[0], positions[total/3], positions[2*total/3].
4. Scan simultaneously to check equality; trailing zeros from part 3 determine boundaries.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
