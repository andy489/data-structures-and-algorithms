# 395. Longest Substring with At Least K Repeating Characters — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

---

## Solution: Divide and Conquer — O(n · 26) = O(n) time, O(26 log n) space

**Idea:** Split the string at characters whose total frequency in the current window is less than `k` — those characters can never be part of a valid substring. Recursively solve each segment.

**Algorithm:**
1. Count frequency of each character in `[l, r]`.
2. Find first character with freq < k — split there.
3. Recurse on left and right; return max result.
4. Base: if all characters have freq ≥ k, return `r - l + 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n · 26) ≈ O(n) |
| Space | O(26 log n) — recursion depth × freq array |
