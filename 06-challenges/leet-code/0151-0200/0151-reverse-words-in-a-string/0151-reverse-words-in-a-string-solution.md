# 151. Reverse Words in a String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reverse-words-in-a-string/

---

## Solution 1: Split + Reverse — O(n) time, O(n) space

**Idea:** Split on whitespace (automatically trims and collapses multiple spaces), reverse the word array, then join with a single space.

**Algorithm:**
1. Split `s` by one-or-more spaces: `s.trim().split("\\s+")`.
2. Reverse the resulting array.
3. Join with `" "` and return.

**Complexity:**

| | |
|---|---|
| Time | O(n) — split + reverse + join each O(n) |
| Space | O(n) — word array |

---

## Solution 2: Two-Pointer In-Place (char array) — O(n) time, O(n) space*

**Idea:** Convert to char array, then:
1. Reverse the whole string.
2. Reverse each individual word.
3. Clean up extra spaces in-place with a write pointer.

This follows the classic "reverse the whole, then reverse each word" pattern. Even though Java strings are immutable and we need a char array, it illustrates the O(1)-extra-space approach for mutable string languages.

**Algorithm:**
1. Convert `s.trim()` to `char[]` and reverse all characters.
2. Walk through, identify each word (non-space span), reverse it in-place.
3. Use a write pointer to compact consecutive spaces to exactly one space.
4. Return `new String(arr, 0, writePtr)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — three linear passes |
| Space | O(n) — char array (O(1) extra if string were mutable) |
