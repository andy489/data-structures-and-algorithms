# 284. Peeking Iterator

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/peeking-iterator/

---

## Problem Statement

Design an iterator that supports the `peek` operation on an existing iterator in addition to the `hasNext` and `next` operations.

Implement the `PeekingIterator` class:
- `PeekingIterator(Iterator<int> nums)` Initializes the object with the given integer iterator `iterator`.
- `int next()` Returns the next element in the array and moves the pointer to the next element.
- `bool hasNext()` Returns `true` if there are still some elements in the array.
- `int peek()` Returns the next element in the array **without** moving the pointer.

Note: Each language may have a different implementation of the constructor and `Iterator`, but they all support the `int next()` and `boolean hasNext()` functions.

---

## Examples

**Example 1:**
```
Input:
["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
[[[1, 2, 3]], [], [], [], [], []]

Output:
[null, 1, 2, 2, 3, false]
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 1000`
- All the calls to `next` and `peek` are valid.
- At most `1000` calls will be made to `next`, `hasNext`, and `peek`.
