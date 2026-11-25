# 1011. Capacity To Ship Packages Within D Days

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

---

## Problem Statement

A conveyor belt has packages that must be shipped from one port to another within `days` days.

The `i`th package on the conveyor belt has a weight of `weights[i]`. Each day, we load the ship with packages in the order given by `weights`. We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within `days` days.

---

## Examples

**Example 1:**
```
Input:  weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
```

**Example 2:**
```
Input:  weights = [3,2,2,4,1,4], days = 3
Output: 6
```

---

## Constraints

- `1 <= days <= weights.length <= 5 * 10^4`
- `1 <= weights[i] <= 500`
