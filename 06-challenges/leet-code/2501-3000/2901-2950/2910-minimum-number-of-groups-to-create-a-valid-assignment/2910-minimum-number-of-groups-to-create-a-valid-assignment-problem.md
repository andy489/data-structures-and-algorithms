# 2910. Minimum Number of Groups to Create a Valid Assignment

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment/

---

## Problem Statement

You are given a collection of numbered `balls` and instructed to sort them into boxes for a nearly balanced distribution. There are two rules you must follow:

- Balls with the same box must have the same value. But, if you have more than one ball with the same number, you can put them in different boxes.
- The biggest box can only have one more ball than the smallest box.

Return the *fewest number of boxes* to sort these balls following these rules.

---

## Examples

**Example 1:**
```
Input: balls = [3,2,3,2,3]
Output: 2
Explanation: Boxes: [3,3,3] and [2,2]
```

**Example 2:**
```
Input: balls = [10,10,10,3,1,1]
Output: 4
Explanation: Boxes: [10], [10,10], [3], [1,1]
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
