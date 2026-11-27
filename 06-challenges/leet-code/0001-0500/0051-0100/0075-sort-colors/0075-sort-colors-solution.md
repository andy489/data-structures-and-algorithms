# 75. Sort Colors — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/sort-colors/

---

## Solution 1: Counting Sort — O(n) time, O(1) space

**Idea:** Count occurrences of 0, 1, and 2, then overwrite the array using the counts.

**Algorithm:**
1. Scan `nums` once, incrementing `count[0]`, `count[1]`, or `count[2]`.
2. Write back: fill `count[0]` zeros, then `count[1]` ones, then `count[2]` twos.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(1) — fixed-size count array of length 3 |

---

## Solution 2: Dutch National Flag — O(n) time, O(1) space

**Idea:** Maintain three regions using two boundary pointers and a scan pointer:
- `[0, lo)` — all 0s (red)
- `[lo, mid)` — all 1s (white)
- `(hi, n-1]` — all 2s (blue)
- `[mid, hi]` — unclassified

**Algorithm:**
1. Initialize `lo = 0`, `mid = 0`, `hi = n - 1`.
2. While `mid <= hi`:
   - If `nums[mid] == 0`: swap `nums[lo]` and `nums[mid]`, advance both `lo` and `mid`.
   - If `nums[mid] == 1`: it belongs to the white region, advance `mid`.
   - If `nums[mid] == 2`: swap `nums[mid]` and `nums[hi]`, retreat `hi`. Do **not** advance `mid` — the swapped-in value from `hi` is unclassified and must be re-examined.

**Why not advance `mid` after swapping with `hi`:** The element that came from `hi` has not been inspected yet. Moving `mid` forward would skip it.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass, each element classified at most once |
| Space | O(1) — only pointer variables |
