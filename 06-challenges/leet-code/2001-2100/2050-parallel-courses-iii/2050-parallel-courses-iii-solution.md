# 2050. Parallel Courses III — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/parallel-courses-iii/

---

## Solution: Topological Sort / DAG DP — O(V + E) time, O(V + E) space

**Idea:** DAG DP: dp[i] = time to finish course i = time[i] + max(dp[prereqs]). Process in topological order.

**Algorithm:**
1. Build DAG.
2. Topological sort (Kahn's algorithm).
3. dp[i] = time[i] + max(dp[prereq] for prereq in prerequisites[i]).
4. Return max(dp).

**Complexity:**

| | |
|---|---|
| Time | O(V + E) |
| Space | O(V + E) |
