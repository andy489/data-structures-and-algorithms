# 1502. Can Make Arithmetic Progression From Sequence — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

---

## Solution: Sort and Check — O(n log n) time, O(1) space

**Idea:** Sort the array, then verify every consecutive pair has the same difference.

**Algorithm:**
1. Sort `arr`.
2. Compute `diff = arr[1] - arr[0]`.
3. For each consecutive pair from index 1 onward, if `arr[i] - arr[i-1] != diff`, return `false`.
4. Return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sort |
| Space | O(1) — sort in-place |
