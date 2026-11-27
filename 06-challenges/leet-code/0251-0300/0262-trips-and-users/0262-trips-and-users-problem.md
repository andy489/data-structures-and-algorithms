# 262. Trips and Users

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/trips-and-users/

---

## Problem Statement

Table `Trips` has columns: id, client_id, driver_id, city_id, status (enum: completed/cancelled_by_driver/cancelled_by_client), request_at.

Table `Users` has columns: users_id, banned (varchar), role (enum: client/driver/partner).

The **cancellation rate** = cancelled requests with unbanned users / total requests with unbanned users on that day.

Write a solution to find the cancellation rate of requests with unbanned users (both client and driver not banned) each day between `'2013-10-01'` and `'2013-10-03'`. Round to two decimal points.

---

## Examples

**Example 1:**
```
Output:
+------------+-------------------+
| Day        | Cancellation Rate |
+------------+-------------------+
| 2013-10-01 | 0.33              |
| 2013-10-02 | 0.00              |
| 2013-10-03 | 0.50              |
+------------+-------------------+
```

---

## Constraints

- Trips and Users tables as described above.
