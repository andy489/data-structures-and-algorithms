# 2570. Merge Two 2D Arrays by Summing Values

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/

---

## Problem Statement

You are given two **2D** integer arrays `nums1` and `nums2`.

- `nums1[i] = [id_i, val_i]` indicate that the number with the id `id_i` has a value equal to `val_i`.
- `nums2[i] = [id_i, val_i]` indicate that the number with the id `id_i` has a value equal to `val_i`.

Each array contains **unique** ids and is sorted in **ascending** order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

- Only ids that appear in at least one of the two arrays should be included in the resulting array.
- Each id should be included **only once** and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be `0`.

Return the resulting array sorted in ascending order by id.

---

## Examples

**Example 1:**
```
Input:  nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
Output: [[1,6],[2,3],[3,2],[4,6]]
```
*Explanation:*
- id = 1: 2 + 4 = 6
- id = 2: 3
- id = 3: 2
- id = 4: 5 + 1 = 6

**Example 2:**
```
Input:  nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
```
*Explanation:* No common ids, include each with its value.

---

## Constraints

- `1 <= nums1.length, nums2.length <= 200`
- `nums1[i].length == nums2[i].length == 2`
- `1 <= id_i <= 1000`
- `1 <= val_i <= 1000`
- Both arrays contain unique ids.
- Both arrays are in strictly ascending order by id.
