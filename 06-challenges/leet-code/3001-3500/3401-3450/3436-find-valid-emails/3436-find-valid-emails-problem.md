# 3436. Find Valid Emails

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-valid-emails/

## Problem

**Table: Users**

```
+-----------------+---------+
| Column Name     | Type    |
+-----------------+---------+
| user_id         | int     |
| email           | varchar |
+-----------------+---------+
(user_id) is the unique key for this table.
Each row contains a user's unique ID and email address.
```

Write a solution to find all the valid email addresses. A valid email address meets the following criteria:

- It contains exactly one `@` symbol.
- It ends with `.com`.
- The part before the `@` symbol contains only alphanumeric characters and underscores.
- The part after the `@` symbol and before `.com` contains a domain name that contains only letters.

Return the result table ordered by `user_id` in ascending order.

## Example

**Input:**
```
Users table:
+---------+---------------------+
| user_id | email               |
+---------+---------------------+
| 1       | alice@example.com   |
| 2       | bob_at_example.com  |
| 3       | charlie@example.net |
| 4       | david@domain.com    |
| 5       | eve@invalid         |
+---------+---------------------+
```

**Output:**
```
+---------+-------------------+
| user_id | email             |
+---------+-------------------+
| 1       | alice@example.com |
| 4       | david@domain.com  |
+---------+-------------------+
```
