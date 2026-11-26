# 2008. Maximum Earnings From Taxi

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-earnings-from-taxi/

---

## Problem Statement

There are `n` points on a number line. You drive a taxi and pick up passengers. The `i`-th ride goes from `starti` to `endi` and earns `tip_i + (endi - starti)` dollars. No two rides can share the same start. Return the maximum earnings you can achieve.

---

## Examples

**Example 1:**
```
Input:  n = 5, rides = [[2,5,4],[1,5,1]]
Output: 7
```
Explanation: Take ride [2,5,4]: 4+(5-2)=7.

**Example 2:**
```
Input:  n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
Output: 20
```

---

## Constraints

- `1 <= n <= 10^5`
- `1 <= rides.length <= 3 * 10^4`
- `rides[i].length == 3`
- `1 <= starti < endi <= n`
- `1 <= tipi <= 10^5`
