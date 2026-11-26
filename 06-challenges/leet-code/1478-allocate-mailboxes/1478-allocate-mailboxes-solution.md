# 1478. Allocate Mailboxes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/allocate-mailboxes/

---

## Solution: DP + Optimal Mailbox Placement — O(n^3) time, O(n^2) space

**Idea:** Sort houses. cost(i,j) = placing one mailbox for houses[i..j] = sum of |x - median|. dp[i][j] = min cost for first j houses with i mailboxes.

**Algorithm:**
1. Precompute cost[i][j] for all subranges (median minimizes absolute deviations).
2. dp[i][j] = min over j' < j of dp[i-1][j'] + cost[j'+1][j].
3. Return dp[k][n].

**Complexity:**

| | |
|---|---|
| Time | O(n^3) |
| Space | O(n^2) |
