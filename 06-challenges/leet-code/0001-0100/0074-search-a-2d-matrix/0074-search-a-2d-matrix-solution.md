# 74. Search a 2D Matrix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/search-a-2d-matrix/

---

## Solution: Binary Search on Flattened Matrix — O(log(m·n)) time, O(1) space

**Idea:** The two properties guarantee the matrix is equivalent to a sorted 1D array of length `m*n`. Run a single binary search over virtual indices `[0, m*n-1]`, mapping each index `mid` to `matrix[mid/n][mid%n]`.

**Algorithm:**
1. Set `lo = 0`, `hi = m*n - 1`.
2. While `lo <= hi`:
   - `mid = (lo + hi) / 2`
   - `val = matrix[mid / n][mid % n]`
   - If `val == target` return `true`.
   - If `val < target` set `lo = mid + 1`, else `hi = mid - 1`.
3. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(log(m·n)) — single binary search over m·n elements |
| Space | O(1) — no extra storage |

---

## Solution 2: Two Binary Searches — O(log m + log n) time, O(1) space

**Idea:** First binary search finds the row: the last row whose first element is `<= target`. Second binary search finds the target within that row.

**Algorithm:**
1. Binary search rows on `[0, m-1]`: find the largest `r` such that `matrix[r][0] <= target`. If no such row exists (target < all first elements), return `false`.
2. Binary search columns on `[0, n-1]` in row `r`: return `true` if target found, else `false`.

**Complexity:**

| | |
|---|---|
| Time | O(log m + log n) = O(log(m·n)) — two independent binary searches |
| Space | O(1) — no extra storage |
