# 179. Largest Number — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-number/

---

## Solution: Custom Comparator Sort — O(n log n · k) time, O(n) space

**Idea:** To decide which of two numbers `a` and `b` should come first, compare the two concatenations `ab` vs `ba` as strings. If `ab > ba`, then `a` should precede `b`. Sorting all numbers by this comparator yields the largest possible number.

**Algorithm:**
1. Convert each integer to its string representation.
2. Sort the strings using the comparator: `(a, b) → (b+a).compareTo(a+b)` (descending order of the concatenation).
3. If the first (largest) string is `"0"`, the entire result is `"0"` (all zeros).
4. Otherwise, join all sorted strings and return the result.

**Complexity:**

| | |
|---|---|
| Time | O(n log n · k) — n log n comparisons, each comparing two strings of total length ≤ 2k (k = max digits) |
| Space | O(n) — string array and output string |
