# 32. Longest Valid Parentheses — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/longest-valid-parentheses/

---

## Solution: Stack — O(n) time, O(n) space

**Idea:** Push indices onto a stack. Keep a sentinel `-1` at the bottom to mark the base of the current valid window. When we see `'('` push its index. When we see `')'` pop the top: if the stack is then empty, push the current index as the new sentinel; otherwise the current valid length is `i - stack.top()`.

**Algorithm:**
1. Initialize stack with sentinel `-1`.
2. For each index `i`:
   - If `s[i] == '('`: push `i`.
   - Else pop top.
     - If stack is empty: push `i` (new sentinel).
     - Else: `ans = max(ans, i - stack.top())`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — single pass through the string |
| Space | O(n) — stack holds at most n indices |

---

## Solution 2: Two-Pass Counters — O(n) time, O(1) space

**Idea:** In one left-to-right pass count `open` and `close`. Whenever `close > open` reset both to 0 (unmatched `')'`). Whenever `open == close` record `2 * close` as a candidate answer. A right-to-left pass with swapped roles handles unmatched `'('` on the left.

**Algorithm:**
1. `open = close = ans = 0`. Sweep left to right:
   - `'('` → `open++`; `')'` → `close++`.
   - `close > open` → reset both to 0.
   - `open == close` → `ans = max(ans, 2 * close)`.
2. Reset. Sweep right to left:
   - Same logic with `open` and `close` swapped.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — two linear passes |
| Space | O(1) — only counter variables |
