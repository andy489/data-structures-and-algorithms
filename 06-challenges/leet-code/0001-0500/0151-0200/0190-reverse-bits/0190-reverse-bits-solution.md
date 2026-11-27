# 190. Reverse Bits — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reverse-bits/

---

## Solution: Bit Manipulation — O(1) time, O(1) space

**Idea:** Loop 32 times. Each iteration: left-shift result by 1, OR in LSB of `n`, right-shift `n` by 1.

**Complexity:**

| | |
|---|---|
| Time | O(1) — fixed 32 iterations |
| Space | O(1) |
