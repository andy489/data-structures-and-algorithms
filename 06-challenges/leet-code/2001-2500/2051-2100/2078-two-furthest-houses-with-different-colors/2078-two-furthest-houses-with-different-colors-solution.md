# 2078. Two Furthest Houses With Different Colors — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/two-furthest-houses-with-different-colors/

---

## Solution: Two Passes — O(n) time, O(1) space

**Idea:** Check from left for rightmost different-color house, and from right for leftmost different-color house.

**Algorithm:**
1. From left: find rightmost index with different color from colors[0].
2. From right: find leftmost index with different color from colors[n-1].
3. Return max distance.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
