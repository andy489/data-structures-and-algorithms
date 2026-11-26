# 1053. Previous Permutation With One Swap — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/previous-permutation-with-one-swap/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** Find the rightmost index i where arr[i] > arr[i+1]. Then find the largest element to the right of i that is less than arr[i] (prefer the leftmost one if ties).

**Algorithm:**
1. Find rightmost i where arr[i] > arr[i+1]. If none, return arr.
2. Find the largest value < arr[i] in arr[i+1..], taking leftmost if ties.
3. Swap and return.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
