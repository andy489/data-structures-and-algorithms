# 715. Range Module

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/range-module/

---

## Problem Statement

A Range Module is a module that tracks ranges of numbers. Design a data structure to track the ranges represented as half-open intervals and query about them.

Implement the `RangeModule` class:
- `RangeModule()` Initializes the object of the data structure.
- `void addRange(int left, int right)` Adds the half-open interval `[left, right)`, tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval `[left, right)` that are not already tracked.
- `boolean queryRange(int left, int right)` Returns `true` if every real number in the interval `[left, right)` is currently being tracked, and `false` otherwise.
- `void removeRange(int left, int right)` Stops tracking every real number currently being tracked in the half-open interval `[left, right)`.

---

## Examples

**Example 1:**
```
Input:  ["RangeModule","addRange","removeRange","queryRange","queryRange","queryRange"]
        [[],[10,20],[14,16],[10,14],[13,15],[16,17]]
Output: [null,null,null,true,false,true]
```

---

## Constraints

- `1 <= left < right <= 10^9`
- At most `10^4` calls will be made to `addRange`, `queryRange`, and `removeRange`.
