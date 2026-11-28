-- https://leetcode.com/problems/analyze-subscription-conversion/

-- Solution: GROUP BY with Conditional Aggregation — O(n) time, O(n) space
SELECT
    user_id,
    ROUND(AVG(CASE WHEN activity_type = 'free_trial' THEN activity_duration END), 2) AS trial_avg_duration,
    ROUND(AVG(CASE WHEN activity_type = 'paid' THEN activity_duration END), 2) AS paid_avg_duration
FROM UserActivity
GROUP BY user_id
HAVING
    SUM(CASE WHEN activity_type = 'free_trial' THEN 1 ELSE 0 END) > 0
    AND SUM(CASE WHEN activity_type = 'paid' THEN 1 ELSE 0 END) > 0
ORDER BY user_id ASC;
