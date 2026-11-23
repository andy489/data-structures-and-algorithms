# 541. Reverse String II — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reverse-string-ii/

---

## Solution: Chunk Traversal — O(n) time, O(n) space

**Idea:** Convert to char array and step through every 2k characters. At each chunk start, reverse min(k, remaining) characters in-place.

**Algorithm:**
1. Convert `s` to char array.
2. Iterate `i` from 0 to n, stepping by 2k.
3. At each step, reverse `chars[i .. min(i+k-1, n-1)]`.
4. Return new string from char array.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — char array |
