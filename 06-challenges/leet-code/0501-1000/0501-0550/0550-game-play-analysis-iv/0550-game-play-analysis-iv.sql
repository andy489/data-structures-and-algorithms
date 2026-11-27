-- https://leetcode.com/problems/game-play-analysis-iv/
-- Solution: Fraction of players who logged in the day after their first login
SELECT ROUND(
    COUNT(DISTINCT a.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity),
    2
) AS fraction
FROM Activity a
JOIN (
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) first ON a.player_id = first.player_id
    AND a.event_date = DATE_ADD(first.first_login, INTERVAL 1 DAY);
