# 1655. Distribute Repeating Integers

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/distribute-repeating-integers/

---

## Problem Statement

You have a bag of `n` integers, where each integer has a frequency. You want to distribute these integers to `m` customers. The `i`-th customer has a demand of `quantity[i]` units.

Formally, you have exactly `vals.length` integers in the bag where `vals[j]` represents the value of the `j`-th integer. The `j`-th integer has a frequency of `cnt[j]`. Two integers are of the **same type** if they have the same value.

Each customer must get `quantity[i]` integers of the same type. This means every integer given to a customer must have the same value.

Return `true` if it is possible to distribute integers to all `m` customers, otherwise `false`.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4], quantity = [2]
Output: false
```

**Example 2:**
```
Input: nums = [1,2,3,3], quantity = [2]
Output: true
```

**Example 3:**
```
Input: nums = [1,1,2,2], quantity = [2,2]
Output: true
```

---

## Constraints

- `n == nums.length`
- `1 <= n <= 10^5`
- `1 <= nums[i] <= 10^9`
- `m == quantity.length`
- `1 <= m <= 10`
- `1 <= quantity[i] <= 10^5`
- There are at most 50 unique values in `nums`.
