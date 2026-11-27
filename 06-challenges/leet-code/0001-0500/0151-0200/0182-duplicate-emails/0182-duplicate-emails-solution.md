# 182. Duplicate Emails — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/duplicate-emails/

---

## Solution 1: GROUP BY + HAVING — O(n) time, O(n) space

**Idea:** Group rows by `email` and keep only those groups where the count exceeds 1. `HAVING COUNT(*) > 1` is the canonical filter for aggregation conditions.

**Algorithm:**
1. `SELECT email AS Email FROM Person`
2. `GROUP BY email`
3. `HAVING COUNT(*) > 1`

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass for grouping |
| Space | O(n) — hash table for group aggregation |

---

## Solution 2: Self-join — O(n²) time, O(1) space

**Idea:** Join the table to itself on `email` where the IDs differ. Any email that appears in such a pair is a duplicate.

**Algorithm:**
1. `FROM Person p1 JOIN Person p2 ON p1.email = p2.email AND p1.id <> p2.id`
2. `SELECT DISTINCT p1.email AS Email`

**Complexity:**

| | |
|---|---|
| Time | O(n²) — cross-product then filter; O(n) with index on email |
| Space | O(1) — no intermediate storage beyond the result |
