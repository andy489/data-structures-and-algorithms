# 1148. Article Views I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/article-views-i/

---

## Solution: SQL

```sql
SELECT DISTINCT author_id AS id FROM Views WHERE author_id = viewer_id ORDER BY id
```

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
