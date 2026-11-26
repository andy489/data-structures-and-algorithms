# 1341. Movie Rating — Solution

## SQL Solution
```sql
(SELECT u.name AS results
 FROM MovieRating mr JOIN Users u ON mr.user_id = u.user_id
 GROUP BY mr.user_id ORDER BY COUNT(*) DESC, u.name ASC LIMIT 1)
UNION ALL
(SELECT m.title AS results
 FROM MovieRating mr JOIN Movies m ON mr.movie_id = m.movie_id
 WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
 GROUP BY mr.movie_id ORDER BY AVG(mr.rating) DESC, m.title ASC LIMIT 1);
```
