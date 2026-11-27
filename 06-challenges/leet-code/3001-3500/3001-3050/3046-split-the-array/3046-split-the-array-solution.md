# 3046. Split The Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/split-the-array/

---

## Solution: Frequency Check — O(n) time, O(n) space

**Idea:** If any element appears more than twice, it's impossible (can't put it in both halves distinctly). Otherwise possible.

**Algorithm:**
1. Count frequencies.
2. If any frequency > 2, return false.
3. Return true.

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) |
| Space | O(n) — O(n) |
