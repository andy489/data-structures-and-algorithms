# 3497. Analyze Subscription Conversion — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/analyze-subscription-conversion/

---

## Solution: GROUP BY with Conditional Aggregation — O(n) time, O(n) space

**Idea:** Use a single GROUP BY query with conditional aggregation to compute per-user averages for `free_trial` and `paid` activity durations. Filter to keep only users who have both `free_trial` and `paid` activities.

**Algorithm:**
1. Group by `user_id`.
2. Use `AVG(CASE WHEN activity_type = 'free_trial' THEN activity_duration END)` for trial average.
3. Use `AVG(CASE WHEN activity_type = 'paid' THEN activity_duration END)` for paid average.
4. Filter with `HAVING` to keep only users who have both `free_trial` and `paid` rows.
5. Order by `user_id` ascending.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
