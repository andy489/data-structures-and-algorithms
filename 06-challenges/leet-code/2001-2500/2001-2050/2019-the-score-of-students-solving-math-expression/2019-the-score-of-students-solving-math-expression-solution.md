# 2019. The Score of Students Solving Math Expression — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/the-score-of-students-solving-math-expression/

---

## Solution: Interval DP — O(n^3 * S^2) time, O(n^2 * S) space

**Idea:** Use interval DP to compute all possible values for each subexpression. Each dp[i][j] is a set of values.

**Algorithm:**
1. Parse expression into numbers and operators.
2. dp[i][i] = {nums[i]}.
3. For each interval, combine with operator.
4. Cap values at 1000 to bound sets.
5. Award points per student answer.

**Complexity:**

| | |
|---|---|
| Time | O(n^3 * S^2) |
| Space | O(n^2 * S) |
