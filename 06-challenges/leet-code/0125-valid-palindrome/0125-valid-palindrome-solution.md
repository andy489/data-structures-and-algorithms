# 125. Valid Palindrome — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/valid-palindrome/

---

## Solution 1: Two Pointers (In-Place) — O(n) time, O(1) space

**Idea:** Use two pointers starting at opposite ends of the string. Advance each pointer past any non-alphanumeric character, then compare the characters at both pointers case-insensitively. If they ever differ, return `false`; if the pointers cross, return `true`.

**Algorithm:**
1. Set `left = 0`, `right = s.length - 1`.
2. While `left < right`:
   - Advance `left` while it points to a non-alphanumeric character.
   - Retreat `right` while it points to a non-alphanumeric character.
   - If `left < right` and `toLowerCase(s[left]) != toLowerCase(s[right])`, return `false`.
   - Increment `left`, decrement `right`.
3. Return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each character visited at most once |
| Space | O(1) — no extra storage |

---

## Solution 2: Clean then Check — O(n) time, O(n) space

**Idea:** Filter the string to only lowercase alphanumeric characters, then compare it against its reverse.

**Algorithm:**
1. Build `cleaned` by iterating `s`, keeping only alphanumeric characters converted to lowercase.
2. Return `cleaned == reverse(cleaned)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — one pass to clean, one to reverse/compare |
| Space | O(n) — cleaned string |
