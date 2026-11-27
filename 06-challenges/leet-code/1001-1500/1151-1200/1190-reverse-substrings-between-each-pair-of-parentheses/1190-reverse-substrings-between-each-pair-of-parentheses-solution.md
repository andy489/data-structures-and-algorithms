# 1190. Reverse Substrings Between Each Pair of Parentheses — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

---

## Solution: Stack — O(n²) time, O(n) space

**Idea:** Use a stack of string builders. Push a new builder on `(`, and on `)` pop the top, reverse it, and append to the new top. At the end the stack contains one builder with the result.

**Algorithm:**
1. Initialise a stack with one empty StringBuilder.
2. For each character in `s`:
   - If `(`: push a new empty StringBuilder.
   - If `)`: pop the top, reverse it, append to the new top.
   - Else: append the character to the top.
3. Return the remaining builder as a string.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — each reversal can touch O(n) characters, up to O(n) reversals |
| Space | O(n) — total characters across the stack |

---

## Solution 2: Wormhole (Portal) Trick — O(n) time, O(n) space

**Idea:** Pre-compute for each `(` or `)` its matching bracket position. Then simulate walking through the string: at every bracket teleport to its partner and flip direction. Characters in between are appended as they are encountered.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single traversal after O(n) bracket matching |
| Space | O(n) — pair array and result buffer |
