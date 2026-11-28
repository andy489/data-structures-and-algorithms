# 3451. Find Invalid IP Addresses

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-invalid-ip-addresses/

---

## Problem Statement

Table: `logs`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| log_id      | int     |
| ip          | varchar |
| status_code | int     |
+-------------+---------+
```

log_id is the unique key for this table. Each row contains server access log information including IP address and HTTP status code.

Write a solution to find **invalid IP addresses**. Each octet in an IP address contains between `1` and `3` digits. An IPv4 address is invalid if it meets any of these conditions:

- Contains a number **greater than** `255` in any octet.
- Has **leading zeros** in any octet (for example, `01.02.03.04`).
- Has **fewer or more** than `4` octets.

Return the result table ordered by `invalid_count`, `ip` in **descending** order respectively.

---

## Examples

**Example:**

Input:

logs table:
```
+--------+---------------+-------------+
| log_id | ip            | status_code |
+--------+---------------+-------------+
| 1      | 192.168.1.1   | 200         |
| 2      | 256.1.2.3     | 404         |
| 3      | 192.168.001.1 | 200         |
| 4      | 192.168.1.1   | 200         |
| 5      | 192.168.1     | 500         |
| 6      | 256.1.2.3     | 404         |
| 7      | 192.168.001.1 | 200         |
+--------+---------------+-------------+
```

Output:
```
+---------------+--------------+
| ip            | invalid_count|
+---------------+--------------+
| 256.1.2.3     | 2            |
| 192.168.001.1 | 2            |
| 192.168.1     | 1            |
+---------------+--------------+
```

---

## Constraints

- The table may contain duplicate IP entries.
