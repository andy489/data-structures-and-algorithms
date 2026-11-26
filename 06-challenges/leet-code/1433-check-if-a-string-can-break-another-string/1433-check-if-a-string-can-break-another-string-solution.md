# 1433. Check If A String Can Break Another String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-a-string-can-break-another-string/

---

## Solution: Sort and Compare — O(n log n) time, O(n) space

**Idea:** Sort both. Check if s1 >= s2 at all positions OR s2 >= s1 at all positions.

**Algorithm:**
1. Sort both strings.
2. Check if for all i: s1[i] >= s2[i] (s1 breaks s2).
3. OR for all i: s2[i] >= s1[i] (s2 breaks s1).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
