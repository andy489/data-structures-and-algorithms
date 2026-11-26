# 1204. Last Person to Fit in the Bus — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/last-person-to-fit-in-the-bus/

---

## Solution: Running Sum + Subquery — O(n log n) time, O(n) space

**Idea:** Use a subquery to compute the cumulative weight (ordered by turn) for each person. Select the person with the highest turn where cumulative weight ≤ 1000.

**Algorithm:**
1. Compute running sum of weights ordered by turn.
2. Filter to rows where running_sum ≤ 1000.
3. Return person_name with max turn.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |


**SQL Solution:**
```sql
SELECT person_name
FROM (
    SELECT person_name, turn,
           SUM(weight) OVER (ORDER BY turn) AS running_weight
    FROM Queue
) t
WHERE running_weight <= 1000
ORDER BY turn DESC
LIMIT 1;
```