# 1434. Number Of Ways To Wear Different Hats To Each Other — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/

---

## Solution: Bitmask DP — O(2^n * 40) time, O(2^n) space

**Idea:** dp[mask] = number of ways to assign hats to people in mask using hats 1..current. Iterate over hats, assign to any unassigned person.

**Algorithm:**
1. Build hat_to_people map.
2. dp[0] = 1 (no one assigned). For each hat h from 1 to 40: for each state mask (reverse): for each person p who likes h and is not in mask: dp[mask | (1<<p)] += dp[mask].
3. Return dp[(1<<n)-1].

**Complexity:**

| | |
|---|---|
| Time | O(2^n * 40) |
| Space | O(2^n) |
