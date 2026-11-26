# 806. Number of Lines To Write String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-lines-to-write-string/

---

## Solution: Greedy Simulation — O(n) time, O(1) space

**Idea:** Simulate writing characters line by line. When a character doesn't fit, start a new line.

**Algorithm:**
1. Track current line width and line count (start at 1).
2. For each character, add its width; if exceeds 100, start new line.
3. Return [lines, current_width].

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through string |
| Space | O(1) — constant extra space |
