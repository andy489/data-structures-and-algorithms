# 3095. Shortest Subarray With OR at Least K I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/

---

## Solution: Brute Force — O(n²) time, O(1) space

**Idea:** Try all subarrays, check if OR >= k, track minimum length. With n<=50, O(n²) is fine.

**Algorithm:**
1. For each i, expand right computing OR until OR>=k or end.
2. Track min length.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — all subarrays |
| Space | O(1) |
