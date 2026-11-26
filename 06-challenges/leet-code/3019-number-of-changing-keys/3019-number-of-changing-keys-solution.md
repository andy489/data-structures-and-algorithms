# 3019. Number Of Changing Keys — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-changing-keys/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Compare consecutive characters case-insensitively, count transitions.

**Algorithm:**
1. Iterate i from 1 to n-1.
2. If toLowerCase(s[i]) != toLowerCase(s[i-1]), increment count.
3. Return count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) — one pass |
| Space | O(1) — O(1) |
