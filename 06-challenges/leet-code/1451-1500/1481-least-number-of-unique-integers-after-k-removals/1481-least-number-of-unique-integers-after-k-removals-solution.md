# 1481. Least Number Of Unique Integers After K Removals — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

---

## Solution: Frequency Sort — O(n log n) time, O(n) space

**Idea:** Count frequencies, sort ascending. Greedily remove elements with lowest frequency first.

**Algorithm:**
1. Count frequencies. Sort frequency values.
2. For each freq in ascending order: if k >= freq, k -= freq, unique--. Else break.
3. Return remaining unique count.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
