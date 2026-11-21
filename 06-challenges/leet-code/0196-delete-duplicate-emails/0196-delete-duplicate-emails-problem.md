# 196. Delete Duplicate Emails

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/delete-duplicate-emails/

---

## Problem Statement

**Table: Person**

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| email       | varchar |
+-------------+---------+
```
`id` is the primary key. Each row contains an email. Emails will not contain uppercase letters.

Write a solution to **delete** all duplicate emails, keeping only one unique email with the **smallest `id`**.

---

## Example

**Input:**
```
Person: [[1,"john@example.com"],[2,"bob@example.com"],[3,"john@example.com"]]
```

**Output:**
```
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
```
