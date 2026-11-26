# 493. Reverse Pairs — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/reverse-pairs/

---

## Solution: Modified Merge Sort — O(n log n) time, O(n) space

**Idea:** Use merge sort. During the merge step, before merging two sorted halves, count reverse pairs: for each element in the left half, find how many elements in the right half satisfy `left[i] > 2 * right[j]` using a two-pointer scan.

**Algorithm:**
1. Recursively sort left and right halves.
2. Count: for each i in left half, advance j while `nums[i] > 2 * nums[j]`; count += j - mid.
3. Merge the two sorted halves normally.
4. Return total count from all levels.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — standard merge sort with O(n) counting per level |
| Space | O(n) — temporary merge array |

---

## Solution 2: Binary Indexed Tree (Fenwick Tree) — O(n log n) time, O(n) space

**Idea:** Coordinate-compress values, then for each element nums[i] from left to right, query BIT for count of elements already inserted that are < nums[i]/2, then insert nums[i].

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — n BIT queries/updates |
| Space | O(n) — BIT array |
