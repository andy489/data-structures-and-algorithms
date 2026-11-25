# 747. Largest Number At Least Twice of Others — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/largest-number-at-least-twice-of-others/

---

## Solution: Two-Pass Linear Scan — O(n) time, O(1) space

**Idea:** Find the max and second-max in one pass. If `max >= 2 * secondMax`, return max index.

**Algorithm:**
1. Find max value and its index.
2. Check if max >= 2 * every other element (or find second max and compare once).
3. Return index or -1.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(1) |
