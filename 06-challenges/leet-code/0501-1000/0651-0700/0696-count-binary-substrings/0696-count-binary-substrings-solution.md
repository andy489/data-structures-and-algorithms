# 696. Count Binary Substrings — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-binary-substrings/

---

## Solution: Group Count — O(n) time, O(1) space

**Idea:** Count run lengths of consecutive 0s and 1s. For each transition, the number of valid substrings is `min(prevGroup, currGroup)`.

**Algorithm:**
1. Scan and count run lengths.
2. At each group change: `result += min(prev, curr)`, then `prev = curr, curr = 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
