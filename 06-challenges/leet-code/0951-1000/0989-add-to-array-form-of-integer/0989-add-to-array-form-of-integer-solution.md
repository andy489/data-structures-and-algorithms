# 989. Add to Array-Form of Integer — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/add-to-array-form-of-integer/

---

## Solution: Add k as carry from right — O(max(n, log k)) time, O(n) space

**Idea:** Scan from right, adding k and propagating carry.

**Complexity:**

| | |
|---|---|
| Time | O(max(n, log k)) |
| Space | O(n) — result |
