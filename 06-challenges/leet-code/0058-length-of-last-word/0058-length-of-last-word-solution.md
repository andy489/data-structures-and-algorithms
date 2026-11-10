# 58. Length of Last Word — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/length-of-last-word/

---

## Solution: Reverse Scan — O(n) time, O(1) space

**Idea:** Walk from the end of the string backward: first skip any trailing spaces, then count consecutive non-space characters. The count when we hit the next space (or the start of the string) is the answer.

**Algorithm:**
1. Initialize `i = s.length() - 1`, `count = 0`.
2. Skip trailing spaces: while `i >= 0` and `s[i] == ' '`, decrement `i`.
3. Count the last word: while `i >= 0` and `s[i] != ' '`, increment `count` and decrement `i`.
4. Return `count`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — at most one full pass in the worst case (all spaces then one word at the start) |
| Space | O(1) — only index and counter variables |

---

## Worked Example — `s = "   fly me   to   the moon  "`

- Skip trailing spaces: `i` moves past the two trailing spaces to `'n'`.
- Count `'n'`, `'o'`, `'o'`, `'m'` → `count = 4`.
- Hit space → stop.

**Answer: `4`** ✓
