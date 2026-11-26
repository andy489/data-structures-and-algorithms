# 1378. Replace Employee ID With The Unique Identifier — Solution

## SQL Solution
```sql
SELECT eu.unique_id, e.name
FROM Employees e
LEFT JOIN EmployeeUNI eu ON e.id = eu.id;
```
