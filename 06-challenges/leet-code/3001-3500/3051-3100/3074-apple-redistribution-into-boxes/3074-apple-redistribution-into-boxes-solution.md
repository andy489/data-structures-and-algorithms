# 3074. Apple Redistribution Into Boxes — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/apple-redistribution-into-boxes/

---

## Solution: Greedy (Sort Descending) — O(m log m) time, O(1) space

**Idea:** Total apples must fit. Sort capacity descending and pick boxes greedily until sum >= total.

**Algorithm:**
1. Compute total = sum(apple).
2. Sort capacity descending.
3. Greedily pick largest boxes until cumulative capacity >= total.
4. Return count.

**Complexity:**

| | |
|---|---|
| Time | O(m log m) — O(m log m) — sort |
| Space | O(1) — O(1) extra |
