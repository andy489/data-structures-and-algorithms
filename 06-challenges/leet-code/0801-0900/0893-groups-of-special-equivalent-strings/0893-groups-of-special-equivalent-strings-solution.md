# 893. Groups of Special-Equivalent Strings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/groups-of-special-equivalent-strings/

---

## Solution: Canonical Form — O(n * m log m) time, O(n * m) space

**Idea:** Two strings are special-equivalent iff their sorted even-indexed chars and sorted odd-indexed chars are the same. Create canonical forms and count distinct ones.

**Complexity:**

| | |
|---|---|
| Time | O(n * m log m) |
| Space | O(n * m) |
