# 441. Arranging Coins — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/arranging-coins/

---

## Solution: Binary Search — O(log n) time, O(1) space

**Idea:** The number of coins in `k` complete rows is `k*(k+1)/2`. Binary search for the largest `k` such that `k*(k+1)/2 <= n`.

**Algorithm:**
1. Binary search on `[1, n]`.
2. For mid, compute `coins = mid*(mid+1)/2`.
3. If `coins == n` return `mid`; if `coins < n` search right; else search left.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |

---

## Solution 2: Math (Quadratic Formula) — O(1) time, O(1) space

**Idea:** Solve `k*(k+1)/2 = n` → `k = (-1 + sqrt(1 + 8n)) / 2`, then floor.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
