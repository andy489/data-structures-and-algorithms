# 3492. Maximum Containers on a Ship — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/maximum-containers-on-a-ship/

---

## Solution: Math — O(1) time, O(1) space

**Idea:** The deck has `n * n` total cells. Each container weighs `w`, so the maximum containers that fit by weight is `maxWeight / w`. The answer is the minimum of the deck capacity and the weight-limited count.

**Algorithm:**
1. Compute deck capacity: `n * n`.
2. Compute weight-limited count: `maxWeight / w` (integer division).
3. Return `min(n * n, maxWeight / w)`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
