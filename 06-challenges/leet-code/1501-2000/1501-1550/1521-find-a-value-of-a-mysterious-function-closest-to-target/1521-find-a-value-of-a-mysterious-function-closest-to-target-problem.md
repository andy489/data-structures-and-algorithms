# 1521. Find a Value of a Mysterious Function Closest to Target

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-a-value-of-a-mysterious-function-closest-to-target/

---

## Problem Statement

Winston was given the following mysterious function `func`:

```
func(arr, l, r) = arr[l] & arr[l + 1] & ... & arr[r] 
```

(where `&` denotes the bitwise-AND operation)

He has an array `arr` and an integer `target` and he wants to find the values `l` and `r` that make `|func(arr, l, r) - target|` minimum possible.

Return *the minimum possible value of* `|func(arr, l, r) - target|`.

Notice that `func` should be called with the final values of `l` and `r`, not intermediate values.

---

## Examples

**Example 1:**
```
Input:  arr = [9,12,3,7,15], target = 5
Output: 2
Explanation: Calling func with all the pairs in the range [0,4] returns {9,12,3,7,15,8,0,3,3,1}. The value closest to 5 is 3, so the answer is |3 - 5| = 2.
```

**Example 2:**
```
Input:  arr = [1000000,1000000,1000000], target = 1
Output: 999999
```

**Example 3:**
```
Input:  arr = [1,2,4,8,16], target = 0
Output: 0
```

---

## Constraints

- `1 <= arr.length <= 10^5`
- `1 <= arr[i] <= 10^6`
- `1 <= target <= 10^6`
