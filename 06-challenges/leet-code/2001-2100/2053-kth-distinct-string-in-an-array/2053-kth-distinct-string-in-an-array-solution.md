# 2053. Kth Distinct String in an Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/kth-distinct-string-in-an-array/

---

## Solution: Frequency Count — O(n) time, O(n) space

**Idea:** Count frequencies; scan left to right counting distinct strings until k-th.

**Algorithm:**
1. Count freq of each string.
2. Scan arr, skip non-unique, count unique; return k-th.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
