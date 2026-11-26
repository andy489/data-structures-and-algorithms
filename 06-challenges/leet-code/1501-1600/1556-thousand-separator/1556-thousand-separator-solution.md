# 1556. Thousand Separator — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/thousand-separator/

---

## Solution: String Building — O(d) time, O(d) space

**Idea:** Convert to string and insert a '.' separator every 3 characters from the right. Track the remaining length to determine when to insert dots.

**Algorithm:**
1. Convert `n` to string `s`.
2. Iterate over characters. Before appending character at index `i`, if `i > 0` and the remaining characters `(len - i)` are a multiple of 3, insert a dot.
3. Return the built string.

**Complexity:**

| | |
|---|---|
| Time | O(d) — where d is the number of digits |
| Space | O(d) — output string |
