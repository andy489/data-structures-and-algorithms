# 3451. Find Invalid IP Addresses — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-invalid-ip-addresses/

---

## Solution: SQL Regex Validation — O(n) time, O(n) space

**Idea:** Use SQL string operations to split IP addresses into octets and validate each. An IP is invalid if it doesn't have exactly 4 dot-separated octets, any octet has a value > 255, or any octet has leading zeros.

**Algorithm:**
1. Use REGEXP to match IPs that do NOT conform to the valid IPv4 pattern.
2. A valid IP matches: each octet is either a single digit, two digits not starting with 0, or three digits (100-199 or 200-249 or 250-255).
3. Count occurrences of each invalid IP and order by invalid_count DESC, ip DESC.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |

```sql
SELECT
    ip,
    COUNT(*) AS invalid_count
FROM logs
WHERE ip NOT REGEXP '^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])$'
GROUP BY ip
ORDER BY invalid_count DESC, ip DESC;
```
