# 1657. Determine if Two Strings Are Close — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/determine-if-two-strings-are-close/

---

## Solution: Frequency Analysis — O(n) time, O(1) space

**Idea:** Two strings are close if and only if:
1. They have the same set of distinct characters (operation 2 can only swap frequencies between existing characters, not introduce new ones).
2. The multiset of frequencies is the same (we can rearrange which character holds which frequency via operation 2, then permute positions via operation 1).

**Algorithm:**
1. Count character frequencies for both strings.
2. Check that both strings use the same set of characters.
3. Check that the sorted frequency arrays are equal.

**Complexity:**

| | |
|---|---|
| Time | O(n + 26 log 26) = O(n) |
| Space | O(1) — fixed 26-element arrays |
