# 552. Student Attendance Record II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/student-attendance-record-ii/

---

## Solution: DP with State (absences, trailing lates) — O(n) time, O(1) space

**Idea:** Track states `dp[a][l]` = count of valid strings of current length ending with `a` absences (0 or 1) and `l` trailing 'L's (0, 1, or 2). Transition: append 'P' (reset l to 0), 'A' (if a==0, reset l to 0, increment a), 'L' (if l<2, increment l).

**Algorithm:**
1. Initialize 6 states for length 0: `dp[0][0] = 1`, rest 0.
2. For each position 1..n, compute new state counts from previous.
3. Sum all 6 states mod 10^9+7.

**Complexity:**

| | |
|---|---|
| Time | O(n) — n iterations, constant states |
| Space | O(1) — 6 variables |
