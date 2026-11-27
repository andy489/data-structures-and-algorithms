# 1122. Relative Sort Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/relative-sort-array/

---

## Solution: Custom Comparator with Rank Map — O(n log n) time, O(n) space

**Idea:** Assign each element in `arr2` a rank by its position. Elements not in `arr2` get a rank beyond all `arr2` elements, and ties among them break by value. Then sort `arr1` using this comparator.

**Algorithm:**
1. Build a rank map from `arr2`: `rank[arr2[i]] = i`.
2. Sort `arr1`: elements in `arr2` sort by their rank; elements not in `arr2` sort by value (shifted past all ranks).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting `arr1` |
| Space | O(m) — rank map of size `arr2.length` |

---

## Solution 2: Counting Sort — O(n + K) time, O(K) space

**Idea:** Since values are bounded by 1000, use a frequency array. First output elements in `arr2` order using their counts, then iterate 0..1000 for remaining elements.

**Algorithm:**
1. Count frequencies of all elements in `arr1`.
2. For each element in `arr2`, append it `count[x]` times.
3. For values 0..1000 not in `arr2`, append remaining occurrences in order.

**Complexity:**

| | |
|---|---|
| Time | O(n + K) where K = 1001 |
| Space | O(K) for the count array |
