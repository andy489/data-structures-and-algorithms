# 494. Target Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/target-sum/

---

## Solution: DP (0/1 Knapsack) — O(n · sum) time, O(sum) space

**Idea:** Let P = sum of positive numbers, N = sum of negative. We need P - N = target and P + N = total, so P = (target + total) / 2. Count subsets that sum to P.

**Algorithm:**
1. If (target + total) is odd or |target| > total, return 0.
2. Let goal = (target + total) / 2.
3. dp[j] = number of ways to reach sum j; dp[0] = 1.
4. For each num, update dp backward: dp[j] += dp[j - num].

**Complexity:**

| | |
|---|---|
| Time | O(n · sum) — n items, sum up to 1000 |
| Space | O(sum) — 1D DP array |

---

## Solution 2: DFS with Memoization — O(n · sum) time, O(n · sum) space

**Idea:** Recursive DFS where at each index we either add or subtract nums[i]. Memoize by (index, currentSum).

**Complexity:**

| | |
|---|---|
| Time | O(n · sum) — at most n * 2*sum states |
| Space | O(n · sum) — memo map |
