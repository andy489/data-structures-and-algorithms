# 1079. Letter Tile Possibilities — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/letter-tile-possibilities/

---

## Solution: Backtracking with Frequency Count — O(n! / repetitions) time, O(26) space

**Idea:** Track character frequencies. At each position, try placing any character with remaining count > 0. Count all non-empty sequences.

**Algorithm:**
1. Count character frequencies.
2. DFS: for each char with freq > 0, place it, recurse, backtrack.
3. Count = 1 (current sequence) + sum of recursive counts.

**Complexity:**

| | |
|---|---|
| Time | O(n! / repetitions) |
| Space | O(26) |
