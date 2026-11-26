# 443. String Compression — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/string-compression/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use `read` pointer to scan groups and `write` pointer to overwrite in place. For each group, write the character and (if count > 1) each digit of the count string.

**Algorithm:**
1. `read = 0`, `write = 0`.
2. While `read < n`: find end of current group, compute count.
3. Write `chars[read]`, then write each digit of `count` if `count > 1`.
4. Advance `read` to next group.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
