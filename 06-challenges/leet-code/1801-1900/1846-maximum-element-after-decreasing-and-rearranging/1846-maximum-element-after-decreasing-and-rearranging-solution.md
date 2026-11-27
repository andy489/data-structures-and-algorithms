# 1846. Maximum Element After Decreasing and Rearranging — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/

---

## Solution: Sort + Greedy — O(n log n) time, O(1) space

**Idea:** Sort the array. The first element is set to 1. For each subsequent element, the maximum value it can contribute is `min(arr[i], prev + 1)` where `prev` is the value assigned to the previous position. This greedy approach maximizes each position.

**Algorithm:**
1. Sort `arr`.
2. Set `arr[0] = 1`.
3. For `i` from 1 to n-1: `arr[i] = min(arr[i], arr[i-1] + 1)`.
4. Return `arr[n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting dominates |
| Space | O(1) — sort in-place |
