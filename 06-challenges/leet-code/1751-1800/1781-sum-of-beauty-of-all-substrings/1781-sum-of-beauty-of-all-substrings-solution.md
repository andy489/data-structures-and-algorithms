# 1781. Sum of Beauty of All Substrings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

---

## Solution: Frequency Array — O(n^2 * 26) time, O(26) space

**Idea:** Enumerate all substrings. For each starting index `i`, expand the substring by moving the end index `j`, maintaining a frequency count of characters. At each step, find the max and min non-zero frequencies to compute the beauty.

**Algorithm:**
1. For each starting index `i` from 0 to n-1:
   - Maintain a frequency array of size 26.
   - For each ending index `j` from `i` to n-1:
     - Update frequency for `s[j]`.
     - Find max frequency and min non-zero frequency in the array.
     - Add `max - min` to the result.
2. Return total sum.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 * 26) — O(n^2) substrings, O(26) to scan frequencies each time |
| Space | O(26) = O(1) — fixed-size frequency array |
