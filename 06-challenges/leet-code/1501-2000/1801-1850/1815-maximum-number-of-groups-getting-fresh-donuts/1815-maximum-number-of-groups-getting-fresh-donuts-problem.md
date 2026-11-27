# 1815. Maximum Number of Groups Getting Fresh Donuts

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/

---

## Problem Statement

There is a donuts shop that bakes donuts in batches of `batchSize`. They have a rule, the shop must start a new batch before serving any of the groups. A group must wait until the new batch gets ready. Each waiting group must be served in order, but once the new batch is ready, any amount of donuts from the batch can be served to the waiting group.

You are given an integer `batchSize` and an integer array `groups`, where `groups[i]` is the size of the `i`-th group of customers. A group of customers is **happy** if they can get all their donuts at the start of a new batch. You can arrange the order of groups in any way you want.

Return the **maximum** possible number of happy groups.

---

## Examples

**Example 1:**
```
Input: batchSize = 3, groups = [1,2,3,4,5,6]
Output: 4
Explanation: You can arrange the groups as [6,2,4,5,1,3]. Then the 1st, 2nd, 4th, and 6th groups are happy.
```

**Example 2:**
```
Input: batchSize = 4, groups = [1,3,2,5,2,2,1,6]
Output: 4
```

---

## Constraints

- `1 <= batchSize <= 9`
- `1 <= groups.length <= 30`
- `1 <= groups[i] <= 10^9`
