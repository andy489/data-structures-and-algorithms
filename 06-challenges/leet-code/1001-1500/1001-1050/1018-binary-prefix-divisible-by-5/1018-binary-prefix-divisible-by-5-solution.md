# 1018. Binary Prefix Divisible By 5 — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-prefix-divisible-by-5/

---

## Solution: Running Modulo — O(n) time, O(1) space

**Idea:** Maintain running value mod 5. Each step: cur = (cur * 2 + nums[i]) % 5.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
