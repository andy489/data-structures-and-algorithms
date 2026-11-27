# 1601. Maximum Number of Achievable Transfer Requests

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/

---

## Problem Statement

We have `n` buildings numbered from `0` to `n - 1`. Each building has a number of employees. It's transfer season, and some employees want to change the building they reside in.

You are given an array `requests` where `requests[i] = [fromi, toi]` represents an employee's request to transfer from building `fromi` to building `toi`.

**All buildings must have a net-zero change** in employees after the transfers (the number of employees in each building must stay the same). This means the sum of departures from each building must equal the sum of arrivals to each building.

Return the **maximum** number of achievable requests.

---

## Examples

**Example 1:**
```
Input: n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
Output: 5
Explanation: Let us consider requests 0,1,2,3,4. 
  Building 0: departure=[0,2], arrival=[1] → net = -2+1 = -1 ✗
  ...
  Taking requests [0,1,2,4,5] achieves net-zero everywhere.
```

**Example 2:**
```
Input: n = 3, requests = [[0,0],[1,2],[2,1]]
Output: 3
```

---

## Constraints

- `1 <= n <= 20`
- `1 <= requests.length <= 16`
- `requests[i].length == 2`
- `0 <= fromi, toi < n`
