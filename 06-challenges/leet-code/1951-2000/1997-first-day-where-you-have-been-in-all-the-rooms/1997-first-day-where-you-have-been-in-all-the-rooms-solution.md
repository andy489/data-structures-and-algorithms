# Solution: First Day Where You Have Been in All the Rooms

## Approach: Dynamic Programming

Let `dp[i]` = the day number when we first visit room `i` for the second time (i.e., the first even visit, after which we move to room `i+1`).

Key insight: to visit room `i` for the first time (odd), we come from room `i-1` on day `dp[i-1]`. Then we go back to `nextVisit[i-1]` and need to return to room `i-1` again (second visit), which happens on day `dp[i-1] + 1 + (dp[i-1] - dp[nextVisit[i-1]])`.

Recurrence:
```
dp[i] = dp[i-1] + 1 + (dp[i-1] - dp[nextVisit[i-1]]) + 1
       = 2*dp[i-1] - dp[nextVisit[i-1]] + 2
```

The first day all rooms are visited is `dp[n-2] + 1`.

**Time:** O(n)  
**Space:** O(n)
