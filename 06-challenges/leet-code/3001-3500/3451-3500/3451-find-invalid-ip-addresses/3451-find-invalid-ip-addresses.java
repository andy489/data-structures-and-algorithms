// https://leetcode.com/problems/find-invalid-ip-addresses/
// This is a SQL problem. See the .sql file for the solution.

// Solution: SQL Regex Validation — O(n) time, O(n) space
// SELECT ip, COUNT(*) AS invalid_count
// FROM logs
// WHERE ip NOT REGEXP '^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])$'
// GROUP BY ip
// ORDER BY invalid_count DESC, ip DESC;
