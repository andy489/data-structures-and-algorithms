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

---

## Solution 3: Recursive — O(n) time, O(n) space

**Idea:** Recursively advance `left` and `right` past non-alphanumeric characters, compare the characters at the two ends, then recurse on the inner substring. Base case: when the pointers meet or cross, the string is a palindrome.

**Algorithm:**
1. Define `check(left, right)`:
   - Advance `left` while non-alphanumeric and `left < right`.
   - Retreat `right` while non-alphanumeric and `left < right`.
   - If `left >= right`, return `true`.
   - If `toLowerCase(s[left]) != toLowerCase(s[right])`, return `false`.
   - Return `check(left + 1, right - 1)`.
2. Return `check(0, s.length - 1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each character visited at most once |
| Space | O(n) — recursion stack depth proportional to string length |

