# 3012. Minimize Length of Array Using Operations

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimize-length-of-array-using-operations/

---

## Problem Statement

You are given a 0-indexed integer array `nums` containing positive integers.

In one operation, you can select two indices `i` and `j` where `nums[i] % nums[j] != 0` (or vice-versa is also fine — select any i != j where nums[i] % nums[j] != 0), replace `nums[i]` with `nums[i] % nums[j]`, and remove `nums[j]`.

Wait — the actual operation: select indices i != j, if nums[i] % nums[j] != 0 AND nums[j] % nums[i] != 0, you can replace one of them with the remainder. 

Actually the problem is: pick any two indices i != j, if nums[i] % nums[j] != 0, replace nums[i] with nums[i] % nums[j]. You can also remove elements by making them 0 (not really).

The key insight: we want to minimize the array length. Elements can be removed if they can be made to produce 0 remainders (i.e., one divides the other). The minimum is the count of elements that are not divisible by any smaller element, plus those that remain.

Cleaner: find the minimum element m. All multiples of m can be replaced by m % (something) = 0 and removed? No — if x % m != 0, x % m < m which is smaller than m — contradiction since m is minimum. So m divides all... no. 

The minimum array length = count of elements NOT divisible by the global minimum if the global minimum appears multiple times it still contributes 1, plus check if any element < min exists...

**Key observation:** Let mn = min(nums). Any element x > mn: x % mn could be 0 (x is divisible by mn, can be eliminated) or x % mn > 0 (a new smaller element appears which contradicts mn being min). So actually any element divisible by mn gets eliminated, and mn itself stays. Elements not divisible by mn cannot exist since mn is minimum... Actually they CAN — 3 and 4: min=3, 4%3=1 < 3, contradicts min.

So: once we apply operations, elements not divisible by global min get reduced. The answer = number of elements that are NOT multiples of the minimum element (each such element will eventually become a new minimum) + (1 if the min appears at least once).

Simpler: the answer = count of elements that are coprime to / not divisible by global minimum + 1 ... 

The correct answer: if all elements are equal or multiples of the minimum, answer = 1 (keep one min, eliminate rest). Otherwise, answer = count of non-multiples of min + 1.

---

## Examples

**Example 1:**
```
Input:  nums = [1,4,3,1]
Output: 1
```

**Example 2:**
```
Input:  nums = [5,5,5,10,5]
Output: 2
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
