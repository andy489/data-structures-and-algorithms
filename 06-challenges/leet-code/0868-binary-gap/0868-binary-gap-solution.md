# 868. Binary Gap — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-gap/

---

## Solution: Single Pass — O(log n) time, O(1) space

**Idea:** Scan bits right to left. Track index of last seen 1. Update max gap when a new 1 is found.

**Algorithm:**
1. last = -1, ans = 0.
2. For bit i from 0: if bit i is 1 and last != -1: ans = max(ans, i - last). Update last = i.
3. Return ans.

**Complexity:**

| | |
|---|---|
| Time | O(log n) |
| Space | O(1) |
