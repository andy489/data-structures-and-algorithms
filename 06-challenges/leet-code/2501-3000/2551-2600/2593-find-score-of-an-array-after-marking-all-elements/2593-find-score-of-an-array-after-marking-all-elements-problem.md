# 2593. Find Score of an Array After Marking All Elements

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/

## Problem

You are given an array `nums` consisting of positive integers.

Starting with `score = 0`, apply the following algorithm:

- Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
- Add the value of the chosen integer to `score`.
- Mark **the chosen element and its two adjacent elements if they exist**.
- Repeat until all the array elements are marked.

Return the score you get after applying the above algorithm.

## Examples

**Example 1:**
```
Input: nums = [2,1,3,4,5,2]
Output: 7
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its adjacent: [2,1,3,4,5,2] -> marked indices 0,1,2.
- 2 is the smallest unmarked element, so we mark it and its left adjacent: [2,1,3,4,5,2] -> marked indices 4,5.
- 4 is the only remaining unmarked element, so we mark it.
Our score is 1 + 2 + 4 = 7.
```

**Example 2:**
```
Input: nums = [2,3,5,1,3,2]
Output: 5
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its adjacent: indices 2,3,4.
- 2 is the smallest at index 0, mark indices 0,1.
- 2 at index 5 is the only remaining, mark it.
Our score is 1 + 2 + 2 = 5.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^6`
