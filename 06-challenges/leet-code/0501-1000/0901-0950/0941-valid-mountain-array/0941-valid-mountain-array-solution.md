# 941. Valid Mountain Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-mountain-array/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Walk up from left while increasing, walk down from right while decreasing. If both pointers meet at the same non-boundary index, it's a mountain.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
