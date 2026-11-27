# 823. Binary Trees With Factors — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-trees-with-factors/

---

## Solution: Dynamic Programming on Sorted Array — O(n²) time, O(n) space

**Idea:** Sort arr. dp[x] = number of trees rooted at x. For each pair (a, b) where a*b == x and both a,b are in arr, add dp[a]*dp[b] to dp[x].

**Algorithm:**
1. Sort arr, build a set for O(1) lookups.
2. dp[i] = 1 (just the leaf). For each i, check all j < i where arr[j] divides arr[i] and arr[i]/arr[j] is in the set.
3. Sum all dp values mod 1e9+7.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — for each element, check all smaller ones |
| Space | O(n) — dp map |
