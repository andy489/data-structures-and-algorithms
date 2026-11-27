# 1223. Dice Roll Simulation — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/dice-roll-simulation/

---

## Solution: Dynamic Programming — O(n*6*15) time, O(n*6*15) space

**Idea:** dp[i][j][k] = ways to reach roll i with last face j repeated k times. Transition: for each face, check if consecutive count exceeds rollMax.

**Algorithm:**
1. State: dp[i][j][k] = number of sequences of length i ending with face j+1 repeated k times.
2. Init dp[1][j][1] = 1.
3. Transition and sum.

**Complexity:**

| | |
|---|---|
| Time | O(n*6*15) |
| Space | O(n*6*15) |
