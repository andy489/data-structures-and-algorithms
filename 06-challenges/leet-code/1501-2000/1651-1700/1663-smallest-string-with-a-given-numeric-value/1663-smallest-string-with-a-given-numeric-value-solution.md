# 1663. Smallest String With A Given Numeric Value — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

---

## Solution: Greedy (Fill from Right) — O(n) time, O(n) space

**Idea:** To get the lexicographically smallest string, fill characters from right to left. At each position from the right, assign the largest possible character that leaves enough budget for the remaining positions (each remaining position needs at least value 1 = 'a').

**Algorithm:**
1. Start with `k` remaining budget and position from `n-1` down to `0`.
2. At position `i`, the remaining positions after this one is `i`, so minimum needed is `i * 1`.
3. Assign `min(26, k - i)` as the value (character), decrement `k` accordingly.
4. Build the string left to right as 'a' + (computed value - 1).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — result array |
