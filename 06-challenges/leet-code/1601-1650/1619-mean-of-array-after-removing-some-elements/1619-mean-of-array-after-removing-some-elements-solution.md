# 1619. Mean of Array After Removing Some Elements — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/mean-of-array-after-removing-some-elements/

---

## Solution: Sort and Trim — O(n log n) time, O(1) space

**Idea:** Sort the array, then sum the middle 90% of elements (skipping the first and last 5%). Since `arr.length` is always a multiple of 20, `5% = arr.length / 20` is always an integer.

**Algorithm:**
1. Sort the array.
2. Let `trim = n / 20`.
3. Sum elements from index `trim` to `n - trim - 1` (inclusive).
4. Divide by `n - 2 * trim`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sort |
| Space | O(1) — sort in-place, constant extra |
