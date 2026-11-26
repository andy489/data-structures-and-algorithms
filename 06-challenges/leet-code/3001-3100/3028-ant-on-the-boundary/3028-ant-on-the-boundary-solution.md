# 3028. Ant On The Boundary — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/ant-on-the-boundary/

---

## Solution: Prefix Sum — O(n) time, O(1) space

**Idea:** Track running sum. Each time it reaches 0 (after at least one step), count it.

**Algorithm:**
1. Maintain prefix sum pos = 0.
2. For each num in nums: pos += num.
3. If pos == 0, increment count.
4. Return count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) — one pass |
| Space | O(1) — O(1) |
