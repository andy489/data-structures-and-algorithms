# 3436. Find Valid Emails — Solution

## Approach

Use a SQL query with a `REGEXP` (or `LIKE` with specific pattern matching) to filter valid emails.

A valid email matches the pattern:
- `^[a-zA-Z0-9_]+@[a-zA-Z]+\.com$`

Using MySQL's `REGEXP` operator:
```sql
SELECT user_id, email
FROM Users
WHERE email REGEXP '^[A-Za-z0-9_]+@[A-Za-z]+\\.com$'
ORDER BY user_id ASC;
```

**Key regex breakdown:**
- `^[A-Za-z0-9_]+` — local part: alphanumeric and underscore
- `@` — exactly one `@`
- `[A-Za-z]+` — domain: letters only
- `\\.com$` — ends with `.com`

**Time Complexity:** O(n) where n is number of rows
