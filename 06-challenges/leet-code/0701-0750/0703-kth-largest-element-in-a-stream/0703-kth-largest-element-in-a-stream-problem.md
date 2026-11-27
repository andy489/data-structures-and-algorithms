# 703. Kth Largest Element in a Stream

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/kth-largest-element-in-a-stream/

---

## Problem Statement

Design a class to find the `k`th largest element in a stream. Note that it is the `k`th largest element in the sorted order, not the `k`th distinct element.

Implement `KthLargest` class:
- `KthLargest(int k, int[] nums)` Initializes the object with the integer `k` and the stream of integers `nums`.
- `int add(int val)` Appends the integer `val` to the stream and returns the element representing the `k`th largest element in the stream.

---

## Examples

**Example 1:**
```
Input:  ["KthLargest","add","add","add","add","add"]
        [[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
Output: [null,4,5,5,8,8]
```

---

## Constraints

- `1 <= k <= 10^4`
- `0 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `-10^4 <= val <= 10^4`
- At most `10^4` calls will be made to `add`.
- It is guaranteed that there will be at least `k` elements in the array when the `add` function is called.
