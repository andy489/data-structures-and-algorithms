# 1051. Height Checker — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/height-checker/

---

## Solution: Sort and Compare — O(n log n) time, O(n) space

**Idea:** Sort a copy of heights and count positions where the two arrays differ.

**Algorithm:**
1. Create sorted copy.
2. Count positions where `heights[i] != sorted[i]`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
