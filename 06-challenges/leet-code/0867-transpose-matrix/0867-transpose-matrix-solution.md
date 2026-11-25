# 867. Transpose Matrix — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/transpose-matrix/

---

## Solution: Direct Construction — O(m*n) time, O(m*n) space

**Idea:** Result is n×m where result[j][i] = matrix[i][j].

**Algorithm:**
1. Create result of size n×m.
2. For each (i,j), set result[j][i] = matrix[i][j].

**Complexity:**

| | |
|---|---|
| Time | O(m * n) |
| Space | O(m * n) — output |
