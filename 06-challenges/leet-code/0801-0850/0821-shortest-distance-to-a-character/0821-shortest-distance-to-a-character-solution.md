# 821. Shortest Distance to a Character — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/shortest-distance-to-a-character/

---

## Solution: Two-Pass — O(n) time, O(n) space

**Idea:** Forward pass: for each position record distance to previous c. Backward pass: take min with distance to next c.

**Algorithm:**
1. Forward pass: track last seen position of c, fill distances.
2. Backward pass: track next c position from right, update with min.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(n) — answer array |
