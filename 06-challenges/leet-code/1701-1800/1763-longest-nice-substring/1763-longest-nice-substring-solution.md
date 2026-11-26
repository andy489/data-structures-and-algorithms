# 1763. Longest Nice Substring — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/longest-nice-substring/

---

## Solution: Divide and Conquer — O(n^2) time, O(n) space

**Idea:** A character that appears in only one case (either uppercase or lowercase) cannot be in any nice substring. Split on such a "bad" character, recurse on each part, and return the longest nice result found.

**Algorithm:**
1. For each character `c` in `s`, if its counterpart case is missing, split `s` at all occurrences of `c`.
2. Recurse on each segment.
3. Return the longest nice substring found across all segments.
4. If no bad character exists, `s` itself is nice.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — at most O(n) splits each O(n) in the worst case |
| Space | O(n) — recursion depth and substring copies |
