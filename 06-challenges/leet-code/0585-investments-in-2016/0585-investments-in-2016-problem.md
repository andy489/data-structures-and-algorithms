# 585. Investments in 2016

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/investments-in-2016/

---

## Problem Statement

Table: `Insurance`

```
+-------------+-------+
| Column Name | Type  |
+-------------+-------+
| pid         | int   |
| tiv_2015    | float |
| tiv_2016    | float |
| lat         | float |
| lon         | float |
+-------------+-------+
```

`pid` is the primary key. Each row contains information about one policy: the policyholder's id, their total investment value in 2015 and 2016, and the latitude/longitude of their city.

Write a solution to report the sum of all total investment values in 2016 `tiv_2016`, for all policyholders who:

1. Have the same `tiv_2015` value as one or more other policyholders, **and**
2. Are not located in the same city as any other policyholder (unique `(lat, lon)` pair).

Round `tiv_2016` to **two decimal places**.

---

## Examples

**Example 1:**
```
Input:
Insurance table:
+-----+----------+----------+-----+-----+
| pid | tiv_2015 | tiv_2016 | lat | lon |
+-----+----------+----------+-----+-----+
| 1   | 10       | 5        | 10  | 10  |
| 2   | 20       | 20       | 20  | 20  |
| 3   | 10       | 30       | 20  | 20  |
| 4   | 10       | 40       | 40  | 40  |
+-----+----------+----------+-----+-----+

Output:
+----------+
| tiv_2016 |
+----------+
| 45.00    |
+----------+
Explanation: pid=1 and pid=4 share tiv_2015=10 and have unique locations → 5+40=45.
```
