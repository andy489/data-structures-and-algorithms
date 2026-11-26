# 438. Find All Anagrams in a String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-all-anagrams-in-a-string/

---

## Solution: Sliding Window with Frequency Array — O(n) time, O(1) space

**Idea:** Maintain a sliding window of size `|p|`. Track character frequency differences between the window and `p` using a count array and a `matches` counter. When all 26 chars match, add the window start to the result.

**Algorithm:**
1. Build `pCount[26]` and `windowCount[26]` for the first window.
2. Count initial `matches` (positions where both counts are equal).
3. Slide right: add new char (adjust match), remove left char (adjust match). When `matches == 26`, record start.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — fixed 26-element arrays |
