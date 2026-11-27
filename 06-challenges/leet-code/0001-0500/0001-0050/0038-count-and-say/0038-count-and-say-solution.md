# 38. Count and Say — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-and-say/

---

## Solution: Iterative RLE simulation — O(n · L) time, O(L) space

**Idea:** Start from `"1"` and iteratively apply run-length encoding `n-1` times. Each pass scans the current string, counts consecutive equal characters, and appends `count + char` to a StringBuilder.

**Algorithm:**
1. Initialise `current = "1"`.
2. Repeat `n - 1` times:
   - Scan `current` with index `i`; for each run of equal chars, find end `j`, append `(j-i)` and `current[i]`.
   - Replace `current` with the new encoded string.
3. Return `current`.

**Complexity:**

| | |
|---|---|
| Time | O(n · L) — n iterations, each proportional to string length L (at most ~2×30 chars for n≤30) |
| Space | O(L) — one StringBuilder per iteration |

---

## Solution 2: Recursive — O(n · L) time, O(n · L) space

**Idea:** Recursively compute `countAndSay(n-1)`, then apply one RLE pass. Same time per level, but the call stack holds all intermediate strings simultaneously.

**Complexity:**

| | |
|---|---|
| Time | O(n · L) — one RLE pass per level |
| Space | O(n · L) — recursion depth n, each frame holds a string |
