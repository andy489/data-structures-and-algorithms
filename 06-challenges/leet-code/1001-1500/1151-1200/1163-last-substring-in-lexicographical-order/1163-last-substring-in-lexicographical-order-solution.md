# 1163. Last Substring in Lexicographical Order — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/last-substring-in-lexicographical-order/

---

## Solution: Two-Pointer Suffix Comparison — O(n) time, O(1) space

**Idea:** The lexicographically largest substring is always a suffix of `s` (appending more characters can only make a string larger or equal). Use two pointers `i` and `j` (starting at 0 and 1) to compare two candidate suffixes character by character with an offset `k`. When a character at `i+k` is smaller than at `j+k`, advance `i` past the inferior position; when equal, increment `k`; when `i+k` is larger, advance `j` and reset `k`. Since `i < j` is maintained throughout, we avoid redundant positions.

**Algorithm:**
1. Set `i = 0`, `j = 1`, `k = 0`.
2. While `j + k < n`:
   - If `s[i+k] < s[j+k]`: advance `i` by `max(i + k + 1, j + 1)`, reset `k = 0`.
   - Else if `s[i+k] > s[j+k]`: advance `j` by `j + k + 1`, reset `k = 0`.
   - Else: increment `k`.
3. Return `s[i:]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each index position eliminated at most once |
| Space | O(1) — no extra storage beyond the two pointers |
