# 2140. Solving Questions With Brainpower — Solution

**Link:** https://leetcode.com/problems/solving-questions-with-brainpower/

## Approach: Dynamic Programming (Bottom-Up from End)

Define `dp[i]` = maximum points achievable from question `i` onwards.

Recurrence:
- Skip question `i`: `dp[i] = dp[i+1]`
- Solve question `i`: `dp[i] = points[i] + dp[min(n, i + brainpower[i] + 1)]`
- Take the max of both.

Process from right to left so when we compute `dp[i]`, future values are already known.

## Complexity

| | Time | Space |
|---|---|---|
| **DP Bottom-Up** | O(n) | O(n) |

Where `n` is the number of questions.
