# 1849. Splitting a String Into Descending Consecutive Values — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/

---

## Solution: Backtracking — O(n^2) time, O(n) space

**Idea:** Try all possible first segment lengths. Once the first segment value is chosen, the next required value is exactly `first - 1`. Recurse to find the rest of the string using that next value. The search space is small (n ≤ 20).

**Note:** Use `long` to handle values up to 10^18 (20-digit numbers); overflow check needed since 20-digit numbers exceed `long` range — cap at a sentinel larger than any valid value.

**Algorithm:**
1. For each prefix length `len` from 1 to n-1: parse first value, recurse with `(remaining string, first - 1, partsFound + 1)`.
2. Base case: empty string remaining and `partsFound >= 2` → return true.
3. At each step: if the current prefix equals `expected`, recurse on the suffix with `expected - 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — at most O(n) choices per level, O(n) levels |
| Space | O(n) — recursion stack depth |
