# 1437. Check If All 1s Are At Least Length K Places Away — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Track the last position of a 1. When a new 1 is found, check distance from last 1.

**Algorithm:**
1. Track prev = -1 (position of last 1).
2. When nums[i] == 1: if prev != -1 and i - prev <= k, return false. Update prev = i.
3. Return true.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
