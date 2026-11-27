# 1701. Average Waiting Time

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/average-waiting-time/

---

## Problem Statement

There is a restaurant with a single chef. You are given an array `customers`, where `customers[i] = [arrival_i, time_i]`:

- `arrival_i` is the arrival time of the `i`th customer. The arrival times are sorted in **non-decreasing** order.
- `time_i` is the time needed to prepare the order of the `i`th customer.

When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time. The chef prepares food for customers **in the order they were given in the input**.

Return the **average** waiting time of all customers. Solutions within `10^-5` from the actual answer are considered accepted.

---

## Examples

**Example 1:**
```
Input: customers = [[1,2],[2,5],[4,3]]
Output: 5.00000
Explanation:
1) The first customer arrives at time 1, the chef starts at 1, finishes at 3, waiting time = 3 - 1 = 2.
2) The second customer arrives at time 2, the chef starts at 3, finishes at 8, waiting time = 8 - 2 = 6.
3) The third customer arrives at time 4, the chef starts at 8, finishes at 11, waiting time = 11 - 4 = 7.
Average waiting time = (2 + 6 + 7) / 3 = 5.
```

**Example 2:**
```
Input: customers = [[5,2],[5,4],[10,3],[20,1]]
Output: 3.25000
```

---

## Constraints

- `1 <= customers.length <= 10^5`
- `1 <= arrival_i, time_i <= 10^4`
- `arrival_i <= arrival_{i+1}`
