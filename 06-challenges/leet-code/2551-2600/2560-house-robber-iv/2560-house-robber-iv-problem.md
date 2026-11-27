# 2560. House Robber IV

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/house-robber-iv/

---

## Problem Statement

There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he **refuses to steal from adjacent homes**.

The **capability** of the robber is the maximum amount of money he steals from one house of all the houses he robbed.

You are given an integer array `nums` representing how much money is stashed in each house. More formally, the `i`th house from the left has `nums[i]` dollars.

You are also given an integer `k`, representing the **minimum** number of houses the robber will steal from. It is always possible to steal at least `k` houses.

Return the **minimum capability** of the robber out of all the possible ways to steal at least `k` houses.

---

## Examples

**Example 1:**
```
Input:  nums = [2,3,5,9], k = 2
Output: 5
```
*Explanation:* There are three ways to rob at least 2 houses:
- Rob indices 0 and 2. Capability is max(2, 5) = 5.
- Rob indices 0 and 3. Capability is max(2, 9) = 9.
- Rob indices 1 and 3. Capability is max(3, 9) = 9.
Return min(5, 9, 9) = 5.

**Example 2:**
```
Input:  nums = [2,7,9,3,1], k = 2
Output: 2
```
*Explanation:* The way which leads to minimum capability is to rob indices 0 and 4. Return max(2, 1) = 2.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= k <= (nums.length + 1)/2`
