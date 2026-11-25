# 796. Rotate String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/rotate-string/

---

## Solution: Double Concatenation — O(n²) time, O(n) space

**Idea:** Every rotation of `s` appears as a substring of `s + s`. Check if `goal` is a substring of `s + s`.

**Algorithm:**
1. If `len(s) != len(goal)`, return false.
2. Return `goal in (s + s)`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — substring search in length-2n string |
| Space | O(n) — concatenated string |
