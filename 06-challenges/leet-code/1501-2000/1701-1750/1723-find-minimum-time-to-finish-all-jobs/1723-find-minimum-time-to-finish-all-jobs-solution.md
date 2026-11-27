# 1723. Find Minimum Time to Finish All Jobs — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/

---

## Solution: Bitmask DP + Backtracking — O(k · 2^n) time, O(2^n) space

**Idea:** Precompute the total time for every subset of jobs. Then use DP where `dp[mask]` is the minimum possible maximum working time when assigning exactly the jobs in `mask` distributed among the first `ceil(popcount)` workers. Equivalently, use backtracking with pruning: sort jobs descending to prune early; skip duplicate worker loads to avoid redundant branches.

**Algorithm (Backtracking with pruning):**
1. Sort `jobs` in descending order (prune longer branches first).
2. Maintain `time[k]` — current load per worker. Binary-search for minimum feasible `maxTime` or directly backtrack.
3. Backtrack: assign job `idx` to each worker; prune if `time[w] + jobs[idx] > current best`; skip if two workers have the same load (symmetric).
4. When all jobs assigned, update best answer.

**Algorithm (Bitmask DP):**
1. Precompute `subsetSum[mask]` = sum of jobs in mask.
2. `dp[mask]` = minimum maximum working time to distribute jobs in `mask` among `j` workers (j increases each round).
3. Transition: for each subset `sub` of `mask`, try assigning `sub` to the next worker: `dp[mask] = min(dp[mask], max(dp[mask ^ sub], subsetSum[sub]))`.
4. Answer is `dp[(1<<n)-1]` after `k` rounds.

**Complexity:**

| | |
|---|---|
| Time | O(k · 3^n) — iterating over subsets of subsets |
| Space | O(2^n) — DP table |
