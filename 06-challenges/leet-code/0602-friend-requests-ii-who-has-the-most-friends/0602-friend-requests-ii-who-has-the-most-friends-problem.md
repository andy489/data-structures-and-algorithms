# 602. Friend Requests II: Who Has the Most Friends

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/

---

## Problem Statement

Table `RequestAccepted`:

```
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| requester_id   | int     |
| accepter_id    | int     |
| accept_date    | date    |
+----------------+---------+
```

`(requester_id, accepter_id)` is the primary key. This table contains the IDs of the user who sent the request and the user who received the request.

Write a solution to find the people who have the most friends and the most friends number. The test cases are generated so that only one person has the most friends.

---

## Examples

**Example 1:**
```
Input:
RequestAccepted table:
+--------------+-------------+-------------+
| requester_id | accepter_id | accept_date |
+--------------+-------------+-------------+
| 1            | 2           | 2016/06/03  |
| 1            | 3           | 2016/06/08  |
| 2            | 3           | 2016/06/08  |
| 3            | 4           | 2016/06/09  |
+--------------+-------------+-------------+

Output:
+----+-----+
| id | num |
+----+-----+
| 3  | 3   |
+----+-----+
```

---

## Constraints

- `1 <= requester_id, accepter_id <= 10^4`
- `requester_id != accepter_id`
- Each row is unique
