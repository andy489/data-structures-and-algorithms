# 1407. Top Travellers

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/top-travellers/

---

## Problem Statement

SQL: Find the name and total distance travelled by each user, ordered by distance desc, then name asc. Users with no trips count as 0.

---

## Examples

**Example 1:**
```
Input:  Users: uid=1,name='Alice'; uid=2,name='Bob'; uid=3,name='Alex'; Trips: id=1,uid=1,distance=548; ...
Output: Alice 2520, Bob 1240, Alex 0
```

---

## Constraints

- `Users(id,name)`
- `Rides(id,uid,distance)`
