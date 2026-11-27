# 1157. Online Majority Element In Subarray

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/online-majority-element-in-subarray/

---

## Problem Statement

Design a data structure that efficiently answers multiple queries of the form: given a subarray `arr[left..right]` and an integer `threshold`, find any element in that subarray that appears **at least** `threshold` times, or return `-1` if no such element exists.

Implement the `MajorityChecker` class:
- `MajorityChecker(int[] arr)` — initializes the data structure with the given array.
- `int query(int left, int right, int threshold)` — returns the element in the subarray `arr[left..right]` that appears at least `threshold` times, or `-1` if no such element exists.

**Note:** Each call guarantees `2 * threshold > right - left + 1`, so at most one majority element can exist per query.

---

## Examples

**Example 1:**
```
Input:
  MajorityChecker(arr = [1, 1, 2, 2, 1, 1])
  query(0, 5, 4) → 1
  query(0, 3, 3) → -1
  query(2, 3, 2) → 2

Output: [null, 1, -1, 2]
```

---

## Constraints

- `1 <= arr.length <= 20000`
- `1 <= arr[i] <= 20000`
- `0 <= left <= right < arr.length`
- `threshold <= right - left + 1`
- `2 * threshold > right - left + 1`
- At most `10000` calls to `query`
