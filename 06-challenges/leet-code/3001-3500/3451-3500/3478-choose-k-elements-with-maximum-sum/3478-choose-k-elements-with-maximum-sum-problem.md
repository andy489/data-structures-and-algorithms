# 3478. Choose K Elements With Maximum Sum

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/choose-k-elements-with-maximum-sum/

---

## Problem Statement

You are given two integer arrays, `nums1` and `nums2`, both of length `n`, along with a positive integer `k`.

For each index `i` from `0` to `n - 1`, perform the following:

- Find **all** indices `j` where `nums1[j]` is less than `nums1[i]`.
- Choose **at most** `k` values of `nums2[j]` at these indices to **maximize** the total sum.

Return an array `answer` of size `n`, where `answer[i]` represents the result for the corresponding index `i`.

---

## Examples

**Example 1:**
```
Input: nums1 = [4,2,1,5,3], nums2 = [10,20,30,40,50], k = 2
Output: [80,30,0,80,50]
Explanation:
- i=0: indices where nums1[j] < 4 are [1,2,4], top 2 of nums2 = 50+30 = 80
- i=1: indices where nums1[j] < 2 are [2], top 2 = 30
- i=2: no indices, result = 0
- i=3: indices [0,1,2,4], top 2 = 50+30 = 80 (wait: 40 is at i=3 itself)
  actually indices where nums1[j] < 5 are [0,1,2,4], top 2 of nums2 = 50+30 = 80
- i=4: indices where nums1[j] < 3 are [1,2], top 2 = 30+20 = 50
```

**Example 2:**
```
Input: nums1 = [2,2,2,2], nums2 = [3,1,2,3], k = 1
Output: [0,0,0,0]
```

---

## Constraints

- `n == nums1.length == nums2.length`
- `1 <= n <= 10^5`
- `1 <= nums1[i], nums2[i] <= 10^6`
- `1 <= k <= n`
