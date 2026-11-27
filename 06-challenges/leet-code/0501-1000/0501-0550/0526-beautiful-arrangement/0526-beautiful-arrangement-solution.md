# 526. Beautiful Arrangement — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/beautiful-arrangement/

---

## Solution: Backtracking — O(k) time, O(n) space

**Idea:** Use backtracking: at each position `pos` (from 1 to n), try placing each unused number. If `num % pos == 0 || pos % num == 0`, place it and recurse. Count valid complete arrangements.

**Algorithm:**
1. Use a boolean `visited` array to track used numbers.
2. Recurse from position 1 to n.
3. At each position, try each unvisited number 1..n that satisfies the divisibility condition.
4. Count completions when position reaches n+1.

**Complexity:**

| | |
|---|---|
| Time | O(k) — k is number of valid arrangements (much less than n!) |
| Space | O(n) — recursion depth + visited array |

---

## Solution 2: Bitmask DP — O(n · 2^n) time, O(2^n) space

**Idea:** `dp[mask]` = number of beautiful arrangements using exactly the bits set in `mask`. The position being filled is `popcount(mask)`.

**Complexity:**

| | |
|---|---|
| Time | O(n · 2^n) |
| Space | O(2^n) |
